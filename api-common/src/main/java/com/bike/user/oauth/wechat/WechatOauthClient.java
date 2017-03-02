package com.bike.user.oauth.wechat;

import com.bike.user.model.OauthUser;
import com.bike.user.model.TAccount;
import com.bike.user.oauth.IOauthClient;
import com.g3.common.http.HttpClientUtil;
import com.google.gson.JsonObject;
import com.sf.common.exception.AppException;
import com.sf.common.reflection.property.PropertiesUtil;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.JsonUtil;

/**
 * Created by a700 on 16/2/24.
 */
public class WechatOauthClient implements IOauthClient {

    private static final WechatConfig wechatConfig = PropertiesUtil.getConfig("wechatconfig.properties", WechatConfig.class);

    @Override
    public String authorize(String state) {
        return null;
    }

    @Override
    public String getAccessToken(String code) throws Exception {
        return null;
    }

    @Override
    public OauthUser getOauthUser(String code) throws Exception {
        return null;
    }

    @Override
    public TAccount getNickName(String openid, String accessToken) throws Exception {
        if (CommonUtil.isNull(accessToken)) {
            throw new AppException(-6, "accessToken[wechat]没有获取到响应参数，可能是用户取消了授权.");
        }
        if (CommonUtil.isNull(openid)) {
            throw new AppException(-6, "Openid[wechat]没有获取到响应参数，可能是用户取消了授权.");
        }

        String url = wechatConfig.getGetUserInfoURL() + "?access_token=" + accessToken + "&openid=" + openid + "&lang=zh_CN";
        String responseText = HttpClientUtil.get(url).getStringData();
//        System.out.println("wechat resText:" + responseText);
        TAccount account = new TAccount();
        if (!CommonUtil.isNull(responseText)) {
            JsonObject json = JsonUtil.parse(responseText);
            String nickname = JsonUtil.getValue(json, "nickname");
            account.setNickName(nickname.trim());
            String userFace = JsonUtil.getValue(json, "headimgurl");
//            headimgurl	用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
//            System.out.println(userFace);
            account.setUserFace(userFace.trim());
        }
        return account;
    }
}
