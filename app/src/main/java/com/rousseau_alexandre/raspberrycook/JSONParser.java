package com.rousseau_alexandre.raspberrycook;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class JSONParser {

    /**
     * Target URL
     */
    private URL url;

    public JSONParser(String _url) throws MalformedURLException {
        url = new URL(_url);
    }


    /**
     * Launch a GET query
     * @see https://stackoverflow.com/questions/2012497/accepting-a-certificate-for-https-on-android/
     * @see https://developer.android.com/training/articles/security-ssl.html#SelfSigned
     * @return
     */
    public JSONObject Get() {

        try {
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            // connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    HostnameVerifier hv =
                            HttpsURLConnection.getDefaultHostnameVerifier();
                    return hv.verify("raspberry-cook.fr", session);
                }

            });
            // connection.setRequestProperty("Content-Type", "application/json");
            // connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            // convert as JSON
            InputStream inputStream = connection.getInputStream();
            String jsonString = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
            System.out.print(jsonString);
            return new JSONObject(jsonString);
        }catch(JSONException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JSONObject();
    }

}
