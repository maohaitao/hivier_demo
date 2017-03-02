package com.bike.bananacard.common.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/5/25
 * time: 上午10:42
 * description: 描述
 */
public class HTTPRequestUtils {
    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection urlConnection = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            return null;
        }
        return json.toString();
    }
}
