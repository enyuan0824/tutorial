package com.example.tutorial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelper extends SQLiteOpenHelper{
    public static final String TABLE_NAME = "Personal_list";

    // Table columns
    public static final String _ID = "Id";
    public static final String NAME = "Full_Name";
    public static final String USERNAME = "User_Name";
    public static final String PASS = "Password";

    // Database Information
    static final String DB_NAME = "Tutorial_SQL.DB";

    // database version(make sure the version is update)
    static final int DB_VERSION = 3;

    // Creating table query
    // Creating table query
    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL, " + USERNAME + " TEXT,"+PASS+" INTEGER);";

    public dbhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
