package com.example.mingjiang.billsplit.User;

/**
 * Created by mingjiang on 7/28/16.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mingjiang on 7/22/16.
 */
public class MyDb extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    //Database Name
    public static final String DATABASE_NAME = "Test";
    //Table Name
    public static final String TABLE_TEST = "TestTable";

    public  static final String TABLE_BILL="BillTable";
    //Column Name
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_EMAIL= "email";

    public static final String BILL_NAME="billname";
    public static final String BILL_AMOUNT="billamount";

    public MyDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Ming","Oncreate");
        String dropTable="DROP TABLE IF EXISTS " + TABLE_TEST;
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TEST + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_PHONE + " TEXT," + KEY_EMAIL+" TEXT"+ ")";
//        String CREATE_BILLS_TABLE = "CREATE TABLE " + TABLE_BILL + "("
//                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
//                + KEY_PHONE + " TEXT," + KEY_EMAIL+" TEXT"+ ")";
       // db.execSQL(dropTable);
        db.execSQL(CREATE_CONTACTS_TABLE);
        Log.d("Ming","excute the sql");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEST);
        onCreate(db);
    }


}
