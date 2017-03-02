package com.bike.user.business;

import com.bike.apicommon.AppContext;
import com.bike.apicommon.cache.CacheFactory;
import com.bike.apicommon.cache.CacheService;
import com.bike.apicommon.cache.RedisService;
import com.bike.apicommon.utils.SMSUtils;
import com.sf.common.log.LogService;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.RandomUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by a700 on 16/1/11.
 */
public class SMSBusiness {

    private static int expri = 30 * 60; // 默认有效期 30分钟
    private static int expri_phone = 24 * 60 * 60; // 24小时只能使用5次
    private static int sms_num = 5;
    private CacheService cacheService = CacheFactory.createCacheService(2);

    public static void main(String[] args) {
        SMSBusiness smsBusiness = new SMSBusiness();
        smsBusiness.sendSMS("15099994974", 0);
//        RedisService.getJedisCache().del("15099994974");
        Object c = CacheFactory.createCacheService(2).getString("register_code_15099994974");
        System.out.println(c);
//        System.out.println(CacheFactory.createCacheService(2).get("register_code_15099994974", null));
    }

    public boolean sendSMS(String phone, Integer type) {
        boolean flag = false;
        String num = RedisService.getJedisCache().get(phone);
        if (CommonUtil.isNumber(num) && Integer.parseInt(num) >= sms_num) {
            return false;
        }
        if (type != null && type == 0) { // 注册的验证码
            flag = sendRegisterSMS(phone);
        } else if (type != null && type == 1) {
            flag = sendFundPWSMS(phone);
        }
        if (flag) {
            if (CommonUtil.isNull(num)) {
                RedisService.getJedisCache().setex(phone, expri_phone, "1");
            } else {
                RedisService.getJedisCache().incr(phone);
            }
        }
        return flag;
    }

    private boolean sendRegisterSMS(String phone) {
        if (CommonUtil.isNull(phone)) {
            return false;
        }
        String vercode = RandomUtils.getRandomNumberString(4);
        String content = AppContext.SMS_VERCODE.replaceAll("xxxx", vercode);
//        System.out.println(content);
        String re = null;
        try {
            re = SMSUtils.sendMessage(phone, content);
        } catch (UnsupportedEncodingException e) {
            LogService.error("sendRegisterSMS,发送注册验证码失败:", e);
            return false;
        }
//        System.out.println(re);
        cacheService.setString(AppContext.REGISTER_VERCODE + phone, vercode, expri);
        return true;
    }

    private boolean sendFundPWSMS(String phone) { // TODO 通过短信找回密码
        if (CommonUtil.isNull(phone)) {
            return false;
        }
        String vercode = RandomUtils.getRandomNumberString(4);
        String content = AppContext.SMS_VERCODE.replaceAll("xxxx", vercode);
        try {
            String re = SMSUtils.sendMessage(phone, content);
        } catch (UnsupportedEncodingException e) {
            LogService.error("sendFundPWSMS,发送找回密码验证码失败:", e);
            return false;
        }
        cacheService.setString(AppContext.FUNDPW_VERCODE + phone, vercode, expri);
        return true;
    }
}
