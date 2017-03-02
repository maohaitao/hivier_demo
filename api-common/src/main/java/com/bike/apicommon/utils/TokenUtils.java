package com.bike.apicommon.utils;

import com.bike.apicommon.RSAUtils;
import com.bike.apicommon.cache.CacheFactory;
import com.bike.apicommon.cache.CacheService;
import com.bike.user.model.TAccount;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.DateUtil;
import org.apache.commons.codec.binary.Base64;

import java.util.Date;
//import java.util.UUID;

/**
 * Created by a700 on 16/1/12.
 */
public class TokenUtils {

    public static int token_expi = 12 * 30 * 24 * 60 * 60; // token的有效期为 12*30天
    public static int openId_expi = 60; // openId的有效期为 1天
    public static String openID = "1";
    static String key = "&&";
    static CacheService cacheService = CacheFactory.createCacheService(2);

    //生成规则 aid+&&+token截止有效期 加密
    public static String createToken(String aid) {
        String time = DateUtil.addSecond(new Date(), token_expi).getTime() + "";
        String token = null;
        try {
            token = Base64.encodeBase64URLSafeString(RSAUtils.encryptByPrivateKey((aid + key + time).getBytes()));
        } catch (Exception e) {
            LogService.error("createToken error:" + aid, e);
        }
        return token;
//        return UUID.randomUUID().toString().replace("-", "");
    }

    // 通过token 获取用户ID
    public static String getIDByToken(String token) throws AppException {
        if (CommonUtil.isNull(token)) {
            throw new AppException(0110, "登录失效请重新登录");
        }
        String id = "";
        try {
            String parm = new String(RSAUtils.decryptByPublicKey(Base64.decodeBase64(token.getBytes())));
            if (!CommonUtil.isNull(parm)) {
                String[] parms = parm.split(key);
                id = parms[0];
            }
        } catch (Exception e) {
            LogService.error("getIDByToken error:", e);
        }
        return id;
    }

    // 判断token有效性 有效期 是否和 ai对应 false 未失效
    public static boolean checkToken(String token, TAccount account) throws AppException {
        boolean flag = false;
        if (CommonUtil.isNull(token)) {
            return false;
        }

        String id = getIDByToken(token);
        String reToken = cacheService.getString(id) + "";

        if (!CommonUtil.isNull(reToken) && !token.equals(reToken)) {
            if (cacheService.get(token, TAccount.class) != null) {
                TokenUtils.deltokenCache(reToken);
//                System.out.println("reToken==" + reToken);
                LogService.info("checkToken 踢出 Id:" + id + "|reToken=" + reToken + "|token=" + token);
            }
        }

        if (account == null || CommonUtil.isNull(account.getAccountId())) {
            account = (TAccount) cacheService.get(token, TAccount.class);
            if (account == null || CommonUtil.isNull(account.getAccountId())) {
                throw new AppException(0110, "登录失效请重新登录");
            }
        } else {
            settokenCache(token, account);
        }

        return flag;
    }


    public static boolean logincheckToken(String token, TAccount account) throws AppException {
        boolean flag = false;
        if (CommonUtil.isNull(token) || account == null) {
            return false;
        }

        String id = getIDByToken(token);
        String reToken = cacheService.getString(id) + "";

        if (!CommonUtil.isNull(reToken) && !token.equals(reToken)) {
            TokenUtils.deltokenCache(reToken);
            LogService.info("logincheckToken 踢出 Id:" + id + "|reToken=" + reToken + "|token=" + token);
        }

        flag = settokenCache(token, account);

        return flag;
    }

    public static TAccount flushToken(String token, TAccount account) throws AppException {
        if (CommonUtil.isNull(token)) {
            return null;
        }
        if (account == null || CommonUtil.isNull(account.getAccountId())) {
            account = (TAccount) cacheService.get(token, TAccount.class);
            if (account == null || CommonUtil.isNull(account.getAccountId())) {
                throw new AppException(0110, "登录失效请重新登录");
            }
            String id = getIDByToken(token);
            String reToken = cacheService.getString(id) + "";
            if (!token.equals(reToken) && !CommonUtil.isNull(reToken)) {
                TokenUtils.deltokenCache(reToken);
                LogService.info("flushToken 踢出 Id:" + id + "|reToken=" + reToken + "|token=" + token);
            }
            settokenCache(token, account); // 延长时效 TODO
        } else {
            settokenCache(token, account);
        }
        return account;
    }

