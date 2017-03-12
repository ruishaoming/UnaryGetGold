package com.rui.unarygetgold.utils;

/**
 * Created by 芮靖林
 * on 2016/12/28.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.rui.unarygetgold.R;
import com.rui.unarygetgold.app.MyApplication;

public class CommonUtils {
    public static final String TAG = "daily_study";
    private static SharedPreferences sharedPreferences;
    private static Context context = MyApplication.getContext();

    public static View inflate(int layoutId) {
        View view = View.inflate(MyApplication.getContext(), layoutId, null);
        return view;
    }

    public static View layoutInflate(Context context, int layoutId) {
        return LayoutInflater.from(context).inflate(layoutId, null);
    }

    /**
     * dip---px
     *
     * @param dip
     * @return
     */
    public static int dip2px(int dip) {
        //获取像素密度
        float density = MyApplication.getContext().getResources().getDisplayMetrics().density;
        //
        int px = (int) (dip * density + 0.5f);
        return px;

    }

    /**
     * px-dip
     *
     * @param px
     * @return
     */
    public static int px2dip(int px) {
        //获取像素密度
        float density = MyApplication.getContext().getResources().getDisplayMetrics().density;
        //
        int dip = (int) (px / density + 0.5f);
        return dip;
    }

    public static String getDimens(int stringId) {
        return MyApplication.getContext().getResources().getString(stringId);
    }

    public static Drawable getDrawable(int did) {
        return MyApplication.getContext().getResources().getDrawable(did
        );
    }

    public static void saveSp(String flag, String str) {
        if (sharedPreferences == null) {
            sharedPreferences = MyApplication.getContext().getSharedPreferences(TAG, MyApplication.getContext().MODE_PRIVATE);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(flag, str);
        edit.commit();
    }

    public static String getSp(String flag) {
        if (sharedPreferences == null) {
            sharedPreferences = MyApplication.getContext().getSharedPreferences(TAG, MyApplication.getContext().MODE_PRIVATE);
        }
        return sharedPreferences.getString(flag, "");
    }

    public static boolean getBoolean(String tag) {
        if (sharedPreferences == null) {
            sharedPreferences = MyApplication.getContext().getSharedPreferences(TAG, MyApplication.getContext().MODE_PRIVATE);
        }
        return sharedPreferences.getBoolean(tag, false);
    }

    public static void putBoolean(String tag, boolean content) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(TAG, context.MODE_PRIVATE);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(tag, content);
        edit.commit();
    }

    public static void clearSp(String tag) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(TAG, context.MODE_PRIVATE);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(tag);
        edit.commit();
    }

    public static void runOnUIThread(Runnable runable) {
        //先判断当前属于子线程主线程
        if (android.os.Process.myTid() == MyApplication.getMainThreadId()) {
            runable.run();
        } else {
            //子线程
            MyApplication.getHandler().post(runable);
        }
    }

    /**
     * 使用线程池执行runnable
     *
     * @param runnable
     */
    public static void executeRunnalbe(Runnable runnable) {
        MyApplication.getThreadPool().execute(runnable);
    }

    public static Context getContext() {
        return context;
    }

    //跳转的方法
    public static void startActivity(Activity activity, Class goTo) {
        Intent intent = new Intent(activity, goTo);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.xin_right, R.anim.xout_left);
    }

    //返回
    public static void finishActivity(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.xin_left, R.anim.xout_right);
    }

    public static String getText(TextView v) {
        return v.getText().toString().trim();
    }

    //设置FloatingButton显示 隐藏的动画
//    public static void setFabAnim(final Context context, RecyclerView recyclerView, final FloatingActionButton floatingActionButton) {
//        recyclerView.addOnScrollListener(new HidingScrollListener() {
//            @Override
//            public void onHide() {
//                Resources resources = context.getResources();
//                DisplayMetrics dm = resources.getDisplayMetrics();
//                int height = dm.heightPixels;
//                floatingActionButton.animate()
//                        .translationY(height - floatingActionButton.getHeight())
//                        .setInterpolator(new AccelerateInterpolator(2))
//                        .setDuration(500)
//                        .start();
//            }
//
//            @Override
//            public void onShow() {
//                floatingActionButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).setDuration(500).start();
//            }
//        });
//    }
}
