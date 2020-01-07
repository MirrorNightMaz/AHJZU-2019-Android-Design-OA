package com.example.oa10.Fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.oa10.Activity.LoginActivity;
import com.example.oa10.Adapter.NewsAdapter;
import com.example.oa10.Adapter.ScheAdapter;
import com.example.oa10.MainActivity;
import com.example.oa10.R;
import com.example.oa10.Utils.LoginFlag;
import com.example.oa10.entity.Inform;
import com.example.oa10.entity.News;
import com.example.oa10.entity.ResultBean;
import com.example.oa10.entity.Schedule;
import com.example.oa10.presenter.MyPresenter;
import com.example.oa10.view.MVPView;

public class FragmentSche extends Fragment implements AdapterView.OnItemClickListener {
    private View view;
    private Context mContext;
    private MyPresenter myPresenter;
    private ScheAdapter scheAdapter;
    private ListView lv_news;
    private MVPView mvpView = new MVPView() {
        @Override
        public void onSuccess_news(News news) {

        }

        @Override
        public void onSuccess_login(ResultBean resultBean) {

        }

        @Override
        public void onSuccess_inform(Inform inform) {

        }


        @Override
        public void onSuccess_schedule(Schedule schedule) {

            scheAdapter = new ScheAdapter(mContext,schedule.getSchedule());
            lv_news.setAdapter(scheAdapter);
            scheAdapter.notifyDataSetChanged();
        }

        @Override
        public void onError() {

        }
    };

    private String type=null;
    public static FragmentSche getInstance(){
        FragmentSche fragmentSche = new FragmentSche();


        return fragmentSche;
    }
    public void setType(String type){
        this.type = type;
    }

    private LoginFlag loginFlag;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragmentnews, container, false);
        mContext=getContext();
        myPresenter=new MyPresenter(mContext);
        myPresenter.attachView(mvpView);
        lv_news = (ListView) view.findViewById(R.id.lv_news);

        lv_news.setOnItemClickListener(this);
        Log.e("type",type);
        loginFlag = LoginFlag.getInstance();
        if(loginFlag.getResultBean()!=null){
            myPresenter.getSche(type,loginFlag.getResultBean().getUserEntity().getUser_id());
        }
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
