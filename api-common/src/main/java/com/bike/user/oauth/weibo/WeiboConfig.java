package com.bike.user.oauth.weibo;

public class WeiboConfig {

    private String client_ID;// =3649197117
    private String client_SERCRET;// =95c5d5edf2b436e12645bc03b45f3426
    private String redirect_URI;// =http://goaccount.3g.cn/account/oauth2/openidcallback/weibo
    private String baseURL;// =https://api.weibo.com/2/
    private String accessTokenURL;// =https://api.weibo.com/oauth2/access_token
    private String authorizeURL;// =https://api.weibo.com/oauth2/authorize
    private String rmURL;// =https://rm.api.weibo.com/2/
    private String scope;
    private String show;//=https://api.weibo.com/2/users/show.json


    /**
     * @return 获取client_ID
     */
    public String getClient_ID() {
        return client_ID;
    }

    /**
     * @param client_ID
     * @Description 设置client_ID
     */
    public void setClient_ID(String client_ID) {
        this.client_ID = client_ID;
    }

    /**
     * @return 获取client_SERCRET
     */
    public String getClient_SERCRET() {
        return client_SERCRET;
    }

    /**
     * @param client_SERCRET
     * @Description 设置client_SERCRET
     */
    public void setClient_SERCRET(String client_SERCRET) {
        this.client_SERCRET = client_SERCRET;
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
     * @return 获取rmURL
     */
    public String getRmURL() {
        return rmURL;
    }

    /**
     * @param rmURL
     * @Description 设置rmURL
     */
    public void setRmURL(String rmURL) {
        this.rmURL = rmURL;
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

    //获取个人信息接口
    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }
}
