package com.rui.unarygetgold;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.rui.unarygetgold.base.BaseActivity;
import com.rui.unarygetgold.module.FragmentFactory;
import com.rui.unarygetgold.views.NoScrollViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @Bind(R.id.main_bottom_rg)
    RadioGroup mainBottomRg;
    @Bind(R.id.main_vp)
    NoScrollViewPager mainVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return FragmentFactory.getFragment(position);
            }

            @Override
            public int getCount() {
                return 5;
            }
        });

        mainBottomRg.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < mainBottomRg.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) mainBottomRg.getChildAt(i);
            if (radioButton.getId()==checkedId){
                radioButton.setChecked(true);
                mainVp.setCurrentItem(i);
            }else {
                radioButton.setChecked(false);
            }
        }
    }

    //监听退出
    private long exitTime = 0;
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 1500){
                Toast.makeText(getApplicationContext(), "再按一次后退键退出", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                //退出代码
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
