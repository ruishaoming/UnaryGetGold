package com.rui.unarygetgold.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rui.unarygetgold.R;
import com.rui.unarygetgold.activity.LoginActivity;
import com.rui.unarygetgold.base.BaseFragment;
import com.rui.unarygetgold.base.ShowingPage;
import com.rui.unarygetgold.module.TitleBuilder;
import com.rui.unarygetgold.utils.CommonUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import static com.rui.unarygetgold.R.id.id_address_RLayout;

/**
 * Created by 芮靖林
 * on 2017/2/14 15:34.
 * 夺宝
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private TextView id_not_loginUser_tv;
    private TextView id_my_personData_tv;
    private TextView id_integral_tv;
    private TextView id_red_packet_tv;
    private TextView id_remaining_sum_tv;
    private ImageView id_top_up_money_iv;
    private AutoRelativeLayout id_gold_record_rLayout;
    private AutoRelativeLayout id_win_record_rLayout;
    private AutoRelativeLayout id_order_share_rLayout;
    private ImageView id_my_photo_iv;
    private AutoRelativeLayout id_invite_friend__rLayout;
    private AutoRelativeLayout id_address_rLayout;


    @Override
    public boolean setCurrentTitleView(ShowingPage showingPage) {
        new TitleBuilder(showingPage).setMiddleText("我的", 0).setMostRightImageRes(R.mipmap.icon_setting).setLeftImageRes(R.mipmap.icon_inform).build();
        return true;
    }

    @Override
    public View setCurrentSuccessView() {
        View rootView = CommonUtils.layoutInflate(getActivity(), R.layout.mine_fragment);
        initView(rootView);
        return rootView;
    }

    private void initView(View view) {
        //用户头像
        id_my_photo_iv = (ImageView) view.findViewById(R.id.id_my_photo_iv);
        id_not_loginUser_tv = (TextView) view.findViewById(R.id.id_not_loginUser_tv);               //请点击登陆
        id_my_personData_tv = (TextView) view.findViewById(R.id.id_my_personData_tv);               //个人资料

        id_not_loginUser_tv.setOnClickListener(this);//请点击登陆

        //积分   红包  余额    充值
        id_integral_tv = (TextView) view.findViewById(R.id.id_integral_tv);                         //积分
        id_red_packet_tv = (TextView) view.findViewById(R.id.id_red_packet_tv);                     //红包
        id_remaining_sum_tv = (TextView) view.findViewById(R.id.id_remaining_sum_tv);               //余额
        id_top_up_money_iv = (ImageView) view.findViewById(R.id.id_top_up_money_iv);                //充值


        id_gold_record_rLayout = (AutoRelativeLayout) view.findViewById(R.id.id_gold_record_RLayout);                       //夺宝记录
        id_win_record_rLayout = (AutoRelativeLayout) view.findViewById(R.id.id_win_record_RLayout);                         //中奖记录
        id_order_share_rLayout = (AutoRelativeLayout) view.findViewById(R.id.id_order_share_RLayout);                       //晒单分享
        id_invite_friend__rLayout = (AutoRelativeLayout) view.findViewById(R.id.id_invite_friend__RLayout);                 //邀请好友
        id_address_rLayout = (AutoRelativeLayout) view.findViewById(id_address_RLayout);                                    //收货地址
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    protected void onLoad() {
        setCurrentState(ShowingPage.StateType.STATE_LOAD_SUCCESS);
//        new BaseData().getData("https://www.baidu.com/", "https://www.baidu.com", BaseData.NO_TIME, new ICallback() {
//            @Override
//            public void onResponse(String responseInfo) {
//                textView.setText(responseInfo);
//                setCurrentState(ShowingPage.StateType.STATE_LOAD_SUCCESS);
//            }
//
//            @Override
//            public void onFailure(String errorInfo) {
//                setCurrentState(ShowingPage.StateType.STATE_LOAD_ERROR);
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_not_loginUser_tv:      //请点击登陆
                CommonUtils.startActivity(getActivity(), LoginActivity.class);
                break;
        }
    }
}
