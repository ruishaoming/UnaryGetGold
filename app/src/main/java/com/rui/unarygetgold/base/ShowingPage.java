package com.rui.unarygetgold.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.rui.unarygetgold.R;
import com.rui.unarygetgold.app.MyApplication;
import com.rui.unarygetgold.interfaces.IOnResetShowingPage;
import com.rui.unarygetgold.utils.CommonUtils;
import com.rui.unarygetgold.utils.NetUtils;
import com.zhy.autolayout.AutoRelativeLayout;


/**
 * Created by 芮靖林
 * on 2016/12/28.
 */
public abstract class ShowingPage extends FrameLayout implements View.OnClickListener {

    /**
     * 定义状态
     */

    public static final int STATE_LOADING = 1;
    public static final int STATE_LOAD_ERROR = 2;
    public static final int STATE_LOAD_SUCCESS = 3;
    private final Context context;

    //定义当前状态
    public int currentState = STATE_LOADING;//得到当前的状态
    private final View view;
    private final View showLoadError, showLoading;
    private final FrameLayout showFrameLayout;
    private final AutoRelativeLayout titleLayout;

    private IOnResetShowingPage iOnResetShowingPage;

    public ShowingPage(Context context) {
        super(context);
        this.context = context;

        //获取主布局视图
        view = View.inflate(context, R.layout.showing_pager, null);
        //标题栏
        titleLayout = (AutoRelativeLayout) view.findViewById(R.id.title_bar);
        //错误视图
        showLoadError = view.findViewById(R.id.showLoadError);
        showLoadError.findViewById(R.id.showing_error_tv_reset).setOnClickListener(this);
        //正在加载
        showLoading = view.findViewById(R.id.showLoading);
        //成功视图的容器
        showFrameLayout = (FrameLayout) view.findViewById(R.id.showSuccessView);

        this.addView(view);

        //添加成功的视图
        showFrameLayout.addView(setSuccessView());

        //设置是否需要Title
        titleLayout.setVisibility(setTitleView(this) ? VISIBLE : GONE);

        showPage();
    }

    //添加成功的视图
    public abstract View setSuccessView();

    //添加Title(如果返回true，则需要在此方法中添加标题，否则默认无标题)
    public abstract boolean setTitleView(ShowingPage showingPage);

    public void setCurrentState(StateType stateType) {
        currentState = stateType.currentState;
        showPage();
    }

    private void showPage() {
        //在主线程执行
        CommonUtils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                showPageOnUI();
            }
        });
    }

    private void showPageOnUI() {
        showLoading.setVisibility(currentState == STATE_LOADING ? View.VISIBLE : View.GONE);
        showLoadError.setVisibility(currentState == STATE_LOAD_ERROR ? View.VISIBLE : View.GONE);
        showFrameLayout.setVisibility(currentState == STATE_LOAD_SUCCESS ? View.VISIBLE : View.GONE);

    }
//    if (currentState == STATE_LOADING) {
//            whenStateisError();
//        }
//    private void whenStateisError() {
//        CommonUtils.executeRunnalbe(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (currentState == STATE_LOADING) {
//                    currentState = STATE_LOAD_ERROR;
//                    showPage();
//                }
//            }
//        });
//    }

    public void setIOnResetShowingPage(IOnResetShowingPage iOnResetShowingPage) {
        this.iOnResetShowingPage = iOnResetShowingPage;
    }

    /**
     * 枚举类
     */
    public enum StateType {
        //请求类型
        STATE_LOADING(1), STATE_LOAD_ERROR(2), STATE_LOAD_SUCCESS(3);
        private final int currentState;

        StateType(int currentState) {
            this.currentState = currentState;
        }

        public int getCurrentState() {
            return currentState;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //重新请求
            case R.id.showing_error_tv_reset:
                //如果点击且有网络
                this.setCurrentState(StateType.STATE_LOADING);
                if (!NetUtils.isNoNet() && iOnResetShowingPage != null) {
                    iOnResetShowingPage.onReset(v);
                } else {
                    MyApplication.getHandler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ShowingPage.this.setCurrentState(StateType.STATE_LOAD_ERROR);
                        }
                    }, 1500);
                }
                break;
        }
    }
}
