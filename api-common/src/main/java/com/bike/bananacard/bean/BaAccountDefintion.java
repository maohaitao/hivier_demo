package com.bike.bananacard.bean;

import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("ba_account_defintion")
public class BaAccountDefintion extends UserCard implements Serializable {

    @pbdb_alias("account_id")
    private String accountId;//remark:账号ID;length:64; not null,default:null
    @pbdb_alias("start_date")
    private Date startDate;//remark:卡片开始日期;length:0; not null,default:null

    @pbdb_alias("create_time")
    private Date createTime;//remark:卡片开始日期;length:0; not null,default:null
    @pbdb_alias("end_date")
    private Date endDate;//remark:卡片结束日期;length:0
    @pbdb_alias("is_day_card")
    private Integer isDayCard;//remark:是否为每日卡是否为每日卡0:否 1:是;length:10; not null,default:1
    private Integer sort;//remark:排序;length:10
    @pbdb_alias("c_status")
    private Integer cStatus;//remark:状态 1下线 0 正常;length:64; not null,default:null

    public BaAccountDefintion() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public Integer getIsDayCard() {
        return isDayCard;
    }

    @Override
    public void setIsDayCard(Integer isDayCard) {
        this.isDayCard = isDayCard;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}