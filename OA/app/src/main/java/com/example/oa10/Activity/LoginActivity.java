package com.example.oa10.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oa10.MainActivity;
import com.example.oa10.R;
import com.example.oa10.Utils.LoginFlag;
import com.example.oa10.entity.Inform;
import com.example.oa10.entity.News;
import com.example.oa10.entity.ResultBean;
import com.example.oa10.entity.Schedule;
import com.example.oa10.presenter.MyPresenter;
import com.example.oa10.view.MVPView;


public class LoginActivity extends AppCompatActivity implements MVPView,View.OnClickListener{

    private EditText mLoginUserName;
    private EditText mLoginUserPass;
    private TextView mLoginTextview;

    public final static String LOGIN_ACTION="LOGIN_ACTION";

    //private ImageView imageView;

    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1106758439";//官方获取的APPID
    private MyPresenter myPresenter;
    private LoginFlag loginFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myPresenter=new MyPresenter(getApplicationContext());
        myPresenter.attachView(this);

        loginFlag = LoginFlag.getInstance();

        mLoginUserName = (EditText) findViewById(R.id.login_user_name);

        mLoginUserPass = (EditText) findViewById(R.id.login_user_pass);

        mLoginTextview = (TextView) findViewById(R.id.login_textview);

        mLoginTextview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_textview:
                Log.e("gggggg",mLoginUserName.getText().toString()+mLoginUserPass.getText().toString()+"");
                myPresenter.login(mLoginUserName.getText().toString(),mLoginUserPass.getText().toString());
                break;
        }
    }


    @Override
    public void onSuccess_news(News news) {

    }

    @Override
    public void onSuccess_login(ResultBean resultBean) {
        Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
        //Log.e("login",resultBean.toString());
        loginFlag.setResultBean(resultBean);
        finish();
    }

    @Override
    public void onSuccess_inform(Inform inform) {

    }


    @Override
    public void onSuccess_schedule(Schedule schedule) {

    }


    @Override
    public void onError() {
        Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_LONG).show();
        loginFlag.setResultBean(null);
    }
}
