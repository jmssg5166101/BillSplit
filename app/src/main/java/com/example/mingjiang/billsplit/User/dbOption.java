package com.example.mingjiang.billsplit.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingjiang on 8/1/16.
 */
public class dbOption {
   private MyDb mydb;
    public dbOption(Context context) {
        mydb = new MyDb(context);
    }
    public void addDataToUser(Context context, String name, String phoneNum, String Email) {
        Log.d("Ming","start add data to database in dbOption");
        SQLiteDatabase db = mydb.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(mydb.KEY_NAME, name);
        values.put(mydb.KEY_PHONE, phoneNum);
        values.put(mydb.KEY_EMAIL, Email);
        db.insert(mydb.TABLE_TEST, null, values);
        db.close();
        Log.d("Ming","end add data to database in dbOption");
    }

    //Get Row Count
    public int getCountUser() {
        String countQuery = "SELECT  * FROM " + mydb.TABLE_TEST;
        int count = 0;
        SQLiteDatabase db = mydb.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if(cursor != null && !cursor.isClosed()){
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }

    //Delete Query
    public void removeFav(int id) {
        String countQuery = "DELETE FROM " + mydb.TABLE_TEST + " where " + mydb.KEY_ID + "= " + id ;
        SQLiteDatabase db = mydb.getReadableDatabase();
        db.execSQL(countQuery);
    }

    //Get FavList
    public List<FavoriteList> getFavList(){
        String selectQuery = "SELECT  * FROM " + mydb.TABLE_TEST;
        SQLiteDatabase db = mydb.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<FavoriteList> FavList = new ArrayList<FavoriteList>();
        if (cursor.moveToFirst()) {
            do {
                FavoriteList list = new FavoriteList();
                list.setId(Integer.parseInt(cursor.getString(0)));
                list.setName(cursor.getString(1));
                list.setphoneNum(cursor.getString(2));
                list.setEmail(cursor.getString(3));
                FavList.add(list);
            } while (cursor.moveToNext());
        }
        return FavList;
    }
}
