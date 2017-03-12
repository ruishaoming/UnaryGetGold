package com.rui.unarygetgold.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.rui.unarygetgold.R;
import com.rui.unarygetgold.adapter.NewJieXiaoAdapter;
import com.rui.unarygetgold.app.MyApplication;
import com.rui.unarygetgold.base.BaseData;
import com.rui.unarygetgold.base.BaseFragment;
import com.rui.unarygetgold.base.ShowingPage;
import com.rui.unarygetgold.bean.NewJieXiaoInfo;
import com.rui.unarygetgold.interfaces.ICallback;
import com.rui.unarygetgold.utils.UrlUtils;

import java.util.ArrayList;

/**
 * Created by 芮靖林
 * on 2017/2/14 15:34.
 * 夺宝
 */

public class NewJieXiaoFragment extends BaseFragment {

    private PullToRefreshListView mPullToRefreshListView;
    private int page = 1;
    private boolean isRefresh = true;
    private NewJieXiaoAdapter newJieXiaoAdapter;
    private ArrayList<NewJieXiaoInfo.ListBean> listBeanArrayList = new ArrayList<>();

    @Override
    public boolean setCurrentTitleView(ShowingPage showingPage) {

        return false;
    }

    @Override
    public View setCurrentSuccessView() {
        View rootView = View.inflate(getActivity(), R.layout.fragment_newjiexiao, null);
        mPullToRefreshListView = (PullToRefreshListView) rootView.findViewById(R.id.new_pullTorefreshLv);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    protected void onLoad() {
        initDatas();
    }

    /**
     * 加载数据
     */
    private void initDatas() {

        new BaseData().getData(UrlUtils.BASE_URL, UrlUtils.NEW_JIEXIAO + "&page=" + page, BaseData.NO_TIME, new ICallback() {
            @Override
            public void onResponse(String responseInfo) {
                setCurrentState(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                NewJieXiaoInfo newJieXiaoInfo = new Gson().fromJson(responseInfo, NewJieXiaoInfo.class);
                initPullToRefrshListView(newJieXiaoInfo);

            }

            @Override
            public void onFailure(String errorInfo) {
                setCurrentState(ShowingPage.StateType.STATE_LOAD_ERROR);
            }
        });
    }

    /**
     * 初始化下拉刷新 控件
     */
    private void initPullToRefrshListView(final NewJieXiaoInfo newJieXiaoInfo) {

        if (isRefresh) {
            listBeanArrayList.clear();
            listBeanArrayList.addAll(newJieXiaoInfo.list);
        } else {
            listBeanArrayList.addAll(newJieXiaoInfo.list);
        }
        if (newJieXiaoAdapter == null) {
            newJieXiaoAdapter = new NewJieXiaoAdapter(getActivity(), listBeanArrayList, newJieXiaoInfo);
            mPullToRefreshListView.setAdapter(newJieXiaoAdapter);
        } else {
            newJieXiaoAdapter.notifyDataSetChanged();
        }
        //设置上拉加载下拉刷新
        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                MyApplication.getHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isRefresh = true;
                        page = 1;
                        mPullToRefreshListView.onRefreshComplete();
                        initDatas();
                    }
                }, 2000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                MyApplication.getHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isRefresh = false;
                        page++;
                        initDatas();
                        mPullToRefreshListView.onRefreshComplete();
                    }
                }, 2000);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        newJieXiaoAdapter = null;
    }
}
