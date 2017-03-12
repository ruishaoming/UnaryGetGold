package com.rui.unarygetgold.bean;

import java.util.List;

/**
 * Created by 芮靖林
 * on 2017/2/15 15:42.
 */

public class HomeInfo {

    private String http_host;
    private int now_time;
    private PayStatusBean pay_status;
    private String status;
    private List<AdvsBean> advs;
    private List<IndexsBean> indexs;
    private List<NewestDoubaoListBean> newest_doubao_list;
    private List<NewestLotteryListBean> newest_lottery_list;

    public String getHttp_host() {
        return http_host;
    }

    public void setHttp_host(String http_host) {
        this.http_host = http_host;
    }

    public int getNow_time() {
        return now_time;
    }

    public void setNow_time(int now_time) {
        this.now_time = now_time;
    }

    public PayStatusBean getPay_status() {
        return pay_status;
    }

    public void setPay_status(PayStatusBean pay_status) {
        this.pay_status = pay_status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AdvsBean> getAdvs() {
        return advs;
    }

    public void setAdvs(List<AdvsBean> advs) {
        this.advs = advs;
    }

    public List<IndexsBean> getIndexs() {
        return indexs;
    }

    public void setIndexs(List<IndexsBean> indexs) {
        this.indexs = indexs;
    }

    public List<NewestDoubaoListBean> getNewest_doubao_list() {
        return newest_doubao_list;
    }

    public void setNewest_doubao_list(List<NewestDoubaoListBean> newest_doubao_list) {
        this.newest_doubao_list = newest_doubao_list;
    }

    public List<NewestLotteryListBean> getNewest_lottery_list() {
        return newest_lottery_list;
    }

    public void setNewest_lottery_list(List<NewestLotteryListBean> newest_lottery_list) {
        this.newest_lottery_list = newest_lottery_list;
    }

    public static class PayStatusBean {
        /**
         * ali : 1
         * weixin : 1
         * yl : 1
         */

        private String ali;
        private String weixin;
        private String yl;

        public String getAli() {
            return ali;
        }

        public void setAli(String ali) {
            this.ali = ali;
        }

        public String getWeixin() {
            return weixin;
        }

        public void setWeixin(String weixin) {
            this.weixin = weixin;
        }

        public String getYl() {
            return yl;
        }

        public void setYl(String yl) {
            this.yl = yl;
        }
    }

    public static class AdvsBean {
        /**
         * ctl : cate
         * data : {}
         * id : 36
         * img : https://s1.vbokai.com/public/attachment/201701/21/13/5882f6edd0ca8.png
         * name : banner汽车
         * type : 1
         * url :
         */

        private String ctl;
        private DataBean data;
        private String id;
        private String img;
        private String name;
        private String type;
        private String url;

        public String getCtl() {
            return ctl;
        }

        public void setCtl(String ctl) {
            this.ctl = ctl;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public static class DataBean {
        }
    }

    public static class IndexsBean {
        /**
         * color : #d93a56
         * ctl : cate
         * data : {}
         * icon_name : 
         * id : 80
         * name : 分类
         * type : 1
         */

        private String color;
        private String ctl;
        private DataBeanX data;
        private String icon_name;
        private String id;
        private String name;
        private String type;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getCtl() {
            return ctl;
        }

        public void setCtl(String ctl) {
            this.ctl = ctl;
        }

        public DataBeanX getData() {
            return data;
        }

        public void setData(DataBeanX data) {
            this.data = data;
        }

        public String getIcon_name() {
            return icon_name;
        }

        public void setIcon_name(String icon_name) {
            this.icon_name = icon_name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static class DataBeanX {
        }
    }

    public static class NewestDoubaoListBean {
        /**
         * has_lottery : 0
         * icon : https://s1.vbokai.com/public/attachment/201702/06/15/5898239d68671.png?x-oss-process=image/resize,m_fill,w_420,h_420
         * id : 6048
         * lottery_sn : 0
         * lottery_time : 1487115983
         * luck_user_id : 0
         * luck_user_name :
         */

        private String has_lottery;
        private String icon;
        private String id;
        private String lottery_sn;
        private String lottery_time;
        private String luck_user_id;
        private String luck_user_name;

        public String getHas_lottery() {
            return has_lottery;
        }

        public void setHas_lottery(String has_lottery) {
            this.has_lottery = has_lottery;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLottery_sn() {
            return lottery_sn;
        }

        public void setLottery_sn(String lottery_sn) {
            this.lottery_sn = lottery_sn;
        }

        public String getLottery_time() {
            return lottery_time;
        }

        public void setLottery_time(String lottery_time) {
            this.lottery_time = lottery_time;
        }

        public String getLuck_user_id() {
            return luck_user_id;
        }

        public void setLuck_user_id(String luck_user_id) {
            this.luck_user_id = luck_user_id;
        }

        public String getLuck_user_name() {
            return luck_user_name;
        }

        public void setLuck_user_name(String luck_user_name) {
            this.luck_user_name = luck_user_name;
        }
    }

    public static class NewestLotteryListBean {
        /**
         * avatar : ./public/avatar/000/00/96/47585b9f33003fb.jpg
         * id : 6070
         * lottery_time : 1487109856
         * luck_user_id : 9647
         * max_buy : 6
         * name : 三网通用话费5元秒开
         * span_time : 2小时前
         * user_name : 马倩
         */

        private String avatar;
        private String id;
        private String lottery_time;
        private String luck_user_id;
        private String max_buy;
        private String name;
        private String span_time;
        private String user_name;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLottery_time() {
            return lottery_time;
        }

        public void setLottery_time(String lottery_time) {
            this.lottery_time = lottery_time;
        }

        public String getLuck_user_id() {
            return luck_user_id;
        }

        public void setLuck_user_id(String luck_user_id) {
            this.luck_user_id = luck_user_id;
        }

        public String getMax_buy() {
            return max_buy;
        }

        public void setMax_buy(String max_buy) {
            this.max_buy = max_buy;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpan_time() {
            return span_time;
        }

        public void setSpan_time(String span_time) {
            this.span_time = span_time;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
    }
}
