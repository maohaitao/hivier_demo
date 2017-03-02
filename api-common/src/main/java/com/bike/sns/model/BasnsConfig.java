package com.bike.sns.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("basns_config")
public class BasnsConfig implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("config_name")
    @Expose
    private String configName;//remark:配置名(对应表名);length:45; not null,default:null
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:创建时间;length:19
    @pbdb_alias("starte_time")
    @Expose
    private String starteTime;//remark:开始时间;length:45
    @pbdb_alias("end_time")
    @Expose
    private String endTime;//remark:课程结束时间;length:45
    @pbdb_alias("c_status")
    @Expose
    private Integer cStatus;//remark:状态 0 未开始 1 进行中;length:10

    public BasnsConfig() {
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
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

    public String getStarteTime() {
        return starteTime;
    }

    public void setStarteTime(String starteTime) {
        this.starteTime = starteTime;
    }
}