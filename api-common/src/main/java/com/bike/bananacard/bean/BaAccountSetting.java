package com.bike.bananacard.bean;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;


/*  */
@pbdb_alias("ba_account_card_setting")
public class BaAccountSetting implements Serializable {
    @pbdb_alias("acount_id")
    @Expose
    private String acountId;//remark:;length:10; not null,default:null
    @pbdb_alias("card_id")
    @Expose
    private Integer cardId;//remark:;length:10; not null,default:null
    @pbdb_alias("create_time")
    @Expose
    private String createTime;//remark:创建时间;length:45
    @pbdb_alias("starte_time")
    @Expose
    private String starteTime;//remark:开始时间;length:45
    @pbdb_alias("end_time")
    @Expose
    private String endTime;//remark:课程结束时间;length:45
    @pbdb_alias("setting_value")
    @Expose
    private Double settingValue;//remark:设置的值;length:10

    @pbdb_alias("before_value")
    @Expose
    private Double beforeValue;//remark:设置之前的值;length:10

    public BaAccountSetting() {
    }

    public String getAcountId() {
        return acountId;
    }

    public void setAcountId(String acountId) {
        this.acountId = acountId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(Double settingValue) {
        this.settingValue = settingValue;
    }

    public String getStarteTime() {
        return starteTime;
    }

    public void setStarteTime(String starteTime) {
        this.starteTime = starteTime;
    }

    public Double getBeforeValue() {
        return beforeValue;
    }

    public void setBeforeValue(Double beforeValue) {
        this.beforeValue = beforeValue;
    }
}