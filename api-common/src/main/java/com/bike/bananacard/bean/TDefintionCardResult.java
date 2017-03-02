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
@pbdb_alias("t_defiontion_card_result")
public class TDefintionCardResult extends CardResult implements Serializable {

    private Double result;//remark:运动结果;length:10
    @pbdb_alias("plan_result")
    private Double planResult;//remark:计划结果;length:10
    private Integer duration;//remark:持续时间/分钟;length:10

    @pbdb_alias("create_time")
    private Date createTime;//remark:创建时间;length:0; not null,default:null

    @pbdb_alias("is_del")
    private Integer is_del;//逻辑删除：1 删除 0 未删除



    public TDefintionCardResult() {
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


//	public Integer getTimes() {
//		return times;
//	}
//
//	public void setTimes(Integer times) {
//		this.times = times;
//	}
}