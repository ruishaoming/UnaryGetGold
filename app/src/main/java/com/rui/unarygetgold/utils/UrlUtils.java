package com.rui.unarygetgold.utils;

/**
 * Created by 芮靖林
 * on 2017/2/15 15:29.
 */

public class UrlUtils {

    public static final String BASE_URL = "https://y.api.ikaiwan.com/";

    //首页的URL
    public static final String HOME_URL = BASE_URL + "api.php?ctl=Index&act=index&v=3";

    //首页底部条目
    public static final String HOME_LIST_URL = BASE_URL + "api.php?act=index_duobao_list&v=3";

    //首页最新、最快
    public static String RECOMMEND_URL = "http://y.api.ikaiwan.com/api.php?act=index_duobao_list&v=3api.php?act=index_duobao_list&v=3";

    //分类标题
    public static String CATEGORY_URL = "http://y.api.ikaiwan.com/api.php?ctl=cate";

    //分类标题对应的数据 后面拼接（+ "&page=" + page + "&data_id=" + id）
    public static String CATEGORY_CONTENT = "http://y.api.ikaiwan.com/api.php?ctl=duobaos&uid=10949";

    //最新揭晓
    public static final String NEW_JIEXIAO = "http://y.api.ikaiwan.com/api.php?ctl=anno&v=3";

    //获取验证码
    public static final String GETCODE = "/api.php?ctl=ajax&act=send_sms_code&mobile=";

    //登陆
    public static final String REGISTER_URL = "api.php?ctl=user&act=dophregister";

}
