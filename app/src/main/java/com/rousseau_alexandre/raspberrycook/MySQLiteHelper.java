package com.rousseau_alexandre.raspberrycook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_RECIPES = "recipes";

    private static final String DATABASE_NAME = "raspberry_cook.sqlite";
    private static final int DATABASE_VERSION = 1;

    /**
     * SQL Query to create database
     */
    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_RECIPES + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL)";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPES);
        onCreate(db);
    }
}
