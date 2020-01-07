package com.example.oa10.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oa10.Activity.DetailActivity;
import com.example.oa10.R;
import com.example.oa10.entity.Inform;

import java.util.List;

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerAdapter1.ViewHolder>{

    private Context context;

    private OnItemClickListener onItemClickListener= null;
    //② 创建ViewHolder

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title,time;
        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.item_title);
            time = (TextView) v.findViewById(R.id.item_time);
        }
    }

    private List<Inform.NoticeBean> mDatas = null;


    public RecyclerAdapter1(Context context) {
        this.context = context;
    }

    public void setmDatas(List<Inform.NoticeBean> list){
        this.mDatas = list;
        this.notifyDataSetChanged();
    }

    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(RecyclerAdapter1.ViewHolder holder, final int position) {
        if(null==mDatas){
            return;
        }
        holder.title.setText(mDatas.get(position).getNotice_title());
        holder.time.setText(" ["+mDatas.get(position).getNotice_time()+" ]");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        if(null==mDatas){
            return 0;
        }
        return mDatas.size();
    }

    @Override
    public RecyclerAdapter1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClick((Integer) v.getTag());
                }
            }
        });
        return new RecyclerAdapter1.ViewHolder(v);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public static interface OnItemClickListener {
        void onItemClick(int position);
    }

}
