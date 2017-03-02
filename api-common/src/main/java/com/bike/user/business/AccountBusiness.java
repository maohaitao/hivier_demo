package com.bike.user.business;

import com.bike.user.model.TAccount;
import com.sf.common.exception.AppException;
import com.sf.common.model.DynamicResult;

import java.util.Map;

/**
 * Created by a700 on 16/1/11.
 */
public interface AccountBusiness {

    public DynamicResult registerAccount(String phone, String pw, String vercode, Integer deviceType,
                                         String deviceNo, String version, String visitorToken  , Map<String ,String>ipProvence,String v) throws AppException;

    /**
     * 试用注册
     * @param deviceType
     * @param deviceNo
     * @param version
     * @return
     */
    public DynamicResult registerVisitorAccount(Integer deviceType, String deviceNo, String version,  Map<String ,String> ipProvence,String v);

    public DynamicResult login(String phone, String pw);

    public DynamicResult logout(String token) throws AppException;

    public DynamicResult reflushToken(String token);

    public DynamicResult oauth(String openid, Integer type, String access_token, Integer deviceType, String deviceNo,
                               String nickName, String userFace, String version, String visitorToken,String v) throws AppException;

    public DynamicResult resetpw(String phone, String pw, String vercode, Integer deviceType, String deviceNo);

    public DynamicResult updateInfo(TAccount account, String token) throws AppException;

    public DynamicResult updateUserFace(TAccount account, String token);

    public DynamicResult updateUserProfile(TAccount account, String token);

    public DynamicResult updateWeight(TAccount account, String token);
}
