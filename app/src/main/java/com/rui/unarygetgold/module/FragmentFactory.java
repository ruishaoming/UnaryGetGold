package com.rui.unarygetgold.module;

import android.support.v4.app.Fragment;

import com.rui.unarygetgold.fragment.OrderFragment;
import com.rui.unarygetgold.fragment.MineFragment;
import com.rui.unarygetgold.fragment.NewJieXiaoFragment;
import com.rui.unarygetgold.fragment.CateGoryFragment;
import com.rui.unarygetgold.fragment.HomeFragment;

import java.util.LinkedHashMap;

/**
 * Created by 芮靖林
 * on 2017/2/14 15:47.
 */

public class FragmentFactory {

    private static LinkedHashMap<Integer, Fragment> map = new LinkedHashMap<>();

    public static Fragment getFragment(int position) {
        Fragment fragment = map.get(position);
        if (fragment != null) {
            return fragment;
        }

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new CateGoryFragment();
                break;
            case 2:
                fragment = new NewJieXiaoFragment();
                break;
            case 3:
                fragment = new OrderFragment();
                break;
            case 4:
                fragment = new MineFragment();
                break;
        }
        map.put(position, fragment);
        return fragment;
    }

}
