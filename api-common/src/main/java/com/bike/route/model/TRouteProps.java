package com.bike.route.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_route_props")
public class TRouteProps implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:用户Id;length:255; not null,default:null
    @pbdb_alias("p_type")
    @Expose
    private Integer pType;//remark:道具类型 1 超能卡;length:10
    @pbdb_alias("props_name")
    @Expose
    private String propsName;//remark:道具名称;length:255
    @pbdb_alias("c_distance")
    @Expose
    private Integer cDistance;//remark:对应距离;length:10
    @pbdb_alias("energy_value")
    @Expose
    private Integer energyValue;//remark:获得能量值;length:10
    @pbdb_alias("p_status")
    @Expose
    private Integer pStatus;//remark:道具状态 1 可使用 2 已使用 3 已到期;length:10
    @pbdb_alias("end_time")
    @Expose
    private Date endTime;//remark:到期时间;length:19
    @pbdb_alias("c_time")
    @Expose
    private Date cTime;//remark:;length:19

    public TRouteProps() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getcDistance() {
        return cDistance;
    }

    public void setcDistance(Integer cDistance) {
        this.cDistance = cDistance;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(Integer energyValue) {
        this.energyValue = energyValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropsName() {
        return propsName;
    }

    public void setPropsName(String propsName) {
        this.propsName = propsName;
    }

    public Integer getpStatus() {
        return pStatus;
    }

    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    public Integer getpType() {
        return pType;
    }

    public void setpType(Integer pType) {
        this.pType = pType;
    }
}