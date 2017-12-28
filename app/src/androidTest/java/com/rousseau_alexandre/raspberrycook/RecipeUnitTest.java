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
        assertTrue(recipe.insert(appContext));

        assertEquals("Recipe was not added", initialCount + 1, countRows("recipes"));
    }

    public void testUpdate() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        int initialCount = countRows("recipes", "name", "Renamed");

        Recipe recipe = new Recipe("Gigot");
        recipe.insert(appContext);
        recipe.name = "Renamed";
        assertTrue("Recipe was not updated", recipe.save(appContext));
        assertEquals("Recipe was not updated", initialCount + 1, countRows("recipes", "name", "Renamed"));
    }

    protected int countRows(String tableName) {
        Context appContext = InstrumentationRegistry.getTargetContext();
        MySQLiteHelper helper = new MySQLiteHelper(appContext);
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM " + tableName, null);
        cursor.moveToFirst();

        return cursor.getInt(0);
    }

    protected int countRows(String tableName, String field, String value) {
        Context appContext = InstrumentationRegistry.getTargetContext();
        MySQLiteHelper helper = new MySQLiteHelper(appContext);
        SQLiteDatabase database = helper.getWritableDatabase();
        String query = String.format("SELECT COUNT(*) FROM %s WHERE %s LIKE ?", tableName, field);
        Cursor cursor = database.rawQuery(query, new String[]{value});
        cursor.moveToFirst();

        return cursor.getInt(0);
    }
}
