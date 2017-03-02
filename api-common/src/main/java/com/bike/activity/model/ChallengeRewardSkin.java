package com.bike.activity.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by allen duan on 17/1/6.
 *
 * 挑战皮肤奖励记录
 */
@pbdb_alias("t_challenge_reward_skin")
public class ChallengeRewardSkin implements Serializable{

    @Expose
    @pbdb_alias("id")
    private Integer id;

    @Expose
    @pbdb_alias("account_id")
    private String accountId;//'用户id'

    @Expose
    @pbdb_alias("challenge_id")
    private Integer challengeId;//'挑战id'

    @Expose
    @pbdb_alias("challenge_name")
    private String challengeName;//'挑战名称'

    @Expose
    @pbdb_alias("reward_id")
    private Integer rewardId;//'奖励id'

    @Expose
    @pbdb_alias("reward_name")
    private String rewardName;//'奖品名称'

    @Expose
    @pbdb_alias("gain_time")
    private Date gainTime;//'获取奖励时间'

    @Expose
    @pbdb_alias("theme_icon")
    private String themeIcon;// '预览图'

    @Expose
    @pbdb_alias("theme_url")
    private String themeUrl;//'皮肤资源地址'

    @Expose
    private Integer isOwn;//'是否拥有 0否 1是'


    @Expose
    @pbdb_alias("explain")
    private String explain;//'奖励说明'

    @Expose
    @pbdb_alias("cityBgColor")
    private String cityBgColor;//'城市背景色'

    @Expose
    @pbdb_alias("calendarBgColor")
    private String calendarBgColor;//'首页日历背板'


    @Expose
    @pbdb_alias("calendarCircleColor")
    private String calendarCircleColor;//'首页日历上圆圈颜色'


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

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public Integer getRewardId() {
        return rewardId;
    }

    public void setRewardId(Integer rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public Date getGainTime() {
        return gainTime;
    }

    public void setGainTime(Date gainTime) {
        this.gainTime = gainTime;
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

    public Integer getIsOwn() {
        return isOwn;
    }

    public void setIsOwn(Integer isOwn) {
        this.isOwn = isOwn;
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
        return "ChallengeRewardSkin{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", challengeId=" + challengeId +
                ", challengeName='" + challengeName + '\'' +
                ", rewardId=" + rewardId +
                ", rewardName='" + rewardName + '\'' +
                ", gainTime=" + gainTime +
                ", themeIcon='" + themeIcon + '\'' +
                ", themeUrl='" + themeUrl + '\'' +
                '}';
    }
}
