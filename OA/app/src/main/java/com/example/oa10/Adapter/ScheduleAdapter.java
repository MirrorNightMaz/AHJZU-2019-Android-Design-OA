package com.example.oa10.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.example.oa10.Fragment.FragmentHistory;
import com.example.oa10.Fragment.FragmentToday;
import com.example.oa10.Fragment.FragmentTomorrow;

/**
 * Created by asus on 2018/12/30.
 */

public class ScheduleAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"今日日程","明日日程","历史日程"};

    public ScheduleAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new FragmentTomorrow();
        } else if (position == 2) {
            return new FragmentHistory();
        }
        return new FragmentToday();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public boolean isViewFromObject(View view, Object object) { return view ==((Fragment) object).getView();}

}
