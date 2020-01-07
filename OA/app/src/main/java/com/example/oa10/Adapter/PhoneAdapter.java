package com.example.oa10.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.oa10.Beans.PhoneEntity;
import com.example.oa10.R;

import java.util.List;

/**
 * Created by asus on 2018/12/28.
 */

public class PhoneAdapter extends BaseAdapter {
    private Context context;
    private List<PhoneEntity> lists;
    private LinearLayout layout;
    public PhoneAdapter(Context context,List<PhoneEntity> lists){
        this.context=context;
        this.lists=lists;
    }
    //返回列表的显示项，跟传进来的list数据数目一致。
    @Override
    public int getCount() {
        return lists.size();
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getItem(int)
     */
    //返回当前项
    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getItemId(int)
     */
    //返回当前项的索引
    @Override
    public long getItemId(int position) {

        return position;
    }

    /* (non-Javadoc)
     * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    //得到布局视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //得到布局加载器
        LayoutInflater inflater = LayoutInflater.from(context);
        //加载得到item每一项的布局
        layout = (LinearLayout) inflater.inflate(R.layout.list_item_phone, null);
        //通过视图得到控件
        TextView phoneNumTv = (TextView) layout.findViewById(R.id.tx_phoneNumber);
        TextView phoneNameTv = (TextView) layout.findViewById(R.id.tx_phoneName);
        //为控件填充数据
        phoneNumTv.setText(lists.get(position).getPhoneNumber());
        phoneNameTv.setText(lists.get(position).getPhoneName());
        return layout;
    }

}
