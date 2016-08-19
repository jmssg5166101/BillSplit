package com.example.mingjiang.billsplit.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mingjiang.billsplit.Bill.BillList;
import com.example.mingjiang.billsplit.MyDb;

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
        Log.d("test","start add data to database in dbOption");
        SQLiteDatabase db = mydb.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(mydb.KEY_NAME, name);
        values.put(mydb.KEY_PHONE, phoneNum);
        values.put(mydb.KEY_EMAIL, Email);
        db.insert(mydb.TABLE_USER, null, values);
        db.close();
        Log.d("test","end add data to database in dbOption");
    }

    //Get Row Count
    public int getCountUser() {
        String countQuery = "SELECT  * FROM " + mydb.TABLE_USER;
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
        String countQuery = "DELETE FROM " + mydb.TABLE_USER + " where " + mydb.KEY_ID + "= " + id ;
        SQLiteDatabase db = mydb.getReadableDatabase();
        db.execSQL(countQuery);
    }

    //Get FavList
    public List<FavoriteList> getFavList(){
        String selectQuery = "SELECT  * FROM " + mydb.TABLE_USER;
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



/**********************     Bill database option      *******************/



    public void addDataToBillList(Context context, String BillName, Float BillAmount) {
        Log.d("test","start add bill to database in dbOption");
        SQLiteDatabase db = mydb.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(mydb.BILL_NAME, BillName);
        values.put(mydb.BILL_AMOUNT, BillAmount);

        db.insert(mydb.TABLE_BILLS, null, values);

        db.close();
        Log.d("test","end add bill to database in dbOption");
    }

    //Get Row Count
    public int getCountBill() {
        String countQuery = "SELECT  * FROM " + mydb.TABLE_BILLS;
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
    public void removeBill(int id) {
        String countQuery = "DELETE FROM " + mydb.BILL_AMOUNT + " where " + mydb.KEY_ID + "= " + id ;
        SQLiteDatabase db = mydb.getReadableDatabase();
        db.execSQL(countQuery);
    }

    //Get BillList
    public List<BillList> getBillList(){
        String selectQuery = "SELECT  * FROM " + mydb.TABLE_BILLS;
        SQLiteDatabase db = mydb.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<BillList> BillList = new ArrayList<BillList>();
        if (cursor.moveToFirst()) {
            do {
                BillList list = new BillList();
                list.setBillId(cursor.getInt(0));
                list.setBillName(cursor.getString(1));
                list.setBillAmount(cursor.getFloat(2));
                BillList.add(list);
            } while (cursor.moveToNext());
        }
        return BillList;
    }
    public List<BillList> getBillListName(){

        String selectQuery = "SELECT  * FROM " + mydb.TABLE_USER;
        SQLiteDatabase db = mydb.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<BillList> BillListName = new ArrayList<BillList>();
        if (cursor.moveToFirst()) {
            do {
                BillList list = new BillList();
                list.setBillName(cursor.getString(1));

                BillListName.add(list);
            } while (cursor.moveToNext());
        }
        return BillListName;

    }

}
