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
public class RsyncWeightUtil {

    // TODO 注意地址切换
    private static String Base_url = "http://192.168.175.136:8080/userCenter/api/a/fa323/rsyncweight.shtml";

    /**
     * @param token 1 成功 2( null) 失败
     * @return
     */
    public static JsonElement rsyncWeight(String token, Double weight) {
        JsonElement jsonElement = null;
        if (!CommonUtil.isNull(token)) {
            String url = Base_url + "?token=" + token + "&weight=" + weight;
            String result = loadJSON(url);
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
        JsonElement jsonElement = RsyncWeightUtil.rsyncWeight("JMLse30dwF2tT0zxckc7zk-6gHGMewFJv19QOq0UgKWCtl9yjiCpXYAJksvr84cpck4bYI_wMPAW7FwpF1wO8w", 90.00);// 18520129388
        System.out.println("jsonElement = " + jsonElement);
    }
}
