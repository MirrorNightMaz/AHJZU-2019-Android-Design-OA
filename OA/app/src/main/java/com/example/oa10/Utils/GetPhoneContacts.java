package com.example.oa10.Utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.example.oa10.Beans.PhoneEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/12/28.
 */

public class GetPhoneContacts {
    public static List<PhoneEntity> list = new ArrayList<PhoneEntity>();

    public static String getNumber(Context context) {
        Cursor cursor = context.getContentResolver().
                query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        null, null, null);
        String phoneNumber;
        String phoneName;
        //while(cursor.moveToNext()){}这两种遍历方式一样
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            phoneNumber =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            phoneName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            System.out.println("phoneNumber:" + phoneNumber + "phoneName:" + phoneName);
            PhoneEntity phoneEntity = new PhoneEntity(phoneNumber, phoneName);
            list.add(phoneEntity);
        }
        return null;
    }
}
