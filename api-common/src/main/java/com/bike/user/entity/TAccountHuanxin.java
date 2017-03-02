package com.bike.user.entity;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;

/**
 * Created by a700 on 16/9/29.
 */
@pbdb_alias("t_account_huanxin")
public class TAccountHuanxin implements Serializable {

    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null

    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:账号ID;length:64; not null,default:null

    @pbdb_alias("huanxin_id")
    @Expose
    private String huanxinId;//remark:账号ID;length:64; not null,default:null

    @pbdb_alias("huanxin_pass")
    @Expose
    private String huanxinPass;//remark:账号ID;length:64; not null,default:null

    @pbdb_alias("huanxin_name")
    @Expose
    private String huanxinName;//remark:账号ID;length:64; not null,default:null

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getHuanxinId() {
        return huanxinId;
    }

    public void setHuanxinId(String huanxinId) {
        this.huanxinId = huanxinId;
    }

    public String getHuanxinPass() {
        return huanxinPass;
    }

    public void setHuanxinPass(String huanxinPass) {
        this.huanxinPass = huanxinPass;
    }

    public String getHuanxinName() {
        return huanxinName;
    }

    public void setHuanxinName(String huanxinName) {
        this.huanxinName = huanxinName;
    }
}
