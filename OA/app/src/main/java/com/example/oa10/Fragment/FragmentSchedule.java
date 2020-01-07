package com.example.oa10.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa10.Adapter.ScheduleAdapter;
import com.example.oa10.Adapter.ViewPagerAdapter;
import com.example.oa10.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/12/26.
 */

public class FragmentSchedule extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter pagerAdapter;

    private ScheduleAdapter mScheduleAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private View mView;

    private List<FragmentSche> fragments = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mView = LayoutInflater.from(getActivity()).inflate(R.layout.fragmentschedule, container, false);

        initViews();
        return mView;
    }
    private void initViews() {

        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager= (ViewPager) mView.findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) mView.findViewById(R.id.tab_schedule);
        //mScheduleAdapter= new ScheduleAdapter(getChildFragmentManager());
        //mViewPager.setAdapter(mScheduleAdapter);
        String type[]=new String[]{"new","tom","old"};
        FragmentSche fragmentSche1= FragmentSche.getInstance();
        fragmentSche1.setType(type[0]);
        fragments.add(fragmentSche1);
        FragmentSche fragmentSche2= FragmentSche.getInstance();
        fragmentSche2.setType(type[1]);
        fragments.add(fragmentSche2);
        FragmentSche fragmentSche3= FragmentSche.getInstance();
        fragmentSche3.setType(type[2]);
        fragments.add(fragmentSche3);
        for(int i=0;i<3.;i++){

            mTabLayout.addTab(mTabLayout.newTab());
        }

        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),fragments);
        mViewPager.setAdapter(pagerAdapter);

        //将TabLayout与ViewPager绑定在一起

        mTabLayout.setupWithViewPager(mViewPager,true);



        String titles[]=new String[]{"今日日程","明日日程","历史日程"};
        for(int i=0;i<titles.length;i++){
            mTabLayout.getTabAt(i).setText(titles[i]);
        }


    }
}
