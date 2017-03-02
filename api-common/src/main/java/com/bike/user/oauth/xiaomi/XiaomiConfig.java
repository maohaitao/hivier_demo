package com.bike.user.oauth.xiaomi;

/**
 * Created by a700 on 16/10/28.
 *
 */
public class XiaomiConfig {
    private String client_ID;
    private String client_key;
    private String client_SERCRET;
    private String baseURL;



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

    public String getClient_key() {
        return client_key;
    }

    public void setClient_key(String client_key) {
        this.client_key = client_key;
    }
}
