package com.example.mingjiang.billsplit.Bill;

/**
 * Created by mingjiang on 8/17/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mingjiang.billsplit.MyDb;
import com.example.mingjiang.billsplit.User.FavoriteList;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mingjiang on 8/10/16.
 */

/**
 * Created by mingjiang on 8/1/16.
 */
public class billDbOption {
    // int testsize;
    private MyDb mydb;
    public billDbOption(Context context) {
        mydb = new MyDb(context);
    }
    public void addDataToBill(Context context, String BillName, String BillAmount) {
        Log.d("Ming","start add bill to database in dbOption");
        SQLiteDatabase db = mydb.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(mydb.BILL_NAME, BillName);
        values.put(mydb.BILL_AMOUNT, BillAmount);

        db.insert(mydb.TABLE_BILLS, null, values);
        //db.execSQL("insert into TABLE_BILL values('test', 4)");
        db.close();
        Log.d("Ming","end add bill to database in dbOption");
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

        String selectQuery = "SELECT  * FROM " + mydb.TABLE_BILLS;
        SQLiteDatabase db = mydb.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<BillList> BillList = new ArrayList<BillList>();
        if (cursor.moveToFirst()) {
            do {
                BillList list = new BillList();
                list.setBillName(cursor.getString(1));

                BillList.add(list);
            } while (cursor.moveToNext());
        }
        return BillList;

    }


    public List<FavoriteList> getUserNameList(){
        Log.d("test","run getUserNameList function");

        String selectQuery = "SELECT  * FROM " + mydb.TABLE_USER;
        Log.d("test","run getUserNameList function");
        SQLiteDatabase db = mydb.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        List<FavoriteList> nameList = new ArrayList<FavoriteList>();
        if (cursor.moveToFirst()) {
            do {
                FavoriteList list = new FavoriteList();
                list.setName(cursor.getString(1));

                nameList.add(list);
            } while (cursor.moveToNext());
        }
        Log.d("test","finish run getUserNameList function");
        return nameList;

    }

}


