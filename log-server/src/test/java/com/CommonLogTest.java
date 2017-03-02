package com;

import com.g3.common.http.HttpClientUtil;
import com.g3.common.http.model.FormData;
import com.g3.common.http.model.HttpResult;
import com.g3.common.http.model.PostData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a700 on 16/1/8.
 */
public class CommonLogTest {

    protected static String country = "sfda";
    protected static String lang = "zh";
//  protected static String baseUrl = "http://192.168.175.136:8080/log-server";//"http://127.0.0.1:8080";//  192.168.1.204
  protected static String baseUrl = "http://localhost:8086/log";//"http://127.0.0.1:8080";//  192.168.1.204
//    protected static String baseUrl = "http://700sport.com/bananaCard";//"http://106.75.134.227/userCenter";//正式地址
    protected static String appkey = "golauncher";
    protected static String clientId = "picbuy";// "";
    protected static String clientSecret = "picbuy";// "b24eba390175f7ed";
    protected static String userid = "3894129";
    protected static String pwd = "123456";

    static String  token="nXXdTRWvG3JTpNIB7oyev5cYh38zkx4mLA_2d80VIbVcwnQ4gNwJEPqqbJtCQ44UhnRiHIFdJl5h-_5bEPy21g"; //zhengshi
    public static void main(String[] args) {
        systemCommon();
    }


    private static void systemCommon() {
        JsonObject json = new JsonObject();
//        json.addProperty("is_new", "1");
        json.addProperty("code", "1110");
        json.addProperty("data", "0111---");
        test("/a/1.3/logServer.shtml", json);
    }


    protected static void test(String serverUrl, JsonElement customFormData) {
        try {
            FormData formdata = new FormData();// 文件解压
            String handle = "1";
            formdata.addParam("shandle", "1");
            formdata.addParam("handle", handle); // CommonUtil.gzip
            formdata.addParam("client_id", clientId);
            formdata.addParam("client_secret", clientSecret);

            PostData postData = new PostData(formdata);
            String url = baseUrl + serverUrl;
//            System.out.println("url=" + url);
            JsonObject phead = new JsonObject();

            phead.addProperty("client_id", clientId);
            phead.addProperty("client_secret", clientSecret);
            phead.addProperty("hasmarket", 1);

            phead.addProperty("uid", "00001");
            phead.addProperty("phone", "samsung");
            phead.addProperty("rom", "samsung");
            phead.addProperty("sys", "testmo");
            phead.addProperty("sbuy", "1");
            phead.addProperty("imei", "21fce9a3a577792a");
            phead.addProperty("appkey", "banana");
            phead.addProperty("aid", "21fce9a3a577792a");
            phead.addProperty("cversion", "3");
            phead.addProperty("net", "WIFI");
            phead.addProperty("lang", "zh");
            phead.addProperty("pversion", "1.0");
            phead.addProperty("country", "CN");
            phead.addProperty("googlepayid", "");
            phead.addProperty("skey", "banana");
            phead.addProperty("cversionname", "1.1");
            phead.addProperty("official", "1");
            phead.addProperty("sdk", "19");
            phead.addProperty("imsi", "460003021469751");
            phead.addProperty("dpi", "1080*1920");
            phead.addProperty("phonenum", "13643014249");
            phead.addProperty("channel", "huawei1");
            phead.addProperty("cip", "192.168.2.2");

            phead.addProperty("cversionname", "3.6bata");
            phead.addProperty("clientid", "26");
            JsonObject data = new JsonObject();
            data.add("phead", phead); // 消息头
            data.add("data", customFormData); // 消息体
            data.addProperty("token", token);// 18520129388
            formdata.addParam("data", data.toString());
            HttpResult httpResult = HttpClientUtil.post(url, postData);
            System.out.println("url:"+url +" ##req:"+data+ " ##res:" + httpResult.getStringData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
