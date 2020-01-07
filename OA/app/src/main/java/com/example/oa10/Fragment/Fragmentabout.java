package com.example.oa10.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.oa10.R;
import com.example.oa10.Utils.APKVersionCodeUtils;

/**
 * Created by asus on 2018/12/26.
 */

public class Fragmentabout extends Fragment {

    private TextView mTv_version;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentinabout, container, false);

        mTv_version = (TextView)view.findViewById(R.id.tv_about_version);

        String versionCode = APKVersionCodeUtils.getVersionCode(this.getActivity()) + "";
        mTv_version.setText("版本："+versionCode);
        //String versionName = APKVersionCodeUtils.getVerName(this);
        return view;
    }




}
