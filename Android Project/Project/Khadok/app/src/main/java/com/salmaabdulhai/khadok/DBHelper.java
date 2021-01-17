package com.salmaabdulhai.khadok;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.salmaabdulhai.khadok.Models.CustomerOrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBNAME = "mydatabase.db";
    final static int DBVERSION = 3;



    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //SQL query
        sqLiteDatabase.execSQL(
                "create table orders" +
                        "(id integer primary key autoincrement," +
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

    //to view the selected order from the cutomer (from database to "My order" fragment

    public ArrayList<CustomerOrderModel> getOrders (){
        ArrayList<CustomerOrderModel> orders = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //cursor points according to the rows. it points at the first rwo, then second and so on
        //now i want to select that particular order and show it in the "my order" fragment
        //Example 10 queries, so it will point the first (iteration)

        Cursor cursor = sqLiteDatabase.rawQuery("Select id, foodname, image, price from orders ",null);
        if(cursor.moveToFirst()) {
            while (cursor.moveToNext()){
                CustomerOrderModel customerOrderModel = new CustomerOrderModel();
                customerOrderModel.setOrderNumber(cursor.getInt(0 )+ "");
                customerOrderModel.setOrderedFood(cursor.getString(1));
                customerOrderModel.setOrderedImage(cursor.getInt(2));
                customerOrderModel.setPrice(cursor.getString(3));
                orders.add(customerOrderModel);


            }
        }
        //to prevent it from memory leakage
        cursor.close();
        sqLiteDatabase.close();
        return orders;



    }


    public int deleteOrder (String id){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete("orders", "id="+id, null);
    }
}
