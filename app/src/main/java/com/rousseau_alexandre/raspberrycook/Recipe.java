package com.rousseau_alexandre.raspberrycook;

import android.content.ContentValues;
import android.content.Context;

/**
 * Represent a recipe from raspberry-cook.fr
 */
public class Recipe extends Record {

    public long id;
    public String name;

    public Recipe(String _name) {
        name = _name;
    }

    @Override
    public boolean save(Context context) {
        return false;
    }

    @Override
    public boolean delete(Context context) {
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

}
