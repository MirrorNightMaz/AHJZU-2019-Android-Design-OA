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
import com.example.oa10.Adapter.RecyclerAdapter;
import com.example.oa10.Adapter.RecyclerAdapter1;
import com.example.oa10.Beans.NewsBeans;
import com.example.oa10.R;
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
//通知
public class FragmentNotice extends Fragment {
    private View view;
    private Context mContext;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapter1 recyclerAdapter;
    private RecyclerView recyclerView;

    public FragmentNotice() {
    }

    public void getInstance(Context context){
        this.mContext = context;
    }

    List<Inform.NoticeBean> list;
    public void setData(List<Inform.NoticeBean> list){
        this.list= list;
        recyclerAdapter.setmDatas(list);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notice,null);
        //mContext=getContext();
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview02);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerAdapter=new RecyclerAdapter1(mContext);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.setOnItemClickListener(new RecyclerAdapter1.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e("item",position+"");
                Intent intent = new Intent(mContext,DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("content",list.get(position).getNotice_content());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //recyclerView.addOnScrollListener(mOnScrollListener);



        return view;
    }

    /**
     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

     Notice.NoticeBean noticeBean=(Notice.NoticeBean) noticeAdapter.getItem(position);

     Intent intent = new Intent(mContext, DetailActivity.class);
     Bundle bundle = new Bundle();
     bundle.putString("content",noticeBean.getNotice_content());
     intent.putExtras(bundle);
     startActivity(intent);
     }
     **/
}
