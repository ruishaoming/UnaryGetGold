package com.rui.unarygetgold.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.rui.unarygetgold.R;
import com.rui.unarygetgold.base.BaseData;
import com.rui.unarygetgold.base.BaseFragment;
import com.rui.unarygetgold.base.ShowingPage;
import com.rui.unarygetgold.bean.CateGoryContentInfo;
import com.rui.unarygetgold.bean.CateGoryTitleInfo;
import com.rui.unarygetgold.interfaces.ICallback;
import com.rui.unarygetgold.utils.CommonUtils;
import com.rui.unarygetgold.utils.UrlUtils;
import com.shuyu.frescoutil.FrescoHelper;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import lib.lhh.fiv.library.FrescoImageView;

/**
 * Created by 芮靖林
 * on 2017/2/14 15:34.
 */

public class CateGoryFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    @Bind(R.id.category_listView)
    ListView mLeftListView;
    @Bind(R.id.pull_refresh_list)
    PullToRefreshListView mPullRefreshLv;
    private CommonAdapter mLeftLvAdapter;
    private CateGoryTitleInfo titleInfo;
    private int page = 1;
    @Override
    public boolean setCurrentTitleView(ShowingPage showingPage) {
        return false;
    }

    @Override
    public View setCurrentSuccessView() {
        View rootView = CommonUtils.inflate(R.layout.fragment_category);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void onLoad() {

        //请求左边标题的数据
        new BaseData().getData(UrlUtils.BASE_URL, UrlUtils.CATEGORY_URL, BaseData.SHORT_TIME, new ICallback() {
            @Override
            public void onResponse(String responseInfo) {
                titleInfo = new Gson().fromJson(responseInfo, CateGoryTitleInfo.class);
                //设置listView设配器
                initLeftTitle();
                initRightShop(page, titleInfo.getList().get(0).getId());
                setCurrentState(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            }

            @Override
            public void onFailure(String errorInfo) {

            }
        });

    }

    private void initRightShop(int page, String id) {
        new BaseData().getData(UrlUtils.BASE_URL, UrlUtils.CATEGORY_CONTENT + "&page=" + page + "&data_id=" + id, BaseData.SHORT_TIME, new ICallback() {
            @Override
            public void onResponse(String responseInfo) {
                CateGoryContentInfo cateGoryContentInfo = new Gson().fromJson(responseInfo, CateGoryContentInfo.class);
                mPullRefreshLv.setAdapter(new CommonAdapter<CateGoryContentInfo.ListBean>(getActivity(), R.layout.category_title_conter_item, cateGoryContentInfo.getList()) {
                    @Override
                    protected void convert(ViewHolder viewHolder, CateGoryContentInfo.ListBean item, int position) {
                        viewHolder.setText(R.id.name_tv, item.getName());
                        viewHolder.setText(R.id.max_buy_tv, item.getMax_buy());
                        viewHolder.setText(R.id.surplus_buy, item.getSurplus_buy());
                        ProgressBar progressBar = viewHolder.getView(R.id.goodsCate_progressBar);
                        FrescoImageView frescoImageView = viewHolder.getView(R.id.goodsCate_frescoImageView);
                        progressBar.setProgress(Integer.parseInt(item.getProgress()));
                        FrescoHelper.loadFrescoImage(frescoImageView, item.getIcon(), R.mipmap.default_img, false);
//                        viewHolder.setText(R.id.addParticipants_tv,item.get);

                    }
                });
                setCurrentState(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            }

            @Override
            public void onFailure(String errorInfo) {
                setCurrentState(ShowingPage.StateType.STATE_LOAD_ERROR);
            }
        });

        mPullRefreshLv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }

    //设置左侧标题
    private void initLeftTitle() {
        titleInfo.getList().get(0).setChecked(true);
        mLeftLvAdapter = new CommonAdapter<CateGoryTitleInfo.ListBean>(getActivity(), R.layout.category_title_item, titleInfo.getList()) {
            @Override
            protected void convert(ViewHolder viewHolder, CateGoryTitleInfo.ListBean item, int position) {
                TextView bg_tv = viewHolder.getView(R.id.bg_tv);
                TextView titlt_tv = viewHolder.getView(R.id.titlt_tv);
                View view = viewHolder.getView(R.id.category_itme);

                if (item.isChecked()) {
                    bg_tv.setVisibility(View.VISIBLE);
                    view.setBackgroundColor(Color.WHITE);
                } else {
                    bg_tv.setVisibility(View.GONE);
                    view.setBackgroundColor(getActivity().getResources().getColor(R.color.category_titles));
                }
                titlt_tv.setText(item.getName());

            }
        };
        mLeftListView.setAdapter(mLeftLvAdapter);
        mLeftListView.setOnItemClickListener(this);
    }

    //条目点击事件
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.category_listView:
                //重置右侧商品
                initRightShop(page, titleInfo.getList().get(i).getId());
                //设置选中标记
                for (int j = 0; j < titleInfo.getList().size(); j++) {
                    if (j == i) {
                        titleInfo.getList().get(j).setChecked(true);
                    } else {
                        titleInfo.getList().get(j).setChecked(false);
                    }
                }
                mLeftLvAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
