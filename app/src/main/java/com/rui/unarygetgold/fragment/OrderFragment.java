package com.rui.unarygetgold.fragment;

import android.view.View;

import com.rui.unarygetgold.R;
import com.rui.unarygetgold.base.BaseFragment;
import com.rui.unarygetgold.base.ShowingPage;
import com.rui.unarygetgold.utils.CommonUtils;

/**
 * Created by 芮靖林
 * on 2017/2/15 15:46.
 */

public class OrderFragment extends BaseFragment {

    @Override
    protected void onLoad() {

    }

    @Override
    public boolean setCurrentTitleView(ShowingPage showingPage) {
        return false;
    }

    @Override
    public View setCurrentSuccessView() {
        View rootView = CommonUtils.inflate(R.layout.fragment_find);
        return rootView;
    }
}
