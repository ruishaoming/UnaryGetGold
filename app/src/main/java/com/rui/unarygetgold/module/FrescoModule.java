package com.rui.unarygetgold.module;


import android.net.Uri;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.rui.unarygetgold.R;
import com.rui.unarygetgold.app.MyApplication;

/**
 * Created by 芮靖林
 * on 2017/2/14 11:05.
 */

public class FrescoModule {

    //普通的图片加载
    public static void loadSimpleImage(SimpleDraweeView draweeView, String uri_path) {
        Uri uri =  Uri.parse(uri_path);
        draweeView.setImageURI(uri);
    }

    public static void loadImage(Uri uri, SimpleDraweeView view) {
        GenericDraweeHierarchy hierarchy =
                new GenericDraweeHierarchyBuilder(MyApplication.getContext().getResources())
                        .setFadeDuration(300)
                        .setPlaceholderImage(R.mipmap.ic_launcher)
                        .setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE)
                        .setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE)
                        .build();
        view.setHierarchy(hierarchy);
        view.setImageURI(uri);
    }

}
