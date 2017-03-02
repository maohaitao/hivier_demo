package com.bike.bananacard.bean;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_card_user_relation")
public class TCardUserRelation implements Serializable {
    @pbdb_ignore
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("card_id")
    private Integer cardId;//remark:卡片ID;length:10; not null,default:null
    @pbdb_alias("account_id")
    private String accountId;//remark:账号ID;length:64; not null,default:null
    @pbdb_alias("start_date")
    private Date startDate;//remark:卡片开始日期;length:0; not null,default:null
    @pbdb_alias("end_date")
    private Date endDate;//remark:卡片结束日期;length:0
    @pbdb_alias("is_day_card")
    private Integer isDayCard;//remark:是否为每日卡0:是 1:否;length:10; not null,default:1
    private Integer sort;//remark:排序;length:10
    @pbdb_alias("create_time")
    private Date createTime;
    @pbdb_alias("is_del")
    private Integer isDel;
    @pbdb_alias("is_common")
    private Integer isCommon;

    public TCardUserRelation() {
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getIsDayCard() {
        return isDayCard;
    }

    public void setIsDayCard(Integer isDayCard) {
        this.isDayCard = isDayCard;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(Integer isCommon) {
        this.isCommon = isCommon;
    }
}