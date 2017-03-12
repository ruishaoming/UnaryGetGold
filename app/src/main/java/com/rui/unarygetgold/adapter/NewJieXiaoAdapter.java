package com.rui.unarygetgold.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rui.unarygetgold.R;
import com.rui.unarygetgold.app.MyApplication;
import com.rui.unarygetgold.bean.NewJieXiaoInfo;
import com.rui.unarygetgold.utils.UrlUtils;
import com.shuyu.frescoutil.FrescoHelper;
import com.zhy.autolayout.AutoLinearLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import lib.lhh.fiv.library.FrescoImageView;

/**
 * author by 芮靖林 on 2017/2/17.
 */

public class NewJieXiaoAdapter extends BaseAdapter {

    private NewJieXiaoInfo newJieXiaoBean;
    private Context context;
    private ArrayList<NewJieXiaoInfo.ListBean> listBeanArrayList;
    private final SimpleDateFormat simpleDateFormat;


    public NewJieXiaoAdapter(Context context, ArrayList<NewJieXiaoInfo.ListBean> listBeanArrayList, NewJieXiaoInfo newJieXiaoBean) {
        this.context = context;
        this.listBeanArrayList = listBeanArrayList;
        this.newJieXiaoBean = newJieXiaoBean;
        simpleDateFormat = new SimpleDateFormat("mm:ss");

        for (int i = 0; i < listBeanArrayList.size(); i++) {
            listBeanArrayList.get(i).setNowTime(newJieXiaoBean.getNow_time());
        }

    }

    @Override
    public int getCount() {
        return listBeanArrayList==null?0:listBeanArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.newjiexiao_lv_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.duobaoitemnametv.setText(listBeanArrayList.get(i).duobaoitem_name);
        FrescoHelper.loadFrescoImage(viewHolder.iconfrescoImageView, UrlUtils.BASE_URL + listBeanArrayList.get(i).icon, R.mipmap.default_img, false);
        //Spanned num = Html.fromHtml("开奖进度" + "<font color=#81AEF3><b>"+list.get(position).getProgress()+"</b></font>"+"%");

        viewHolder.maxbuytv.setText(Html.fromHtml("价值: " + "<font color=#ff3660><b>" + listBeanArrayList.get(i).max_buy + "</b></font>" + "元"));

        if (listBeanArrayList.get(i).has_lottery.equals("1")) {
            viewHolder.messageLinearLayout.setVisibility(View.VISIBLE);
            viewHolder.countdownlinearLayout.setVisibility(View.GONE);
            viewHolder.luckusernametv.setText(Html.fromHtml("获奖者: " + "<font color=#669df1><b>" + listBeanArrayList.get(i).luck_user_name + "</b></font>"));
            viewHolder.luckuserbuycounttv.setText(Html.fromHtml("参与人数: " + "<font color=#ff3660><b>" + listBeanArrayList.get(i).luck_user_buy_count + "</b></font>" + "人次"));
            viewHolder.startTime_tv.setText(Html.fromHtml("揭晓时间: " + "<font color=#ff3660><b>" + listBeanArrayList.get(i).date + listBeanArrayList.get(i).lottery_time_show));
        } else if (listBeanArrayList.get(i).has_lottery.equals("0")) {
            viewHolder.messageLinearLayout.setVisibility(View.GONE);
            viewHolder.countdownlinearLayout.setVisibility(View.VISIBLE);
//            setCurrentTime(i);
            if (listBeanArrayList.get(i).getShowTime() > 0) {
//                String format = simpleDateFormat.format(listBeanArrayList.get(i).getShowTime());
                viewHolder.willAwards_tv.setText(secToTime(listBeanArrayList.get(i).getShowTime()));
            }

            handler.obtainMessage(1, i).sendToTarget();

        }
        return view;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    final int i = (int) msg.obj;
                    MyApplication.getHandler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            listBeanArrayList.get(i).setNowTime(listBeanArrayList.get(i).getNowTime() + 1);
                            setCurrentTime(i);
                            notifyDataSetChanged();
                        }
                    }, 1000);
                    break;
                default:
                    break;
            }

        }
    };


    private void setCurrentTime(int i) {
        String lottery_timeStr = listBeanArrayList.get(i).lottery_time;
        int lottery_time = Integer.parseInt(lottery_timeStr);
        int time = lottery_time - listBeanArrayList.get(i).getNowTime();
        listBeanArrayList.get(i).setShowTime(time);
    }

    public class ViewHolder {
        public final FrescoImageView iconfrescoImageView;
        public final TextView duobaoitemnametv;
        public final TextView maxbuytv;
        public final TextView luckusernametv;
        public final TextView luckuserbuycounttv;
        public final AutoLinearLayout messageLinearLayout;
        public final TextView willAwards_tv;
        public final AutoLinearLayout countdownlinearLayout;
        public final View root;
        private final TextView startTime_tv;

        public ViewHolder(View root) {
            iconfrescoImageView = (FrescoImageView) root.findViewById(R.id.icon_frescoImageView);
            duobaoitemnametv = (TextView) root.findViewById(R.id.duobaoitem_name_tv);
            maxbuytv = (TextView) root.findViewById(R.id.max_buy_tv);
            luckusernametv = (TextView) root.findViewById(R.id.luck_user_name_tv);
            luckuserbuycounttv = (TextView) root.findViewById(R.id.luck_user_buy_count_tv);
            messageLinearLayout = (AutoLinearLayout) root.findViewById(R.id.messageLinearLayout);
            willAwards_tv = (TextView) root.findViewById(R.id.willAwards_tv);
            startTime_tv = (TextView) root.findViewById(R.id.startTime_tv);
            countdownlinearLayout = (AutoLinearLayout) root.findViewById(R.id.count_down_linearLayout);
            this.root = root;
        }
    }

    //格式化时间{秒 转 时分秒}
    public String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
}
