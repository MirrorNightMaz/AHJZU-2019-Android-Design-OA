package com.example.oa10.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.oa10.Adapter.PhoneAdapter;
import com.example.oa10.R;
import com.example.oa10.Utils.GetPhoneContacts;

public class PhoneContentActivity extends Activity {
    private ListView ls;
    private PhoneAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_content);
        GetPhoneContacts.getNumber(this);//调用getNumber方法，将数据封装到List<PhoneEntity>集合中。
        ls=(ListView) findViewById(R.id.list_phone);//得到ListView对象
        adapter=new PhoneAdapter(this, GetPhoneContacts.list);//得到适配器对象
        ls.setAdapter(adapter);//为listView设置适配器
        // 初始化监听
        initListener();
    }
    /**
     * 初始化监听
     */
    private void initListener() {
        Log.e("initListener",".......");
        ls.setOnItemClickListener(new onItemClickListener());
    }
    /**
     * 点击监听实现
     * <p/>
     *
     * 实现：获得选中项的电话号码并拨号
     *
     * 注意：不能使用仅是继承于BaseAdapter，因为Object对象不能转型为Cursor。
     * 所以：使用的Adapter是继承于CursorAdapter,才能转型为CursorWrapper。
     */
    private class onItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final TextView content=(TextView) view.findViewById(R.id.tx_phoneNumber);
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://" + content));
            startActivity(intent);

        }
    }

}
