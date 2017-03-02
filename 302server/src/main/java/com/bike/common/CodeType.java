package com.bike.common;

/**
 * Created by a700 on 16/10/18.
 */
public enum CodeType {


    //机型
    AND("1","and"),
    IOS("2","ios"),

    //平台类型
    WEB("3","web"),
    WAP("4","wap"),

    //跳转类型
    APK_LOAD_ERROR("3000", "无法识别下载平台类型"),

    AND_APK_LOAD("3001", "android应用下载"),
    IOS_APK_LOAD("3002", "ios应用下载"),
    APP_SHARE_EWM("3003", "app分享二维码"),


    SHARE_302("00001", "分享302"),
    WEBSITE_LODD("00002", "官网下载"),
    ZHEDA_HUODONG("00003", "浙大活动");


    private String code;
    private String msg;

    CodeType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
