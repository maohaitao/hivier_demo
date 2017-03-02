package com.bike.user.oauth.wechat;

public class WechatConfig {
    private String app_ID;
    private String app_KEY;
    private String redirect_URI;
    private String baseURL;
    private String getUserInfoURL;
    private String accessTokenURL;
    private String authorizeURL;
    private String getOpenIDURL;

    /**
     * @return 获取app_ID
     */
    public String getApp_ID() {
        return app_ID;
    }

    /**
     * @param app_ID
     * @Description 设置app_ID
     */
    public void setApp_ID(String app_ID) {
        this.app_ID = app_ID;
    }

    /**
     * @return 获取app_KEY
     */
    public String getApp_KEY() {
        return app_KEY;
    }

    /**
     * @param app_KEY
     * @Description 设置app_KEY
     */
    public void setApp_KEY(String app_KEY) {
        this.app_KEY = app_KEY;
    }

    /**
     * @return 获取redirect_URI
     */
    public String getRedirect_URI() {
        return redirect_URI;
    }

    /**
     * @param redirect_URI
     * @Description 设置redirect_URI
     */
    public void setRedirect_URI(String redirect_URI) {
        this.redirect_URI = redirect_URI;
    }

    /**
     * @return 获取baseURL
     */
    public String getBaseURL() {
        return baseURL;
    }

    /**
     * @param baseURL
     * @Description 设置baseURL
     */
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    /**
     * @return 获取getUserInfoURL
     */
    public String getGetUserInfoURL() {
        return getUserInfoURL;
    }

    /**
     * @param getUserInfoURL
     * @Description 设置getUserInfoURL
     */
    public void setGetUserInfoURL(String getUserInfoURL) {
        this.getUserInfoURL = getUserInfoURL;
    }

    /**
     * @return 获取accessTokenURL
     */
    public String getAccessTokenURL() {
        return accessTokenURL;
    }

    /**
     * @param accessTokenURL
     * @Description 设置accessTokenURL
     */
    public void setAccessTokenURL(String accessTokenURL) {
        this.accessTokenURL = accessTokenURL;
    }

    /**
     * @return 获取authorizeURL
     */
    public String getAuthorizeURL() {
        return authorizeURL;
    }

    /**
     * @param authorizeURL
     * @Description 设置authorizeURL
     */
    public void setAuthorizeURL(String authorizeURL) {
        this.authorizeURL = authorizeURL;
    }

    /**
     * @return 获取getOpenIDURL
     */
    public String getGetOpenIDURL() {
        return getOpenIDURL;
    }

    /**
     * @param getOpenIDURL
     * @Description 设置getOpenIDURL
     */
    public void setGetOpenIDURL(String getOpenIDURL) {
        this.getOpenIDURL = getOpenIDURL;
    }

}
