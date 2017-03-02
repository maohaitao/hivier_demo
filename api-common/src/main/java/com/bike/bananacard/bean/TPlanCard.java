package com.bike.bananacard.bean;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_plan_card")
public class TPlanCard implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:用户Id;length:45
    @pbdb_alias("card_id")
    @Expose
    private Integer cardId;//remark:卡片Id;length:10
    @pbdb_alias("plan_type")
    @Expose
    private Integer planType;//remark:1:自然周 2:自然月;length:10
    @pbdb_alias("plan_value")
    @Expose
    private Integer planValue;//remark:计划值;length:10
    @pbdb_alias("is_clock")
    @Expose
    private Integer isClock;//remark:是否闹钟提醒 0 否 1 是;length:10; not null,default:0
    @pbdb_alias("clock_time")
    @Expose
    private String clockTime;//remark:闹钟时间 ：9：00;length:64
    @pbdb_alias("plan_day")
    @Expose
    private String planDay;//remark:0 周日 1 周一 2 周二 3周三 4 周四 5周五 6周六;length:128
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:创建时间;length:19; not null,default:null
    @pbdb_ignore
    @pbdb_alias("update_time")
    @Expose
    private Date updateTime;//remark:修改时间;length:19; not null,default:CURRENT_TIMESTAMP
    @pbdb_alias("c_status")
    @Expose
    private Integer cStatus;//remark:状态 1下线 0 正常;length:10

    public TPlanCard() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getClockTime() {
        return clockTime;
    }

    public void setClockTime(String clockTime) {
        this.clockTime = clockTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsClock() {
        return isClock;
    }

    public void setIsClock(Integer isClock) {
        this.isClock = isClock;
    }

    public String getPlanDay() {
        return planDay;
    }

    public void setPlanDay(String planDay) {
        this.planDay = planDay;
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Integer getPlanValue() {
        return planValue;
    }

    public void setPlanValue(Integer planValue) {
        this.planValue = planValue;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TPlanCard{" +
                "accountId='" + accountId + '\'' +
                ", id=" + id +
                ", cardId=" + cardId +
                ", planType=" + planType +
                ", planValue=" + planValue +
                ", isClock=" + isClock +
                ", clockTime='" + clockTime + '\'' +
                ", planDay='" + planDay + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", cStatus=" + cStatus +
                '}';
    }
}