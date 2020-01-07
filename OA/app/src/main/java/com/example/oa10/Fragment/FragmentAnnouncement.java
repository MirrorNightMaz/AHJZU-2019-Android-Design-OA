package com.example.oa10.Fragment;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.oa10.Activity.DetailActivity;
import com.example.oa10.Adapter.NewsAdapter;
import com.example.oa10.Adapter.RecyclerAdapter;
import com.example.oa10.Beans.NewsBeans;
import com.example.oa10.R;
import com.example.oa10.Utils.LoginFlag;
import com.example.oa10.Utils.NewsUtils;
import com.example.oa10.entity.Inform;
import com.example.oa10.entity.News;
import com.example.oa10.entity.ResultBean;
import com.example.oa10.entity.Schedule;
import com.example.oa10.presenter.MyPresenter;
import com.example.oa10.view.MVPView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/12/30.
 */
//公告
public class FragmentAnnouncement extends Fragment  {
    private View view;
    private Context mContext;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapter recyclerAdapter;

    public FragmentAnnouncement() {
    }

    public void getInstance(Context context){
        this.mContext = context;
    }

    List<Inform.AnnouncementBean> list;
    public void setData(List<Inform.AnnouncementBean> list1){
        this.list = list1;
        recyclerAdapter.setmDatas(list1);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_anno,null);
        //mContext=getContext();
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview01);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerAdapter=new RecyclerAdapter(mContext);
        recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e("item",position+"");
                Intent intent = new Intent(mContext,DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("content",list.get(position).getAnno_content());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }


    /**

     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

     Announcement.AnnouncementBean announcementBean=(Announcement.AnnouncementBean) recyclerAdapter.get(position);

     Intent intent = new Intent(mContext, DetailActivity.class);
     Bundle bundle = new Bundle();
     bundle.putString("content",announcementBean.getAnno_content());
     intent.putExtras(bundle);
     startActivity(intent);
     }
     **/
}
