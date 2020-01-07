package com.example.oa10.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.example.oa10.Fragment.FragmentSche;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager fragmetnmanager;
    private List<FragmentSche> listfragment;

    public ViewPagerAdapter(FragmentManager fm,List<FragmentSche> list) {
        super(fm);
        this.fragmetnmanager=fm;
        this.listfragment=list;
    }

    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listfragment.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) { return view ==((FragmentSche) object).getView();}

}
