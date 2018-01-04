package com.rousseau_alexandre.raspberrycook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a recipe from raspberry-cook.fr
 */
public class Recipe extends Record {

    public String name;


    public Recipe(String _name) {
        name = _name;
    }

    public Recipe(long _id, String _name) {
        this(_name);
        id = _id;
    }

    public static List<Recipe> all(Context context) {
        SQLiteDatabase database = getDatabase(context);
        Cursor cursor = database.rawQuery("SELECT id, name FROM " + TABLE_NAME, null);


        List<Recipe> recipes = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            recipes.add(new Recipe(cursor.getLong(0), cursor.getString(1)));
            cursor.moveToNext();
        }

        return recipes;
    }

    @Override
    public boolean save(Context context) {
        return false;
    }


    @Override
    public boolean synchronise(Context context) {
        return false;
    }

    protected ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put("name", name);
        return values;
    }

    public String getTitle(){
        return String.format("%s # %s", id, name);
    }

}
