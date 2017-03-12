package com.rui.unarygetgold.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 芮靖林
 * on 2017/2/14 10:45.
 */

public class MyApplication extends Application {

    private static Context context;
    private static Handler handler;
    private static int mainThreadId;
    private static ExecutorService threadPool;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        handler = new Handler();//创建Handle
        mainThreadId = Process.myTid();//得到主线程id
        threadPool = Executors.newFixedThreadPool(5);//创建线程池

        //Fresco初始化
        Fresco.initialize(this);

    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static ExecutorService getThreadPool() {
        return threadPool;
    }

}
