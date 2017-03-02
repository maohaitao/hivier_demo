package com.bike.route.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_route_result")
public class TRouteResult implements Serializable {
    @pbdb_ignore
//    @Expose
    private Integer id;//remark:;length:10; not null,default:null

    @pbdb_alias("account_id")
//    @Expose
    private String accountId;//remark:用户Id;length:255; not null,default:null
    @pbdb_alias("city_id")
    @Expose
    private Integer cityId;//remark:当前城市;length:255
    @Expose
    @pbdb_ignore
    private String cityName;//remark:当前城市;length:255
    @pbdb_alias("next_city_id")
//    @Expose
    private String nextCityId;//remark:下一个城市;length:255
    @pbdb_alias("t_ranking")
    @Expose
    private Integer tRanking;//remark:排名;length:10
    @pbdb_alias("c_time")
//  @Expose
    private Date cTime;//remark:到达时间;length:19
    @Expose
    private Double exceed;//= 0.0; // 超过多少
    @Expose
    private Integer days;//= 0; // 使用天数
    @pbdb_alias("theme_url")
    @Expose
    private String themeUrl;//remark:皮肤URL;length:200
    @pbdb_alias("theme_icon")
    @Expose
    private String themeIcon;//remark:皮肤预览URL;length:200
    @pbdb_alias("level_id")
    @Expose
    private String levelId;//remark:等级Id

    public TRouteResult() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getNextCityId() {
        return nextCityId;
    }

    public void setNextCityId(String nextCityId) {
        this.nextCityId = nextCityId;
    }

    public Integer gettRanking() {
        return tRanking;
    }

    public void settRanking(Integer tRanking) {
        this.tRanking = tRanking;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getExceed() {
        return exceed;
    }

    public void setExceed(Double exceed) {
        this.exceed = exceed;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getThemeIcon() {
        return themeIcon;
    }

    public void setThemeIcon(String themeIcon) {
        this.themeIcon = themeIcon;
    }

    public String getThemeUrl() {
        return themeUrl;
    }

    public void setThemeUrl(String themeUrl) {
        this.themeUrl = themeUrl;
    }

    @Override
    public String toString() {
        return "TRouteResult{" +
                "accountId='" + accountId + '\'' +
                ", id=" + id +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", nextCityId='" + nextCityId + '\'' +
                ", tRanking=" + tRanking +
                ", cTime=" + cTime +
                ", exceed=" + exceed +
                ", days=" + days +
                ", themeUrl='" + themeUrl + '\'' +
                ", themeIcon='" + themeIcon + '\'' +
                ", levelId='" + levelId + '\'' +
                '}';
    }
}