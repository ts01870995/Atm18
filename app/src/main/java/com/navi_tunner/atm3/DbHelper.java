package com.navi_tunner.atm3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by navi-tunner on 2017/11/13.
 */

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        this(context,"exp",null, 1);
    }

    private DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE exp " +
                "(_id INTEGER PRIMARY KEY," +
                "cdate DATETIME NOT NULL," +
                "info VARCHAR," +
                "money INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
