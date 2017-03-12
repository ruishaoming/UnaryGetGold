package com.rui.unarygetgold.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.library.BaseRecyclerAdapter;
import com.github.library.BaseViewHolder;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.rui.unarygetgold.R;
import com.rui.unarygetgold.base.BaseData;
import com.rui.unarygetgold.base.BaseFragment;
import com.rui.unarygetgold.base.ShowingPage;
import com.rui.unarygetgold.bean.HomeShopInfo;
import com.rui.unarygetgold.interfaces.ICallback;
import com.rui.unarygetgold.utils.CommonUtils;
import com.rui.unarygetgold.utils.UrlUtils;
import com.shuyu.frescoutil.FrescoHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import lib.lhh.fiv.library.FrescoImageView;

/**
 * Created by 芮靖林
 * on 2017/2/16 13:55.
 */

public class HomeShopFragment extends BaseFragment {
    @Bind(R.id.home_shop_recyclerView)
    RecyclerView mRecyclerView;
    private String order;

    @Override
    protected void onLoad() {
        order = getArguments().getString("order");
        new BaseData().getData(UrlUtils.BASE_URL, UrlUtils.RECOMMEND_URL + "&order=" + order, BaseData.NO_TIME, new ICallback() {
            @Override
            public void onResponse(String responseInfo) {
                HomeShopInfo homeShopInfo = new Gson().fromJson(responseInfo, HomeShopInfo.class);
                updateUI(homeShopInfo);
                setCurrentState(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            }

            @Override
            public void onFailure(String errorInfo) {
                setCurrentState(ShowingPage.StateType.STATE_LOAD_ERROR);
            }
        });
    }

    @Override
    public boolean setCurrentTitleView(ShowingPage showingPage) {
        return false;
    }

    @Override
    public View setCurrentSuccessView() {
        View rootView = CommonUtils.layoutInflate(getActivity(), R.layout.fragment_home_shop);
        ButterKnife.bind(this, rootView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return rootView;
    }

    public static Fragment getFragmentOrder(String order) {
        HomeShopFragment fragment = new HomeShopFragment();
        Bundle bundle = new Bundle();
        bundle.putString("order", order);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void updateUI(HomeShopInfo homeShopInfo) {
        mRecyclerView.setAdapter(new BaseRecyclerAdapter<HomeShopInfo.IndexDuobaoListBean>(getActivity(),homeShopInfo.getIndex_duobao_list(),R.layout.title_fm_rv_item) {
            @Override
            protected void convert(BaseViewHolder helper, HomeShopInfo.IndexDuobaoListBean item) {
                helper.setText(R.id.brief_tv,item.getBrief());
                helper.setText(R.id.progress_tv,item.getProgress()+"%");
                helper.setProgressMax(R.id.progressBar,100);
                helper.setProgress(R.id.progressBar,Integer.parseInt(item.getPrice()));
                FrescoImageView frescoImageView = helper.getView(R.id.frescoImageView);
                FrescoHelper.loadFrescoImage(frescoImageView,UrlUtils.BASE_URL+item.getIcon().substring(1),R.mipmap.default_img,false);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
