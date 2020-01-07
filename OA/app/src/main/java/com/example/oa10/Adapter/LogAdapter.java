package com.example.oa10.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.oa10.Beans.LogBeans;
import com.example.oa10.R;

import java.util.ArrayList;

/**
 * Created by asus on 2018/12/30.
 */

public class LogAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<LogBeans> array;

    public LogAdapter(LayoutInflater inf,ArrayList<LogBeans> arry){
        this.inflater=inf;
        this.array=arry;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {  //代码块中包含了对listview的效率优化
        ViewHolder vh;
        if(convertView==null){
            vh=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_log,null);//加载listview子项
            vh.tv1=(TextView) convertView.findViewById(R.id.list_title);
            vh.tv2=(TextView) convertView.findViewById(R.id.list_time);
            convertView.setTag(vh);
        }
        vh=(ViewHolder) convertView.getTag();
        vh.tv1.setText(array.get(position).getLog_title());
        vh.tv2.setText(array.get(position).getLog_times());
        return convertView;
    }
    class ViewHolder{     //内部类，对控件进行缓存
        TextView tv1,tv2;
    }

}
