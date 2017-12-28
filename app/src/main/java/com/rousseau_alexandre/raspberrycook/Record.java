package com.rousseau_alexandre.raspberrycook;

import android.content.Context;

import java.util.List;

/**
 * Represent an object who can be saved into Database
 */
public interface Record {

    /**
     * Save the given record into database
     *
     * @return `true` if success
     */
    public boolean save(Context context);

    /**
     * Insert given record into database
     *
     * @return `true` if success
     */
    public boolean insert(Context context);

    /**
     * Remove given record into database
     *
     * @return `true` if success
     */
    public boolean delete(Context context);

    /**
     * Synchronise given record from https://raspberry-cook.fr
     *
     * @return `true` if success
     */
    public boolean synchronise(Context context);

}
