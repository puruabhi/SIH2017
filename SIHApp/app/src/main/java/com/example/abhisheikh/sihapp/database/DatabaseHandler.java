package com.example.abhisheikh.sihapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by abhisheikh on 2/4/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper{

    public static final int database_version=1;
    public String CREATE_QUERY = "CREATE TABLE "+ TableData.LoginStatus.TABLE_NAME+"("+TableData.LoginStatus.MEMBER_ID+" TEXT, "+TableData.LoginStatus.STATUS+" TEXT);";

    public DatabaseHandler(Context context, String name) {
        super(context, name, null, database_version);
        Log.d("DatabaseHandler","Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("DatabaseHandler","Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addLoginInfo(DatabaseHandler dh, String loginStatus, String memberID){
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.LoginStatus.STATUS,loginStatus);
        cv.put(TableData.LoginStatus.MEMBER_ID,memberID);
        db.insert(TableData.LoginStatus.TABLE_NAME,null,cv);
        Log.d("DatabaseHandler","Logged in");
    }

    public Cursor getLoginInfo(DatabaseHandler dh){
        SQLiteDatabase db = dh.getReadableDatabase();
        String []columns = {TableData.LoginStatus.STATUS};
        Cursor cr = db.query(TableData.LoginStatus.TABLE_NAME,columns,null,null,null,null,null);
        return cr;
    }


}
