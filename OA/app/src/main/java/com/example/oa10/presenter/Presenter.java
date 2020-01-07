package com.example.oa10.presenter;


import android.content.Intent;
import android.view.View;

import com.example.oa10.view.MVPView;


/**
 * Created by win764-1 on 2016/12/12.
 */

public interface Presenter {
    void onCreate();

    void onStart();

    void onStop();

    void pause();

    void attachView(MVPView view);

}
