package com.example.oa10.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.oa10.R;

public class DetailActivity extends AppCompatActivity{

    private TextView textView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = (TextView)findViewById(R.id.text01);
        Bundle bundle = this.getIntent().getExtras();
        textView.setText(bundle.getString("content"));

    }
}
