package com.bike.route.rsycRun;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.JsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author hesin
 */
public class RsyncRunUtil {

    // TODO 注意地址切换
    private static String Base_url = "http://106.75.134.227/userCenter/api/a/fa323/runresult.shtml";
//    private static String Base_url = "http://localhost:8081/userCenter/api/a/fa323/runresult.shtml";

    /**
     * @param distance 跑步距离 km
     * @param time     跑步时间 ms
     * @param token
     * @return
     */
    public static JsonElement rsyncRun(String distance, String time, String token) {
        JsonElement jsonElement = null;
        if (!CommonUtil.isNull(token)) {
            String url = Base_url + "?token=" + token + "&time=" + time + "&distance=" + distance + "&isCheat=false";
//            System.out.println("url=" + url);
            String result = loadJSON(url);
//            System.out.println("result=" + result);
            JsonObject jsonObject = JsonUtil.parse(result);
            if (jsonObject != null) {
                jsonElement = jsonObject.get("dResult");
            }
        }
        return jsonElement;
    }

    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public static void main(String[] args) {
        JsonElement jsonElement = RsyncRunUtil.rsyncRun("4.8", "3307430", "EbADxKKacXPmcqbJBnW72W-0lpo4nFxMxHdXUj93mxOf5QC_SLPScQeJAcm0tBWoebRg3VE75GKb3Zv6HvZcmg");// 18520129388
        System.out.println("jsonElement = " + jsonElement);
    }
}
