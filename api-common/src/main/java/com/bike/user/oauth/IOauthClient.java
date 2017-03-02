package com.bike.user.oauth;

import com.bike.user.model.OauthUser;
import com.bike.user.model.TAccount;

public interface IOauthClient {
    String authorize(String state);

    String getAccessToken(String code) throws Exception;

    OauthUser getOauthUser(String code) throws Exception;

    TAccount getNickName(String openid, String accessToken) throws Exception;
}
