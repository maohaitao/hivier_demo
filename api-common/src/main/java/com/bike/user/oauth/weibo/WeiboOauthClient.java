package com.bike.user.oauth.weibo;

import com.bike.user.enu.OauthType;
import com.bike.user.model.OauthUser;
import com.bike.user.model.TAccount;
import com.bike.user.oauth.IOauthClient;
import com.g3.common.http.HttpClientUtil;
import com.g3.common.http.model.FormData;
import com.g3.common.http.model.PostData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sf.common.exception.AppException;
import com.sf.common.reflection.property.PropertiesUtil;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.JsonUtil;

import java.net.URLEncoder;

//import com.sf.apicommon.log.RsyncLog;

public class WeiboOauthClient implements IOauthClient {
    private static final WeiboConfig weiboConfig = PropertiesUtil.getConfig("weiboconfig.properties", WeiboConfig.class);

    public String authorize(String state) {
        StringBuilder sb = new StringBuilder();
        sb.append(weiboConfig.getAuthorizeURL()).append("?response_type=code").append("&client_id=" + weiboConfig.getClient_ID()).append("&scope=" + weiboConfig.getScope())
                .append("&state=" + state).append("&redirect_uri=" + URLEncoder.encode(weiboConfig.getRedirect_URI()));
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
            throw new AppException(-6, "accessToken[weibo]没有获取到响应参数，可能是用户取消了授权。 ");
        }
        if (CommonUtil.isNull(openid)) {
            throw new AppException(-6, "openid[weibo]没有获取到响应参数，可能是用户取消了授权。 ");
        }

        String url = weiboConfig.getShow() + "?access_token=" + accessToken + "&uid=" + openid;
//        LogService.debug("url:" + url);
        String responseText = HttpClientUtil.get(url).getStringData();
//        LogService.debug("weibo getNickName result:" + responseText);
        JsonObject json = JsonUtil.parse(responseText);
        String nickname = JsonUtil.getValue(json, "screen_name");
        TAccount account = new TAccount();
        account.setNickName(nickname);
        String userFace = JsonUtil.getValue(json, "avatar_hd");

//        avatar_large	string	用户头像地址（大图），180×180像素
//        avatar_hd	string	用户头像地址（高清），高清头像原图

//        System.out.println( );
        account.setUserFace(userFace);
        return account;
    }

    public String getAccessToken(String code) throws Exception {
        String url = weiboConfig.getAccessTokenURL();
        FormData formData = new FormData();
        formData.addParam("grant_type", "authorization_code");
        formData.addParam("client_id", weiboConfig.getClient_ID());
        formData.addParam("client_secret", weiboConfig.getClient_SERCRET());
        formData.addParam("code", code);
        formData.addParam("redirect_uri", weiboConfig.getRedirect_URI());
        PostData postData = new PostData(formData);
        String responseText = HttpClientUtil.post(url, postData).getStringData();
//        LogService.debug("weibo getAccessToken result:" + responseText);
        JsonObject json = JsonUtil.parse(responseText);
        String accessToken = JsonUtil.getValue(json, "access_token");
        return accessToken;
    }

    public String getOpenID(String accessToken) throws Exception {
        if (CommonUtil.isNull(accessToken)) {
            throw new AppException(-6, "Openid[weibo]没有获取到响应参数，可能是用户取消了授权。 ");
        }
        String url = weiboConfig.getBaseURL() + "account/get_uid.json" + "?access_token=" + accessToken;
        String responseText = HttpClientUtil.get(url).getStringData();
//        LogService.debug("weibo getOpenID result:" + responseText);
        JsonObject json = JsonUtil.parse(responseText);
        String openid = JsonUtil.getValue(json, "uid");
        return openid;
    }

    public OauthUser getOauthUser(String accessToken, String openid) throws Exception {
        if (CommonUtil.isNull(accessToken)) {
            throw new AppException(-6, "Openid[weibo]没有获取到响应参数，可能是用户取消了授权。 ");
        }
        String url = weiboConfig.getBaseURL() + "users/show.json" + "?access_token=" + accessToken;
        url += "&uid=" + openid;
        String responseText = HttpClientUtil.get(url).getStringData();
//        LogService.debug("weibo getOauthUser result:" + responseText);
        JsonObject json = (JsonObject) new JsonParser().parse(responseText);
        if (!CommonUtil.isNull(JsonUtil.getValue(json, "error_code"))) {// 获取不了用户信息
            throw new AppException(-6, "很抱歉，我们没能正确获取到您的信息，原因是： " + JsonUtil.getValue(json, "error"));
        }
        OauthUser user = new OauthUser();
        user.setOpenid(openid);
        user.setOpenTypeIndex(OauthType.WEIBO.getOauthType());
        user.setPetName(JsonUtil.getValue(json, "name"));
        user.setPortraiturl(JsonUtil.getValue(json, "profile_image_url"));
        String gender = JsonUtil.getValue(json, "gender");
        user.setSex("m".equals(gender) ? 1 : ("f".equals(gender) ? 2 : 0));
        return user;
    }

}
