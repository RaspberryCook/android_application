package com.rousseau_alexandre.raspberrycook;

import junit.framework.TestCase;

import org.json.JSONObject;

/**
 * Created by arousseau on 27/12/17.
 */

public class JSONParserTest extends TestCase {

    public void testJSONParser() {
        // no throw error for good urls
        try {
            JSONParser p = new JSONParser("https://raspberry-cook.fr");
            assertTrue(true);
        } catch (java.net.MalformedURLException e) {
            assertTrue(false);
        }

        // throw error for bad urls
        try {
            JSONParser p = new JSONParser("raspberry cook");
            assertTrue(false);
        } catch (java.net.MalformedURLException e) {
            assertTrue(true);
        }
    }

    public void testGet() {
        try {
            JSONParser p = new JSONParser("https://raspberry-cook.fr/recipes.json");
            JSONObject json = p.Get();
            System.out.print("azaz\r\n");
            System.out.print(json.keys());
            assertTrue(true);
        } catch (Exception e) {
        }

    }
}
