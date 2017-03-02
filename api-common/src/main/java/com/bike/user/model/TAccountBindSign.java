package com.bike.user.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;

/*  */
@pbdb_alias("t_account_bind_sign")
public class TAccountBindSign implements Serializable {
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @Expose
    private Integer type;//remark:绑定类型 1:微信 2:微博 3 qq 4 试用;length:10; not null,default:null
    @Expose
    private String openid;//remark:第三方ID;length:50; not null,default:null
    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:账号;length:64; not null,default:null

    public TAccountBindSign() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}