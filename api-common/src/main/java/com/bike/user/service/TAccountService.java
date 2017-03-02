package com.bike.user.service;

import com.bike.user.model.TAccount;
import com.bike.user.serializable.PageBean;

/**
 * Created by a700 on 16/1/11.
 * 账号基础信息
 */
public interface TAccountService {

    public TAccount queryByPhone(String phone);

    public TAccount queryByOpenId(String openid, Integer type);

    public TAccount queryById(String id);

    public TAccount queryByIdOnCache(String id);

    public TAccount add(TAccount account);

    public boolean updatePW(TAccount account);

    public boolean checkNickName(String nickName, String id);

    public boolean updateInfo(TAccount account);

    public boolean updateUserFace(TAccount account);

    public boolean updateUserProfile(TAccount account);

    public boolean updateIpProvince(TAccount account);

    public boolean updateWeight(TAccount account);

    public TAccount checkAccountIscomplete(TAccount account);

    public PageBean searchNickName(String nickName, Integer pageNum);

    /**
     * 检测手机登录帐号是否被冻结
     * @param accountId
     * @return
     */
    public boolean checkAccountForbid(String accountId);


    /**
     * 检测第三方登录帐号是否被冻结
     * @param
     * @return
     */
    public boolean checkOauthForbid(String openid, Integer type);
}
