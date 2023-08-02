package com.example.healthcare;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q1="create table users(username text,email text,password text)";
        db.execSQL(q1);
        String q2="create table cart(username text,product text,price float,otype text)";
        db.execSQL(q2);
        String q3="create table orders(username text,fullname String,address text,contact text,pincode int,date text,amount float ,otype text)";
        db.execSQL(q3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void register(String username,String email,String password){
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users",null,cv);
        db.close();


    }
    public  boolean login(String username,String password){
        Boolean res=false;
        String str[]= new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c=db.rawQuery( "Select * from users where username=? and password=?",str);
        if(c.moveToFirst()){
            res=true;
        }
        return res;



    }
    public boolean isUsername(String username){
        Boolean res=true;
        String str[]= new String[1];
        str[0]=username;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c=db.rawQuery( "Select * from users where username=?",str);
        if(c.moveToFirst()){
            res=false;
        }
        return res;

    }
    public void addCart(String username,String product,float price,String otype){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("product",product);
        cv.put("price",price);
        cv.put("otype",otype);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("cart",null,cv);
        db.close();
    }
    public Boolean checkCart(String username,String product){
        boolean res=false;
        String[] arr =new String[2];
        arr[0]=username;
        arr[1]=product;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c =db.rawQuery("select * from cart where username=? and product=?",arr);
        if(c.moveToFirst()){
            res=true;
        }
        //db.close();
        return res;

    }
    public void removeCart(String username,String otype){
        String[] arr =new String[2];
        arr[0]=username;
        arr[1]=otype;
        SQLiteDatabase db=getReadableDatabase();

        db.delete("cart", " username=? and otype=?",arr);

        db.close();


    }
    public ArrayList<String> getCartData(String username, String otype){

        String[] arre =new String[2];
        arre[0]=username;
        arre[1]=otype;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c =db.rawQuery("select * from cart where username=? and otype=? ",arre);
        Log.i("Data",""+c.getCount());
        ArrayList<String>arr=new ArrayList<>();
        if(c.moveToFirst()){
            do{
                String product=c.getString(1);
                String price=c.getString(2);
                Log.i("Data",product+" "+price);
                arr.add(product+"$"+price);
            }while(c.moveToNext());

            }
        else{
            Log.i("Data","NO DATA");
        }
        db.close();
        Log.i("Data",""+arr);
        return arr;

        }
        public void addOrder(String username,String fullname,String address,String contact,int pin,String date,float price,String otype){
            ContentValues cv = new ContentValues();

            cv.put("username",username);
            cv.put("fullname",fullname);
            cv.put("address",address);
            cv.put("contact",contact);
            cv.put("pincode",pin);
            cv.put("date",date);
            cv.put("amount",price);
            cv.put("otype",otype);
            SQLiteDatabase db=getWritableDatabase();
            db.insert("orders",null,cv);
            db.close();






        }
        public ArrayList getOrderData(String username){
        ArrayList<String>arr=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String []str=new String[1];
        str[0]=username;
        Cursor c = db.rawQuery("Select * from orders where username=?",str);
        if(c.moveToFirst()){
            do{
                arr.add(c.getString(1)+"$"+c.getString(2)+"$"+c.getString(3)+"$"+c.getString(4)+"$"+c.getString(5)+"$"+c.getString(6)+"$"+c.getString(7));
            }
            while(c.moveToNext());
        }
        db.close();
        return arr;
        }


    }


