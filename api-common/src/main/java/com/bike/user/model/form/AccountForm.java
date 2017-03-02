package com.bike.user.model.form;

import com.bike.user.model.TAccount;

import java.io.Serializable;

/**
 * Created by a700 on 16/1/11.
 */
public class AccountForm implements Serializable {

    private String token; //
    private long expiress_in; // 有效期
    private long hra_expires_in;  // 高危有效期
    private TAccount userinfo;// 用户信息

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiress_in() {
        return expiress_in;
    }

    public void setExpiress_in(long expiress_in) {
        this.expiress_in = expiress_in;
    }

    public long getHra_expires_in() {
        return hra_expires_in;
    }

    public void setHra_expires_in(long hra_expires_in) {
        this.hra_expires_in = hra_expires_in;
    }

    public TAccount getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(TAccount userinfo) {
        this.userinfo = userinfo;
    }
}
