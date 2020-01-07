package com.example.oa10.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.oa10.Adapter.MyViewPageAdapter;
import com.example.oa10.Fragment.FragmentAnnouncement;
import com.example.oa10.Fragment.FragmentNotice;
import com.example.oa10.R;
import com.example.oa10.entity.Inform;
import com.example.oa10.entity.News;
import com.example.oa10.entity.ResultBean;
import com.example.oa10.entity.Schedule;
import com.example.oa10.presenter.MyPresenter;
import com.example.oa10.view.MVPView;

import java.util.ArrayList;
import java.util.List;

public class InformActivity extends AppCompatActivity {
    private TabLayout inform_mTabLayout;
    private ViewPager inform_ViewPager;
    private MyPresenter presenter;
    private FragmentAnnouncement fragmentAnnouncement;
    private FragmentNotice fragmentNotice ;
    private MVPView mvpView=new MVPView() {




        @Override
        public void onSuccess_schedule(Schedule schedule) {

        }

        @Override
        public void onSuccess_news(News news) {

        }

        @Override
        public void onSuccess_login(ResultBean resultBean) {

        }

        @Override
        public void onSuccess_inform(Inform inform) {
            Log.e("inform",inform.toString());
            fragmentAnnouncement.setData(inform.getAnnouncement());
            fragmentNotice.setData(inform.getNotice());
        }

        @Override
        public void onError() {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform);


        //初始化视图
        inform_initViews();

    }
    private void inform_initViews() {


        List<String> titleDatas=new ArrayList<>();
        titleDatas.add("公告");
        titleDatas.add("通知");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentAnnouncement =new FragmentAnnouncement();
        fragmentNotice = new FragmentNotice();
        fragmentAnnouncement.getInstance(getApplicationContext());
        fragmentNotice.getInstance(getApplicationContext());


        fragmentList.add(fragmentAnnouncement);
        fragmentList.add(fragmentNotice);
        MyViewPageAdapter myViewPageAdapter = new MyViewPageAdapter(getSupportFragmentManager(),
                titleDatas,fragmentList);
        inform_ViewPager = (ViewPager) findViewById(R.id.inform_viewPager);
        inform_ViewPager.setAdapter(myViewPageAdapter);
        inform_mTabLayout = (TabLayout) findViewById(R.id.tab_inform);
        inform_mTabLayout.setupWithViewPager(inform_ViewPager);

        presenter = new MyPresenter(getApplicationContext());
        presenter.onCreate();
        presenter.attachView(mvpView);
        presenter.getInform();

    }
}