    /**
     * 验证token是否有效
     *
     * @param token
     * @return
     * @throws AppException
     */
    public static boolean   flushToken(String token) throws AppException {
        if (CommonUtil.isNull(token)) {
            return false;
        }
        TAccount account = (TAccount) cacheService.get(token, TAccount.class);
        if (account == null || CommonUtil.isNull(account.getAccountId())) {
            throw new AppException(0110, "登录失效请重新登录");
        }
        String id = getIDByToken(token);
        String reToken = cacheService.getString(id) + "";
        if (!token.equals(reToken) && !CommonUtil.isNull(reToken)) {
            TokenUtils.deltokenCache(reToken);
            LogService.info("flushToken 踢出 Id:" + id + "|reToken=" + reToken + "|token=" + token);
        }
        settokenCache(token, account); // 延长时效 TODO
        return true;
    }

    public static TAccount getTAccountById(String id) throws AppException {
        if (CommonUtil.isNull(id)) {
            return null;
        }
        String token = cacheService.getString(id) + "";
        TAccount account = (TAccount) cacheService.get(token, TAccount.class);
        return  account;
    }


    public static String filterEmoji(String source) {
        if (!CommonUtil.isNull(source)) {
//            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");
            return source.replaceAll("[^\\u0000-\\uFFFF]", "*");
        } else {
            return source;
        }
    }

    public static TAccount gettokenCache(String token) {
        if (CommonUtil.isNull(token)) {
            return null;
        }
        TAccount account = (TAccount) cacheService.get(token, TAccount.class);
        return account;
    }

    public static boolean settokenCache(String token, TAccount account) {
        if (CommonUtil.isNull(token) || account == null) {
            return false;
        }

        boolean flag = true;
        cacheService.setString(account.getAccountId(), token, TokenUtils.token_expi);
        cacheService.set(token, account, TokenUtils.token_expi);
        return flag;
    }

    public static String getTokenById(String id){
        if (CommonUtil.isNull(id) || id == null) {
            return null;
        }
        return (String) cacheService.getString(id);
    }

    public static boolean setOpenIdCache(String openId, Integer type) {
        if (CommonUtil.isNull(openId) || openId == null) {
            return false;
        }
        boolean flag = true;
        cacheService.setString(openId + key + type, openID, TokenUtils.openId_expi);
        return flag;
    }

    public static String getOpenIdCache(String openId, Integer type) {
        if (CommonUtil.isNull(openId) || openId == null) {
            return "";
        }
        return (String) cacheService.getString(openId + key + type);
    }

    public static boolean delOpenIdCache(String openId, Integer type) {
        if (CommonUtil.isNull(openId) || openId == null) {
            return false;
        }
        boolean flag = true;
        cacheService.del(openId + key + type);
        return flag;
    }


    public static boolean deltokenCache(String token) throws AppException {
        if (CommonUtil.isNull(token)) {
            return false;
        }
        boolean flag = true;
        String id = getIDByToken(token);
        cacheService.del(id);
        flag = cacheService.del(token);
        return flag;
    }

    public static void main(String[] args) {
        String id = null;
        try {
            id = TokenUtils.getIDByToken("bHesk2p1wjL_mciS5MRYso1smh_aallqdUZp-c34CEqMKwzAqsoGD80hdgEZZW8SV_TnYCeGqVgo4Bc4mRWpOg");
        } catch (AppException e) {
            e.printStackTrace();
        }
        System.out.println("id==" + id);
//        String test="蒋阿婆\uD83D\uDC7B";
//        System.out.println(TokenUtils.filterEmoji(test));
    }
}
