package com.rousseau_alexandre.raspberrycook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Represent a recipe from raspberry-cook.fr
 */
public class Recipe implements Record {

    /**
     * Name of SQL table
     */
    public static final String TABLE_NAME = "recipes";

    public long id;
    public String name;
    private SQLiteDatabase database;

    public Recipe(String _name) {
        name = _name;
    }


    @Override
    public boolean save(Context context) {
        return false;
    }

    @Override
    public boolean insert(Context context) {
        MySQLiteHelper helper = new MySQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();
        id = database.insert("recipes", null, toContentValues());
        return true;
    }

    @Override
    public boolean delete(Context context) {
        return false;
    }

    @Override
    public boolean synchronise(Context context) {
        return false;
    }

    private ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put("name", name);
        return values;
    }

}
