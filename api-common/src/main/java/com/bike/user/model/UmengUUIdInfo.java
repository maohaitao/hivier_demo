package com.bike.user.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("umeng_info")
public class UmengUUIdInfo implements Serializable {
    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:账号ID;length:64; not null,default:null
    @pbdb_alias("umeng_id")
    @Expose
    private String umengId;//remark:;length:64 @pbdb_alias("nick_name")
    @pbdb_alias("device_type")
    @Expose
    private Integer deviceType;
    @pbdb_alias("c_time")
    @Expose
    private Date cTime;//remark:注册时间;length:19; not null,default:null
    @pbdb_alias("third_type")
    @Expose
    private Integer third_type;//remark:注册时间;length:19; not null,default:null


    public UmengUUIdInfo() {

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getUmengId() {
        return umengId;
    }

    public void setUmengId(String umengId) {
        this.umengId = umengId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getThird_type() {
        return third_type;
    }

    public void setThird_type(Integer third_type) {
        this.third_type = third_type;
    }

    @Override
    public String toString() {
        return "UmengUUIdInfo{" +
                "accountId='" + accountId + '\'' +
                ", umengId='" + umengId + '\'' +
                ", deviceType=" + deviceType +
                ", cTime=" + cTime +
                '}';
    }
}