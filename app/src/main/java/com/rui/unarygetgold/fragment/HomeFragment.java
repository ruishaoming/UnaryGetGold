package com.rui.unarygetgold.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.rui.unarygetgold.R;
import com.rui.unarygetgold.base.BaseData;
import com.rui.unarygetgold.base.BaseFragment;
import com.rui.unarygetgold.base.ShowingPage;
import com.rui.unarygetgold.bean.HomeInfo;
import com.rui.unarygetgold.interfaces.ICallback;
import com.rui.unarygetgold.module.FrescoImageLoader;
import com.rui.unarygetgold.module.TitleBuilder;
import com.rui.unarygetgold.utils.CommonUtils;
import com.rui.unarygetgold.utils.UrlUtils;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 芮靖林
 * on 2017/2/14 15:34.
 * 夺宝
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.snatch_banner)
    Banner mBanner;
    @Bind(R.id.tablayout_snatch)
    TabLayout mTabLayout;
    @Bind(R.id.vp_snatch)
    ViewPager mViewPager;
    private List<String> bannerList = new ArrayList<>();
    private String[] tabTitle = {"最热", "最新", "最快", "商价", "低价"};
    private View rootView;

    @Override
    public boolean setCurrentTitleView(ShowingPage showingPage) {
        new TitleBuilder(showingPage).setLeftImageRes(R.mipmap.handlericon).setRightImageRes(R.mipmap.shareicon).build();
        return true;
    }

    @Override
    public View setCurrentSuccessView() {
//         rootView = View.inflate(getActivity(),R.layout.fragment_snatch,null);
        rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_snatch, null);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void onLoad() {
        new BaseData().getData(UrlUtils.BASE_URL, UrlUtils.HOME_URL, BaseData.NO_TIME, new ICallback() {
            @Override
            public void onResponse(String responseInfo) {
                HomeInfo homeInfo = new Gson().fromJson(responseInfo, HomeInfo.class);
                setCurrentState(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                updateUI(homeInfo);
            }

            @Override
            public void onFailure(String errorInfo) {
                setCurrentState(ShowingPage.StateType.STATE_LOAD_ERROR);
            }
        });
    }

    //更新界面
    private void updateUI(HomeInfo homeInfo) {

        //头部轮播图
        for (int i = 0; i < homeInfo.getAdvs().size(); i++) {
            bannerList.add(homeInfo.getAdvs().get(i).getImg());
        }
        mBanner.setBannerAnimation(Transformer.RotateDown).setImageLoader(new FrescoImageLoader()).setImages(bannerList).setDelayTime(3000).start();

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return HomeShopFragment.getFragmentOrder(position + "");
            }

            @Override
            public int getCount() {
                return tabTitle.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitle[position];
            }
        };

        mViewPager.setAdapter(fragmentPagerAdapter);

        //设置TabLayour与Fragment的关联
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
