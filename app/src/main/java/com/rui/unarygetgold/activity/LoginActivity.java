package com.rui.unarygetgold.activity;

import android.Manifest;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rui.unarygetgold.R;
import com.rui.unarygetgold.base.BaseShowingActivity;
import com.rui.unarygetgold.base.ShowingPage;
import com.rui.unarygetgold.module.PermissionModule;
import com.rui.unarygetgold.module.TitleBuilder;
import com.rui.unarygetgold.utils.CommonUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseShowingActivity {

    @Bind(R.id.user_iv)
    ImageView userIv;
    @Bind(R.id.id_name_login_et)
    EditText mIdNameLoginEt;
    @Bind(R.id.id_delete_content_icon)
    ImageView mIdDeleteContentIcon;
    @Bind(R.id.id_user_RLayout)
    AutoRelativeLayout idUserRLayout;
    @Bind(R.id.line_user)
    View lineUser;
    @Bind(R.id.password_iv)
    ImageView passwordIv;
    @Bind(R.id.id_passWord_login_et)
    EditText mIdPassWordLoginEt;
    @Bind(R.id.id_look_content_cb)
    CheckBox idLookContentCb;
    @Bind(R.id.id_passWord_RLayout)
    AutoRelativeLayout idPassWordRLayout;
    @Bind(R.id.id_noKnowPassword_tv)
    TextView idNoKnowPasswordTv;
    @Bind(R.id.id_login_but)
    Button mIdLoginBut;
    @Bind(R.id.id_divider_left_login)
    View idDividerLeftLogin;
    @Bind(R.id.id_one_key_login_tv)
    TextView idOneKeyLoginTv;
    @Bind(R.id.id_divider_right_login)
    View idDividerRightLogin;
    @Bind(R.id.id_weiXin_login_iv)
    ImageView mIdWeiXinLoginIv;
    @Bind(R.id.id_qq_login_iv)
    ImageView mIdQqLoginIv;
    @Bind(R.id.id_WeiXin_tv)
    TextView idWeiXinTv;
    @Bind(R.id.id_QQ_tv)
    TextView idQQTv;
    @Bind(R.id.activity_login)
    AutoRelativeLayout activityLogin;

    @Override
    protected View setCurrentSuccessView() {
        View rootView = CommonUtils.layoutInflate(this, R.layout.activity_login);
        ButterKnife.bind(rootView);
        return rootView;
    }

    @Override
    protected boolean setCurrentTitleView(ShowingPage showingPage) {
        new TitleBuilder(showingPage).setMiddleText("登录",0).setLeftImageRes(R.mipmap.jiantou).setLeftImageListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        }).setRightText("快速注册",0).setRightTextListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtils.startActivity(LoginActivity.this,RegisterActivity.class);
            }
        }).build();
        return true;
    }

    @Override
    protected void onLoad() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        setCurrentViewState(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @OnClick({ R.id.id_login_but, R.id.id_weiXin_login_iv, R.id.id_qq_login_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_login_but:
                break;
            case R.id.id_weiXin_login_iv:
                break;
            case R.id.id_qq_login_iv:
                break;
        }
    }
}
