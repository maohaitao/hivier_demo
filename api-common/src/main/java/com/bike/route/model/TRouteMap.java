package com.bike.route.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_route_map")
public class TRouteMap implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("level_id")
    @Expose
    private Integer levelId;//remark:关卡Id;length:10
    @pbdb_alias("city_name")
    @Expose
    private String cityName;//remark:当前城市;length:255

    @pbdb_alias("next_city_id")
    @Expose
    private String nextCityId;//remark:下一个城市;length:255
    @Expose
    private String nextCityName;//remark:下一个城市;length:255
    @pbdb_alias("city_element")
    @Expose
    private String cityElement;//remark:城市元素;length:255
    @pbdb_alias("city_mark")
    @Expose
    private String cityMark;//remark:城市标志;length:255
    @pbdb_alias("c_distance")
    @Expose
    private Integer cDistance;//remark:城市间虚拟距离;length:10
    @pbdb_alias("c_time")
    @Expose
    private Date cTime;//remark:;length:19

    @pbdb_alias("c_avg_time")
    @Expose
    private Integer cAvgTime;//remark:;length:19 `c_avg_time` int(11) DEFAULT NULL COMMENT '大概需要多少天到达',

    @pbdb_alias("image")
    @Expose
    private String image;//remark:城市元素;lengt
    @pbdb_alias("theme_url")
    @Expose
    private String themeUrl;//remark:皮肤URL;length:200
    @pbdb_alias("theme_icon")
    @Expose
    private String themeIcon;//remark:皮肤预览URL;length:200

    @pbdb_alias("cityBgColor")
    @Expose
    private String cityBgColor;

    @pbdb_alias("calendarBgColor")
    @Expose
    private String calendarBgColor;

    @pbdb_alias("calendarCircleColor")
    @Expose
    private String calendarCircleColor;

    @pbdb_alias("cityDesc")
    @Expose
    private String cityDesc;


    public TRouteMap() {
    }

    public Integer getcDistance() {
        return cDistance;
    }

    public void setcDistance(Integer cDistance) {
        this.cDistance = cDistance;
    }

    public String getCityElement() {
        return cityElement;
    }

    public void setCityElement(String cityElement) {
        this.cityElement = cityElement;
    }

    public String getCityMark() {
        return cityMark;
    }

    public void setCityMark(String cityMark) {
        this.cityMark = cityMark;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }


    public String getNextCityId() {
        return nextCityId;
    }

    public void setNextCityId(String nextCityId) {
        this.nextCityId = nextCityId;
    }

    public String getNextCityName() {
        return nextCityName;
    }

    public void setNextCityName(String nextCityName) {
        this.nextCityName = nextCityName;
    }

    public Integer getcAvgTime() {
        return cAvgTime;
    }

    public void setcAvgTime(Integer cAvgTime) {
        this.cAvgTime = cAvgTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getCityBgColor() {
        return cityBgColor;
    }

    public void setCityBgColor(String cityBgColor) {
        this.cityBgColor = cityBgColor;
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

    public String getCalendarBgColor() {
        return calendarBgColor;
    }

    public void setCalendarBgColor(String calendarBgColor) {
        this.calendarBgColor = calendarBgColor;
    }

    public String getCalendarCircleColor() {
        return calendarCircleColor;
    }

    public void setCalendarCircleColor(String calendarCircleColor) {
        this.calendarCircleColor = calendarCircleColor;
    }

    public String getCityDesc() {
        return cityDesc;
    }

    public void setCityDesc(String cityDesc) {
        this.cityDesc = cityDesc;
    }
}