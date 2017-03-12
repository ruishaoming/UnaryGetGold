package com.rui.unarygetgold.bean;

import java.util.List;

/**
 * Created by 芮靖林
 * on 2017/2/15 15:39.
 */

public class HomeListInfo {


    private int status;
    private String info;
    private List<IndexDuobaoListBean> index_duobao_list;

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

    public List<IndexDuobaoListBean> getIndex_duobao_list() {
        return index_duobao_list;
    }

    public void setIndex_duobao_list(List<IndexDuobaoListBean> index_duobao_list) {
        this.index_duobao_list = index_duobao_list;
    }

    public static class IndexDuobaoListBean {

        private String price;
        private String id;
        private String deal_id;
        private String duobao_id;
        private String name;
        private String brief;
        private String icon;
        private String create_time;
        private String max_buy;
        private String min_buy;
        private String current_buy;
        private String progress;
        private String success_time;
        private String lottery_time;
        private String fair_sn;
        private String fair_sn_local;
        private String fair_period;
        private String luck_user_id;
        private String luck_user_name;
        private Object duobao_ip;
        private String origin_price;
        private String success_time_50;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDeal_id() {
            return deal_id;
        }

        public void setDeal_id(String deal_id) {
            this.deal_id = deal_id;
        }

        public String getDuobao_id() {
            return duobao_id;
        }

        public void setDuobao_id(String duobao_id) {
            this.duobao_id = duobao_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
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

        public String getProgress() {
            return progress;
        }

        public void setProgress(String progress) {
            this.progress = progress;
        }

        public String getSuccess_time() {
            return success_time;
        }

        public void setSuccess_time(String success_time) {
            this.success_time = success_time;
        }

        public String getLottery_time() {
            return lottery_time;
        }

        public void setLottery_time(String lottery_time) {
            this.lottery_time = lottery_time;
        }

        public String getFair_sn() {
            return fair_sn;
        }

        public void setFair_sn(String fair_sn) {
            this.fair_sn = fair_sn;
        }

        public String getFair_sn_local() {
            return fair_sn_local;
        }

        public void setFair_sn_local(String fair_sn_local) {
            this.fair_sn_local = fair_sn_local;
        }

        public String getFair_period() {
            return fair_period;
        }

        public void setFair_period(String fair_period) {
            this.fair_period = fair_period;
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

        public Object getDuobao_ip() {
            return duobao_ip;
        }

        public void setDuobao_ip(Object duobao_ip) {
            this.duobao_ip = duobao_ip;
        }

        public String getOrigin_price() {
            return origin_price;
        }

        public void setOrigin_price(String origin_price) {
            this.origin_price = origin_price;
        }

        public String getSuccess_time_50() {
            return success_time_50;
        }

        public void setSuccess_time_50(String success_time_50) {
            this.success_time_50 = success_time_50;
        }
    }
}
