package com.bike.user.oauth.qq;

public class QqConfig {
    private String app_ID;
    private String app_KEY;// = a48bba58fda1d37098d8a4c781ddd0f3
    private String redirect_URI;                                // http://goaccount.3g.cn/account/oauth2/openidcallback/qq
    private String scope;//  get_user_info,add_topic,add_one_blog,add_album,upload_pic,list_album,add_share,check_page_fans,add_t,add_pic_t,del_t,get_repost_list,get_info,get_other_info,get_fanslist,get_idollist,add_idol,del_ido,get_tenpay_addr
    private String baseURL;// = https://graph.qq.com/
    private String getUserInfoURL;// = https://graph.qq.com/user/get_user_info
    private String accessTokenURL;// = https://graph.qq.com/oauth2.0/token
    private String authorizeURL;// = https://graph.qq.com/oauth2.0/authorize
    private String getOpenIDURL;// = https://graph.qq.com/oauth2.0/me
    private String version;// = 2.0.0.0

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
     * @return 获取scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope
     * @Description 设置scope
     */
    public void setScope(String scope) {
        this.scope = scope;
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

    /**
     * @return 获取version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     * @Description 设置version
     */
    public void setVersion(String version) {
        this.version = version;
    }

}
