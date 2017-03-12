package com.rui.unarygetgold.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 芮靖林
 * on 2017/2/17 18:08.
 */

public class CateGoryContentInfo {

    private CartInfoBean cart_info;
    private PageBean page;
    private String page_title;
    private String ctl;
    private String act;
    private int status;
    private String info;
    private String city_name;
    @SerializedName("return")
    private int returnX;
    private String sess_id;
    private Object ref_uid;
    private List<ListBean> list;

    public CartInfoBean getCart_info() {
        return cart_info;
    }

    public void setCart_info(CartInfoBean cart_info) {
        this.cart_info = cart_info;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public String getCtl() {
        return ctl;
    }

    public void setCtl(String ctl) {
        this.ctl = ctl;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getReturnX() {
        return returnX;
    }

    public void setReturnX(int returnX) {
        this.returnX = returnX;
    }

    public String getSess_id() {
        return sess_id;
    }

    public void setSess_id(String sess_id) {
        this.sess_id = sess_id;
    }

    public Object getRef_uid() {
        return ref_uid;
    }

    public void setRef_uid(Object ref_uid) {
        this.ref_uid = ref_uid;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class CartInfoBean {
        /**
         * cart_item_num : 0
         */

        private int cart_item_num;

        public int getCart_item_num() {
            return cart_item_num;
        }

        public void setCart_item_num(int cart_item_num) {
            this.cart_item_num = cart_item_num;
        }
    }

    public static class PageBean {
        /**
         * total : 439
         * page_size : 20
         */

        private String total;
        private int page_size;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public int getPage_size() {
            return page_size;
        }

        public void setPage_size(int page_size) {
            this.page_size = page_size;
        }
    }

    public static class ListBean {
        /**
         * progress : 16
         * id : 6272
         * unit_price : 1
         * name : 三网通用话费5元秒开
         * max_buy : 6
         * min_buy : 1
         * current_buy : 1
         * surplus_buy : 5
         * icon : https://s1.vbokai.com/public/attachment/201702/06/15/58982474f3fc6.png?x-oss-process=image/resize,m_fill,w_300,h_300
         */

        private String progress;
        private String id;
        private String unit_price;
        private String name;
        private String max_buy;
        private String min_buy;
        private String current_buy;
        private String surplus_buy;
        private String icon;

        public String getProgress() {
            return progress;
        }

        public void setProgress(String progress) {
            this.progress = progress;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUnit_price() {
            return unit_price;
        }

        public void setUnit_price(String unit_price) {
            this.unit_price = unit_price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMax_buy() {
            return max_buy;
        }

        public void setMax_buy(String max_buy) {
            this.max_buy = max_buy;
        }

        public String getMin_buy() {
            return min_buy;
        }

        public void setMin_buy(String min_buy) {
            this.min_buy = min_buy;
        }

        public String getCurrent_buy() {
            return current_buy;
        }

        public void setCurrent_buy(String current_buy) {
            this.current_buy = current_buy;
        }

        public String getSurplus_buy() {
            return surplus_buy;
        }

        public void setSurplus_buy(String surplus_buy) {
            this.surplus_buy = surplus_buy;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
