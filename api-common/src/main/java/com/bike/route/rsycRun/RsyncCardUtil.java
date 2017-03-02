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
 *         同步卡片信息
 */
public class RsyncCardUtil {

    // TODO 注意地址切换
//    private static String Base_url = "http://106.75.134.227/userCenter/api/a/fa323/rsyncCard.shtml";
//  private static String Base_url = "http://localhost:8081/userCenter/api/a/fa323/rsyncCard.shtml";
    private static String Base_url = "http://192.168.175.136:8080/userCenter/api/a/fa323/rsyncCard.shtml";

    /**
     * @param result
     * @param plan_result
     * @param token
     * @param cardType
     * @return
     */
    public static JsonElement rsyncRun(String result, String plan_result, String token, Integer cardType) {
        JsonElement jsonElement = null;
        if (!CommonUtil.isNull(token)) {
            String url = Base_url + "?token=" + token + "&result=" + result + "&plan_result=" + plan_result + "&card_type=" + cardType;
//            System.out.println("url=" + url);
            String results = loadJSON(url);
//            System.out.println("result=" + result);
            JsonObject jsonObject = JsonUtil.parse(results);
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
        JsonElement jsonElement = RsyncCardUtil.rsyncRun("7.4", "5.0", "boHJa2xy_KXh33W7xe4__uxk7tib3_VITvlawdgCD2HPzRohzp8bn2vtdr8xTjAhrFa0wWbjQC4y4GPISu3zlA", 1);// 18520129388
        System.out.println("jsonElement = " + jsonElement);
    }
}
