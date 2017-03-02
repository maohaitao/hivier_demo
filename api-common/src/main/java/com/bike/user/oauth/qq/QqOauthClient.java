package com.bike.user.oauth.qq;

import com.bike.user.enu.OauthType;
import com.bike.user.model.OauthUser;
import com.bike.user.model.TAccount;
import com.bike.user.oauth.IOauthClient;
import com.g3.common.http.HttpClientUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sf.common.exception.AppException;
import com.sf.common.reflection.property.PropertiesUtil;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.JsonUtil;

import java.net.URLEncoder;

//import com.sf.apicommon.log.RsyncLog;


public class QqOauthClient implements IOauthClient {
    private static final QqConfig qqConfig = PropertiesUtil.getConfig("qqconfig.properties", QqConfig.class);

    public String authorize(String state) {
        StringBuilder sb = new StringBuilder();
        sb.append(qqConfig.getAuthorizeURL()).append("?response_type=code").append("&client_id=" + qqConfig.getApp_ID()).append("&scope=" + qqConfig.getScope())
                .append("&redirect_uri=" + URLEncoder.encode(qqConfig.getRedirect_URI())).append("&state=" + state);
        return sb.toString();
    }

    public OauthUser getOauthUser(String code) throws Exception {
        String accessToken = getAccessToken(code);
        String openid = getOpenID(accessToken);
        return getOauthUser(accessToken, openid);
    }

    @Override
    public TAccount getNickName(String openid, String accessToken) throws Exception {
        if (CommonUtil.isNull(accessToken)) {
            throw new AppException(-6, "accessToken[QQ]没有获取到响应参数，可能是用户取消了授权.");
        }
        if (CommonUtil.isNull(openid)) {
            throw new AppException(-6, "Openid[QQ]没有获取到响应参数，可能是用户取消了授权.");
        }

        String url = qqConfig.getGetUserInfoURL() + "?access_token=" + accessToken + "&oauth_consumer_key="
                + qqConfig.getApp_ID() + "&openid=" + openid + "&format=json";
        String responseText = HttpClientUtil.get(url).getStringData();
        TAccount account = new TAccount();
        if (!CommonUtil.isNull(responseText)) {
            JsonObject json = JsonUtil.parse(responseText);
            String nickname = JsonUtil.getValue(json, "nickname");
            account.setNickName(nickname.trim());
            String userFace = JsonUtil.getValue(json, "figureurl_qq_2");

//            figureurl_1	大小为50×50像素的QQ空间头像URL。
//            figureurl_2	大小为100×100像素的QQ空间头像URL。
//            figureurl_qq_1	大小为40×40像素的QQ头像URL。
//            figureurl_qq_2	大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。

//            System.out.println(userFace);
            account.setUserFace(userFace.trim());
        }
        return account;
    }

    public String getAccessToken(String code) throws Exception {
        String url = qqConfig.getAccessTokenURL() + "?grant_type=authorization_code";
        url += "&client_id=" + qqConfig.getApp_ID();
        url += "&client_secret=" + qqConfig.getApp_KEY();
        url += "&code=" + code;
        url += "&redirect_uri=" + URLEncoder.encode(qqConfig.getRedirect_URI());
        // 返回access_token=FE04************************CCE2&expires_in=7776000&refresh_token=88E4************************BE14
        String responseText = HttpClientUtil.get(url).getStringData();
//        LogService.debug("qq getAccessToken result:" + responseText);

        String accessToken = "";
        if (responseText.indexOf("access_token=") >= 0) {
            String[] ps = responseText.split("&");
            for (String p : ps) {
                if (p.indexOf("access_token=") >= 0) {
                    accessToken = p.split("=")[1];
                    break;
                }
            }
        }
        return accessToken;
    }

    public String getOpenID(String accessToken) throws Exception {
        if (CommonUtil.isNull(accessToken)) {
            throw new AppException(-6, "Openid[QQ]没有获取到响应参数，可能是用户取消了授权。 ");
        }

        String url = qqConfig.getGetOpenIDURL() + "?access_token=" + accessToken;
        String responseText = HttpClientUtil.get(url).getStringData();
//        LogService.debug("qq getOpenID result:" + responseText);
        String openid = "";
        int callbackIndex = responseText.indexOf("callback(");
        int beginIndex = callbackIndex + 9;
        int endIndex = responseText.indexOf(");");
        if (callbackIndex >= 0) {
            String jsonText = responseText.substring(beginIndex, endIndex).trim();
            JsonObject json = JsonUtil.parse(jsonText);
            openid = JsonUtil.getValue(json, "openid");
        }
        return openid;
    }

    public OauthUser getOauthUser(String accessToken, String openid) throws Exception {
        if (CommonUtil.isNull(accessToken)) {
            throw new AppException(-6, "Openid[QQ]没有获取到响应参数，可能是用户取消了授权。 ");
        }
        String url = qqConfig.getGetUserInfoURL() + "?oauth_consumer_key=" + qqConfig.getApp_ID();
        url += "&access_token=" + accessToken;
        url += "&openid=" + openid;
        url += "&format=json";
        String responseText = HttpClientUtil.get(url).getStringData();
//        LogService.debug("qq getOauthUser result:" + responseText);
        JsonObject json = (JsonObject) new JsonParser().parse(responseText);
        if (JsonUtil.getValue(json, "ret", 0) != 0) {// 获取不了用户信息
            throw new AppException(-6, "很抱歉，我们没能正确获取到您的信息，原因是： " + JsonUtil.getValue(json, "msg"));
        }
        OauthUser user = new OauthUser();
        user.setOpenid(openid);
        user.setOpenTypeIndex(OauthType.QQ.getOauthType());
        user.setPetName(JsonUtil.getValue(json, "nickname"));
        user.setPortraiturl(JsonUtil.getValue(json, "figureurl_1"));
        String gender = JsonUtil.getValue(json, "gender");
        user.setSex("男".equals(gender) ? 1 : ("女".equals(gender) ? 2 : 0));
        return user;
    }

}
