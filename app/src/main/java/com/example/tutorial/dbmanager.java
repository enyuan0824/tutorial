package com.example.tutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class dbmanager {
    private static dbhelper dbHelper;

    private static Context context;

    private static SQLiteDatabase database;

    public dbmanager(Context c) {
        context = c;
    }

    public dbmanager open() throws SQLException {
        dbHelper = new dbhelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc,String pass) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(dbhelper.NAME, name);
        contentValue.put(dbhelper.USERNAME, desc);
        contentValue.put(dbhelper.PASS, pass);
        database.insert(dbhelper.TABLE_NAME, null, contentValue);
    }

    public static Cursor fetch(/*this need to put parameter if you want to using function(groupby.....)*/) {
        String[] columns = new String[] { dbhelper._ID, dbhelper.NAME, dbhelper.USERNAME,dbhelper.PASS };
        Cursor cursor = database.query(dbhelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String desc,String pass) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper.NAME, name);
        contentValues.put(dbhelper.USERNAME, desc);
        contentValues.put(dbhelper.PASS, pass);
        int i = database.update(dbhelper.TABLE_NAME, contentValues, dbhelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(dbhelper.TABLE_NAME, dbhelper._ID + "=" + _id, null);
    }
}
