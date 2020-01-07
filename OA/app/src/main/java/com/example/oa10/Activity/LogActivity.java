package com.example.oa10.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.oa10.Adapter.LogAdapter;
import com.example.oa10.Beans.LogBeans;
import com.example.oa10.R;
import com.example.oa10.Utils.MyDatabase;

import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {
    ListView listView;
    FloatingActionButton floatingActionButton;
    LayoutInflater layoutInflater;
    ArrayList<LogBeans> arrayList;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        listView = (ListView)findViewById(R.id.layout_listview);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.add_note);
        layoutInflater = getLayoutInflater();

        myDatabase = new MyDatabase(this);
        arrayList = myDatabase.getarray();
        LogAdapter adapter = new LogAdapter(layoutInflater,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //点击一下跳转到编辑页面（编辑页面与新建页面共用一个布局）
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent3 = new Intent(getApplicationContext(),LogNewBuild.class);
                intent3.putExtra("ids",arrayList.get(position).getLog_ids());
                startActivity(intent3);
                LogActivity.this.finish();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {   //长按删除
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(LogActivity.this) //弹出一个对话框
                        //.setTitle("确定要删除此便签？")
                        .setMessage("确定要删除此便签？")
                        .setNegativeButton("取消",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("确定",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                myDatabase.toDelete(arrayList.get(position).getLog_ids());
                                LogAdapter myAdapter = new LogAdapter(layoutInflater,arrayList);
                                listView.setAdapter(myAdapter);
                            }
                        })
                        .create()
                        .show();
                return true;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {   //点击悬浮按钮时，跳转到新建页面
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),LogNewBuild.class);
                startActivity(intent1);
                LogActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.log_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_newnote:
                Intent intent2 = new Intent(getApplicationContext(),LogNewBuild.class);
                startActivity(intent2);
                LogActivity.this.finish();
                break;
            case R.id.menu_exit:
                LogActivity.this.finish();
                break;
            default:
                break;
        }
        return  true;
        //return false;????是用哪个true or false？

    }
}
