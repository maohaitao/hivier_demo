package com.bike.apicommon.utils;

import com.bike.apicommon.AppContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by a700 on 16/1/9.
 * 发送短信
 */
public class SMSUtils {

    //    用户名：10690024
//    密码：10690WEN
//    private final static String BASEURL = "http://101.227.68.49:7891/mt?un=10690024&pw=10690WEN";
    private static String hexString = "0123456789ABCDEF";

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String content = "【签名】内容xxxxxxxxxxxxxxxxx";
        //转码
//        String t = encode(content);
        System.out.println(sendMessage("15099994974", content));
    }

    public static String sendMessage(String phone, String content) throws UnsupportedEncodingException {
        String con = encode(content);
        String url = AppContext.SMS_URL + "&da=" + phone + "&sm=" + con + "&dc=15&rd=1";
        String rs = "";
        try {
            URL urlclass = new URL(url);
            try {
                URLConnection connection = urlclass.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String line = null;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                rs = sb.toString();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static String encode(String str) throws UnsupportedEncodingException {
        // 根据默认编码获取字节数组
        byte[] bytes = str.getBytes("GB2312");
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        // 将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f)));
        }
        return sb.toString();
    }
}
