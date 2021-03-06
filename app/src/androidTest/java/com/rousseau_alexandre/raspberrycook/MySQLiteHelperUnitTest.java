package com.rousseau_alexandre.raspberrycook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;

import com.rousseau_alexandre.raspberrycook.models.MySQLiteHelper;

import junit.framework.TestCase;


public class MySQLiteHelperUnitTest extends TestCase {

    /**
     * Check if database is correctly created
     */
    public void testMySQLiteHelper() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        MySQLiteHelper helper = new MySQLiteHelper(appContext);
        SQLiteDatabase database = helper.getWritableDatabase();
        // check if recipes table is created
        Cursor cursor = database.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='recipes'", null);
        assertSame(1, cursor.getCount());
        // check if azaz table is created
        cursor = database.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='azaz'", null);
        assertSame(0, cursor.getCount());
    }
}
