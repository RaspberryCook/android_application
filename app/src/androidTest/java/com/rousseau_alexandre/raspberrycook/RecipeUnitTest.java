package com.rousseau_alexandre.raspberrycook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;

import junit.framework.TestCase;


public class RecipeUnitTest extends TestCase {

    public void testInsert() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        int initialCount = countRows("recipes");

        Recipe recipe = new Recipe("Gigot");
        recipe.insert(appContext);

        assertEquals(initialCount + 1, countRows("recipes"));
    }

    protected int countRows(String tableName) {
        Context appContext = InstrumentationRegistry.getTargetContext();
        MySQLiteHelper helper = new MySQLiteHelper(appContext);
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM " + tableName, null);
        cursor.moveToFirst();

        return cursor.getInt(0);
    }
}
