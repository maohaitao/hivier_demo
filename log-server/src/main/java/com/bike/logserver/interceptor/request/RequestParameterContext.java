package com.bike.logserver.interceptor.request;

import com.bike.bananacard.bean.ProtocolHeader;
import com.bike.bananacard.common.tools.json.JsonParam;
import com.google.gson.JsonObject;

/**
 * created with bananaCard.
 * date: 16/1/14
 * time: 上午9:47
 * description: 封装请求参数
 */
public class RequestParameterContext extends JsonParam {
    private ProtocolHeader header;
    private String accountId;
    private String token;
    private String handle; // 接收的参数需要解压处理
    private String shandle;// = request.getParameter("shandle"); 返回参数压缩处理

    RequestParameterContext() {
    }

    public ProtocolHeader getHeader() {
        return header;
    }

    void setHeader(ProtocolHeader header) {
        this.header = header;
    }

    public String getToken() {
        return token;
    }

    void setToken(String token) {
        this.token = token;
    }

    public String getAccountId() {
        return accountId;
    }

    void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    void setParameter(JsonObject parameter) {
        this.setJsonObject(parameter);
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getShandle() {
        return shandle;
    }

    public void setShandle(String shandle) {
        this.shandle = shandle;
    }

    @Override
    public String toString() {
        return "RequestParameterContext{" +
                "accountId='" + accountId + '\'' +
                ", header=" + header +
                ", token='" + token + '\'' +
                ", handle='" + handle + '\'' +
                ", shandle='" + shandle + '\'' +
                '}';
    }
}
