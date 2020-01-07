package com.example.oa10.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oa10.R;
import com.example.oa10.entity.News;
import com.example.oa10.entity.Schedule;

import java.util.List;

public class ScheAdapter extends BaseAdapter {
    private List<Schedule.ScheduleBean> list;
    private Context context;

    //通过构造方法接受要显示的新闻数据集合
    public ScheAdapter(Context context, List<Schedule.ScheduleBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        //1.复用converView优化listview,创建一个view作为getview的返回值用来显示一个条目
        if(convertView != null){
            view = convertView;
        }else {

            view = View.inflate(context, R.layout.item_sche, null);//将一个布局文件转换成一个view对象



        }
        TextView item_tv_des = (TextView) view.findViewById(R.id.item_tv_des);
        TextView item_tv_time = (TextView) view.findViewById(R.id.item_tv_time);
        Schedule.ScheduleBean scheduleBean = list.get(position);
        String str=scheduleBean.getSche_time();
        str = str.substring(0,10);
        item_tv_time.setText(" ["+str+"] ");
        item_tv_des.setText(scheduleBean.getSche_content());
        return view;
    }
}
