package com.bike.apicommon.utils;

import com.bike.apicommon.RSAUtils;
import com.bike.bananacard.common.constant.ErrorCode;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.DateUtil;
import org.apache.commons.codec.binary.Base64;

import java.util.Date;

/**
 * Created by a700 on 16/1/12.
 */
public class ParamUtils {

    public static int token_expi = 3*12 * 30 * 24 * 60 * 60; // token的有效期为 12*30天
    static String key = "&&";

    //生成规则 参数 处理 加密
    public static String createParamEncrypt(String param) {
        String time = DateUtil.addSecond(new Date(), token_expi).getTime() + "";
        String token = null;
        try {
            token = Base64.encodeBase64URLSafeString(RSAUtils.encryptByPrivateKey((param + key + time).getBytes()));
        } catch (Exception e) {
            LogService.error("createParamEncrypt error:" + param, e);
        }
        return token;
    }

    // 参数 解密
    public static String getParamDecrypt(String code) throws AppException {
        if (CommonUtil.isNull(code)) {
            throw new AppException(ErrorCode.PARAMETERS_INCORRECT.getCode(), ErrorCode.PARAMETERS_INCORRECT.getMsg());
        }
        String parm = "";
        try {
            parm = new String(RSAUtils.decryptByPublicKey(Base64.decodeBase64(code.getBytes())));
        } catch (Exception e) {
            LogService.error("getParamDecrypt error:", e);
        }
        return parm;
    }

    public static void main(String[] args) {
        String id = null;
//        try {
//            id = ParamUtils.getIDByToken("bHesk2p1wjL_mciS5MRYso1smh_aallqdUZp-c34CEqMKwzAqsoGD80hdgEZZW8SV_TnYCeGqVgo4Bc4mRWpOg");
//        } catch (AppException e) {
//            e.printStackTrace();
//        }
        System.out.println("id==" + id);
    }
}
