package com.rui.unarygetgold.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;

import com.rui.unarygetgold.R;
import com.rui.unarygetgold.module.PermissionModule;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by 芮靖林
 * on 2017/2/14 09:53.
 */

public class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //监听返回,设置动画效果
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
            overridePendingTransition(R.anim.xin_left, R.anim.xout_right);
        }
        return super.onKeyDown(keyCode, event);
    }

    //安卓6.0权限封装
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        //这里对应PermissionModule的onRequestPermissionsResult方法
        PermissionModule.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
