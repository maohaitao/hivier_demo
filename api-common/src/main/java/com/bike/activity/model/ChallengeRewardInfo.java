package com.bike.activity.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by allen duan on 17/1/6.
 *
 * 挑战奖励
 */
@pbdb_alias("t_challenge_reward_info")
public class ChallengeRewardInfo implements Serializable {
    @Expose
    @pbdb_alias("id")
    private Integer id;

    @Expose
    @pbdb_alias("challenge_id")
    private Integer challengeId;//'挑战id'

    private String challengeName;//'挑战名称'

    @Expose
    @pbdb_alias("reward_name")
    private String rewardName;//'奖品名称'

    @Expose
    @pbdb_alias("reward_type")
    private Integer rewardType;//'奖品类型 1 皮肤 2 实物'

    @Expose
    @pbdb_alias("theme_icon")
    private String themeIcon;// '预览图'

    @Expose
    @pbdb_alias("theme_url")
    private String themeUrl;//'皮肤资源地址'


    @Expose
    @pbdb_alias("reward_time")
    private Date rewardTime;//'实物开奖日期'

    @Expose
    @pbdb_alias("number")
    private Integer number;//'实物数量'

    @Expose
    @pbdb_alias("cityBgColor")
    private String cityBgColor;//'城市背景色'

    @Expose
    @pbdb_alias("calendarBgColor")
    private String calendarBgColor;//'首页日历背板'


    @Expose
    @pbdb_alias("calendarCircleColor")
    private String calendarCircleColor;//'首页日历上圆圈颜色'


    @Expose
    @pbdb_alias("explain")
    private String explain;//'奖励说明'




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public Integer getRewardType() {
        return rewardType;
    }

    public void setRewardType(Integer rewardType) {
        this.rewardType = rewardType;
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

    public Date getRewardTime() {
        return rewardTime;
    }

    public void setRewardTime(Date rewardTime) {
        this.rewardTime = rewardTime;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getCityBgColor() {
        return cityBgColor;
    }

    public void setCityBgColor(String cityBgColor) {
        this.cityBgColor = cityBgColor;
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

    @Override
    public String toString() {
        return "ChallengeRewardInfo{" +
                "id=" + id +
                ", challengeId=" + challengeId +
                ", rewardName='" + rewardName + '\'' +
                ", rewardType=" + rewardType +
                ", themeIcon='" + themeIcon + '\'' +
                ", themeUrl='" + themeUrl + '\'' +
                ", rewardTime=" + rewardTime +
                ", number=" + number +
                '}';
    }
}
