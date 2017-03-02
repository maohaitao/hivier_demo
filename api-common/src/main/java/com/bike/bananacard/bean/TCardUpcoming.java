package com.bike.bananacard.bean;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_card_upcoming")
public class TCardUpcoming implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("card_id")
    @Expose
    private Integer cardId;//remark:卡片Id;length:10
    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:用户Id;length:125; not null,default:null
    @Expose
    private String info;//remark:描述;length:255
    @pbdb_alias("upcoming_date")
    @Expose
    private String upcomingDate;//remark:待办日期;length:45
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

    public TCardUpcoming() {
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUpcomingDate() {
        return upcomingDate;
    }

    public void setUpcomingDate(String upcomingDate) {
        this.upcomingDate = upcomingDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TCardUpcoming{" +
                "accountId='" + accountId + '\'' +
                ", id=" + id +
                ", cardId=" + cardId +
                ", info='" + info + '\'' +
                ", upcomingDate='" + upcomingDate + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", cStatus=" + cStatus +
                '}';
    }
}