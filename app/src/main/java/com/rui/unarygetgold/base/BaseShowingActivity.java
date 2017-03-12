package com.rui.unarygetgold.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.rui.unarygetgold.interfaces.IOnResetShowingPage;
import com.rui.unarygetgold.module.PermissionModule;

/**
 * Created by 芮靖林
 * on 2017/2/15 09:01.
 */

public abstract class BaseShowingActivity extends BaseActivity {

    private ShowingPage showingPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showingPage = new ShowingPage(this) {
            @Override
            public View setSuccessView() {
                return setCurrentSuccessView();
            }

            @Override
            public boolean setTitleView(ShowingPage showingPage) {
                return setCurrentTitleView(showingPage);
            }
        };

        onLoad();
        showingPage.setIOnResetShowingPage(new IOnResetShowingPage() {
            @Override
            public void onReset(View v) {
                onLoad();
            }
        });

        //设置视图
        setContentView(showingPage);
    }

    protected abstract View setCurrentSuccessView();

    protected abstract boolean setCurrentTitleView(ShowingPage showingPage);

    protected abstract void onLoad();

    public void setCurrentViewState(ShowingPage.StateType state){
        if (showingPage!=null){
            showingPage.setCurrentState(state);
        }
    }


}
