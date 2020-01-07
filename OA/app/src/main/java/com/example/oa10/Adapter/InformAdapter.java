package com.example.oa10.Adapter;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



import java.util.List;

/**
 * Created by asus on 2018/12/30.
 */

public class InformAdapter extends FragmentPagerAdapter {
    private String[] inform_Titles = new String[]{"公告","通知"};
    private List<Fragment> fragments;

    public InformAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        fragments = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return inform_Titles[position];
    }
}
