package com.rui.unarygetgold.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rui.unarygetgold.interfaces.IOnResetShowingPage;

/**
 * Created by 芮靖林
 * on 2017/2/14 15:34.
 */

public abstract class BaseFragment extends Fragment {

    public ShowingPage showingPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //创建ShowingPage，展示
        showingPage =  new ShowingPage(getActivity()) {
            @Override
            public View setSuccessView() {
                return setCurrentSuccessView();
            }
            @Override
            public boolean setTitleView(ShowingPage showingPage) {
                return setCurrentTitleView(showingPage);
            }
        };

        return showingPage;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showingPage.setIOnResetShowingPage(new IOnResetShowingPage() {
            @Override
            public void onReset(View v) {
                onLoad();
            }
        });
        onLoad();
    }

    protected abstract void onLoad();

    //让子类创建Title
    public abstract boolean setCurrentTitleView(ShowingPage showingPage);

    //让子类创建成功的视图
    public abstract View setCurrentSuccessView();

    //设置当前的状态码
    public void setCurrentState(ShowingPage.StateType stateType) {
        if (showingPage != null) {
            showingPage.setCurrentState(stateType);
        }
    }
}
