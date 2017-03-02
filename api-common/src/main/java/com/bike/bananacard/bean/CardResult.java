package com.bike.bananacard.bean;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/14
 * time: 下午2:26
 * description: 卡片结果
 */
public class CardResult implements Serializable {
    @pbdb_ignore
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("card_id")
    private Integer cardId;//remark:卡片ID;length:10; not null,default:null
    @pbdb_alias("account_id")
    private String accountId;//remark:;length:64; not null,default:null
    private Double kcal;//remark: 消耗大卡/千/卡里路;length:10
    @pbdb_alias("start_time")
    private Date startTime;//运动开始日期
    @pbdb_alias("end_time")
    private Date endTime;//运动结束日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getKcal() {
        return kcal;
    }

    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

}
