package com.bike.sns.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("basms_task")
public class BasmsTask implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("sms_id")
    @Expose
    private String smsId;//remark:对应的消息ID;length:45; not null,default:null
    @pbdb_ignore
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:创建时间;length:19
    @pbdb_alias("starte_time")
    @Expose
    private String starteTime;//remark:开始时间;length:45
    @pbdb_alias("end_time")
    @Expose
    private String endTime;//remark:课程结束时间;length:45
    @pbdb_alias("t_status")
    @Expose
    private Integer tStatus;//remark:状态 0 未开始 1 进行中 2 已结束;length:10
    @pbdb_alias("t_type")
    @Expose
    private Integer tType;//remark:1 系统任务(每天执行 t_status 为1) 2 普通任务;length:10

    public BasmsTask() {

    }

    @Override
    public String toString() {
        return "BasmsTask{" +
                "createTime=" + createTime +
                ", id=" + id +
                ", smsId='" + smsId + '\'' +
                ", starteTime='" + starteTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", tStatus=" + tStatus +
                ", tType=" + tType +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public String getStarteTime() {
        return starteTime;
    }

    public void setStarteTime(String starteTime) {
        this.starteTime = starteTime;
    }

    public Integer gettStatus() {
        return tStatus;
    }

    public void settStatus(Integer tStatus) {
        this.tStatus = tStatus;
    }

    public Integer gettType() {
        return tType;
    }

    public void settType(Integer tType) {
        this.tType = tType;
    }
}