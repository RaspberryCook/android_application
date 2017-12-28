package com.rousseau_alexandre.raspberrycook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Represent an object who can be saved into Database
 */
public abstract class Record {

    /**
     * Name of SQL table
     *
     * @todo find a way to rewritte in in child class
     */
    public static String TABLE_NAME = "recipes";

    protected long id;



    /**
     * Save the given record into database
     *
     * @param context
     * @return `true` if success
     */
    public boolean save(Context context) {
        int countRows =getDatabase(context).update(
                TABLE_NAME,
                toContentValues(),
                "id =",
                new String[]{Long.toString(id)}
        );

        return countRows == 1;
    }

    /**
     * Insert given record into database
     *
     * @param context
     * @return `true` if success
     */
    public boolean insert(Context context) {
        long newId = getDatabase(context).insert(TABLE_NAME, null, toContentValues());
        if(newId == -1){
            return false;
        }else{
            id = newId;
            return true;
        }
    }

    /**
     * Remove given record into database
     *
     * @param context
     * @return `true` if success
     */
    public boolean delete(Context context) {
        return false;
    }

    /**
     * Synchronise given record from https://raspberry-cook.fr
     *
     * @param context
     * @return `true` if success
     */
    public boolean synchronise(Context context) {
        return false;
    }

    protected ContentValues toContentValues() {
        return new ContentValues();
    }

    protected static SQLiteDatabase getDatabase(Context context) {
        MySQLiteHelper helper = new MySQLiteHelper(context);
        return helper.getWritableDatabase();
    }

}
