package com.salmaabdulhai.khadok;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 1;



    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //SQL query
        sqLiteDatabase.execSQL(
                "create table orders" +
                        "(id int primary key autoincrement," +
                        "price text," +
                        "image int, " +
                        "description text," +
                        "foodname text)"
        );

    }


    //
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists orders");
        onCreate(sqLiteDatabase);
    }


    //to insert order in Database
    public boolean insertOrder (String price, int image, String desc, String foodname){

        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodname", foodname);
        long id = database.insert("orders", null,values);
        if(id <=0) {return false;}
        else {return true;}
    }
}
