package com.bike.bananacard.bean;

import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/14
 * time: 下午9:13
 * description: 通用卡片结果
 */
@pbdb_alias("t_common_card_result")
public class TCommonCardResult extends CardResult implements Serializable {

    private Double result;//remark:运动结果;length:10
    @pbdb_alias("plan_result")
    private Double planResult;//remark:计划结果;length:10
    private Integer duration;//remark:持续时间/分钟;length:10
    private Integer times;// 次数
    private Integer sequence;// 0 减 1 增加

    @pbdb_alias("create_time")
    private Date createTime;//remark:创建时间;length:0; not null,default:null

    @pbdb_alias("update_time")
    private Date updateTime;//remark:创建时间;length:0; not null,default:null

    @pbdb_alias("plan_start_time")
    private Date planStartTime;//remark:计划开始时间;length:0; not null,default:null
    @pbdb_alias("plan_before_result")
    private Double planBeforeResult;//remark:计划开始前值;length:10

    @pbdb_alias("is_del")
    private Integer is_del;//逻辑删除：1 删除 0 未删除


    @pbdb_alias("active_time")
    private Integer active_time;//活跃时间


    @pbdb_alias("per_h_count")
    private String per_h_count;//每小时计步

    @pbdb_alias("isCheat")
    private Integer isCheat;//是否作弊：1 作弊 0 未作弊

    @pbdb_alias("client_time")
    private Date client_time;//客戶端日期



    public TCommonCardResult() {
    }

    public Integer getIs_del() {
        return is_del;
    }

    public void setIs_del(Integer is_del) {
        this.is_del = is_del;
    }

    public Double getPlanResult() {
        return planResult;
    }

    public void setPlanResult(Double planResult) {
        this.planResult = planResult;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Double getPlanBeforeResult() {
        return planBeforeResult;
    }

    public void setPlanBeforeResult(Double planBeforeResult) {
        this.planBeforeResult = planBeforeResult;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Integer getActive_time() {        return active_time;    }

    public void setActive_time(Integer active_time) {        this.active_time = active_time;    }

    public String getPer_h_count() {        return per_h_count;    }

    public void setPer_h_count(String per_h_count) {        this.per_h_count = per_h_count;    }

    public Integer getIsCheat() {
        return isCheat;
    }

    public void setIsCheat(Integer isCheat) {
        this.isCheat = isCheat;
    }

    public Date getClient_time() {
        return client_time;
    }

    public void setClient_time(Date client_time) {
        this.client_time = client_time;
    }
}