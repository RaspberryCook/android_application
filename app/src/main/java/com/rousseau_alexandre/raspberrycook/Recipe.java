package com.rousseau_alexandre.raspberrycook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represent a recipe from raspberry-cook.fr
 */
public class Recipe extends Record {

    public String name;
    public long user_id;
    public Date created_at;
    public String description;
    public String ingredients;
    public String steps;
    public String season;
    public String photo;
    public String image;
    public long root_recipe_id = 0;
    public String variant_name;
    public String varchar;
    public int baking = 0;
    public int cooling = 0;
    public int rest = 0;
    public int cooking = 0;


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
