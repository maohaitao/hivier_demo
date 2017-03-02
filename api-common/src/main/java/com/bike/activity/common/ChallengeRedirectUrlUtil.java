package com.bike.activity.common;

import com.bike.apicommon.DES;
import com.google.gson.JsonObject;
import com.sf.common.log.LogService;
import com.sf.common.properties.PropertiesLoader;
import com.sf.common.util.CommonUtil;
import java.util.Properties;

/**
 * Created by allen duan on 17/1/16.
 *
 * 获取h5跳转地址
 */
public class ChallengeRedirectUrlUtil {
    private static String challenge_share_url = null;//分享页
    private static String challenge_result_url = null;//结果页


    static {
        Properties properties = PropertiesLoader.loadProperties("project.properties");
        if(CommonUtil.isNull(challenge_share_url)){
            challenge_share_url = properties.getProperty("challenge_share_url");
        }

        if(CommonUtil.isNull(challenge_result_url)){
            challenge_result_url = properties.getProperty("challenge_result_url");
        }
    }


    public static String getChallengeShareUrl(Integer challengeId,boolean doEncode){
        if(CommonUtil.isNull(challenge_share_url)||challengeId==null){
            return null;
        }
        JsonObject json = new JsonObject();
        json.addProperty("challengeId",challengeId);
        String param = "";
        try {
            if(doEncode){
                param = DES.encrypt(json.toString());
            }else{
                param = json.toString();
            }
        }catch (Exception e){
            LogService.error("getChallengeShareUrl error:"+e);
        }
        return challenge_share_url+"?param="+ param;
    }


    public static String getChallengeResultUrl(Integer challengeId,String accountId,boolean doEncode){
        if(CommonUtil.isNull(challenge_result_url)||CommonUtil.isNull(accountId)||challengeId==null){
            return null;
        }
        JsonObject json = new JsonObject();
        json.addProperty("challengeId",challengeId);
        json.addProperty("accountId",accountId);
        String param = "";
        try {
            if(doEncode){
                param = DES.encrypt(json.toString());
            }else{
                param = json.toString();
            }
        }catch (Exception e){
            LogService.error("getChallengeShareUrl error:"+e);
        }
        return challenge_result_url+"?param="+ param;
    }



}
