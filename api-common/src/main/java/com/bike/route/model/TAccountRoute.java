package com.bike.route.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_account_route")
public class TAccountRoute implements Serializable {
    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:用户Id;length:255; not null,default:null
    @pbdb_alias("energy_value")
    @Expose
    private Integer energyValue;//remark:能量值;length:10
    @pbdb_alias("city_id")
    @Expose
    private Integer cityId;//remark:当前城市;length:255
    @Expose
    @pbdb_ignore
    private String cityName;//remark:当前城市;length:255

    @pbdb_alias("next_city_id")
    @Expose
    private Integer nextCityId;//remark:下一个城市;length:255
    @Expose
    @pbdb_ignore
    private String nextCityName;//remark:下一个城市;length:255

    @Expose
    @pbdb_ignore
    private Integer tRanking;//remark:排名;length:10

    @pbdb_alias("v_distance")
    @Expose
    private Integer vDistance;//remark:虚拟距离;length:10
    @pbdb_alias("c_time")
    private Date cTime;//remark:;length:19
    @pbdb_alias("arrivals_time")
    private Date arrivalsTime;//remark:;length:19 alter table t_account_route add `arrivals_time` date DEFAULT NULL COMMENT '到达时间';

    @Expose
    @pbdb_ignore
    private Double exceed;//= 0.0; // 超过多少

    @Expose
    @pbdb_ignore
    private Integer days;//= 0; // 使用天数

    @Expose
    @pbdb_ignore
    private Integer levelId;//remark:关卡Id;length:10

    @pbdb_alias("card_num")
    private Integer cardNum = 0; // 打卡总数

    @pbdb_alias("run_distance")
    private Double runDistance;

    @pbdb_alias("walk_count")
    private Integer walkCount;

    @pbdb_alias("continue_card_count")
    private Integer continueCardCount;


    public TAccountRoute() {
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Integer getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(Integer energyValue) {
        this.energyValue = energyValue;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getNextCityId() {
        return nextCityId;
    }

    public void setNextCityId(Integer nextCityId) {
        this.nextCityId = nextCityId;
    }

    public String getNextCityName() {
        return nextCityName;
    }

    public void setNextCityName(String nextCityName) {
        this.nextCityName = nextCityName;
    }

    public Integer getvDistance() {
        return vDistance;
    }

    public void setvDistance(Integer vDistance) {
        this.vDistance = vDistance;
    }

    public Integer gettRanking() {
        return tRanking;
    }

    public void settRanking(Integer tRanking) {
        this.tRanking = tRanking;
    }

    public Double getExceed() {
        return exceed;
    }

    public void setExceed(Double exceed) {
        this.exceed = exceed;
    }

    public Date getArrivalsTime() {
        return arrivalsTime;
    }

    public void setArrivalsTime(Date arrivalsTime) {
        this.arrivalsTime = arrivalsTime;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getCardNum() {
        return cardNum;
    }

    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    public Double getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(Double runDistance) {
        this.runDistance = runDistance;
    }

    public Integer getWalkCount() {
        return walkCount;
    }

    public void setWalkCount(Integer walkCount) {
        this.walkCount = walkCount;
    }

    public Integer getContinueCardCount() {
        return continueCardCount;
    }

    public void setContinueCardCount(Integer continueCardCount) {
        this.continueCardCount = continueCardCount;
    }

    @Override
    public String toString() {
        return "TAccountRoute{" +
                "accountId='" + accountId + '\'' +
                ", energyValue=" + energyValue +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", nextCityId=" + nextCityId +
                ", nextCityName='" + nextCityName + '\'' +
                ", tRanking=" + tRanking +
                ", vDistance=" + vDistance +
                ", cTime=" + cTime +
                ", arrivalsTime=" + arrivalsTime +
                ", exceed=" + exceed +
                ", days=" + days +
                ", cardNum=" + cardNum +
                '}';
    }
}