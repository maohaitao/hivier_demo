package com.bike.activity.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by allen duan on 17/1/6.
 *
 * 挑战实物奖励记录
 */
@pbdb_alias("t_challenge_reward_entity")
public class ChallengeRewardEntity implements Serializable {

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
    @pbdb_alias("send_time")
    private Date sendTime;//'寄送时间'

    @Expose
    @pbdb_alias("is_send")
    private Integer isSend;//'是否发货0 否 1是'

    @Expose
    @pbdb_alias("is_recive")
    private Integer isRecive;// '是否收货0 否 1是'


    @Expose
    @pbdb_alias("explain")
    private String explain;//'奖励说明'



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

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public Integer getIsRecive() {
        return isRecive;
    }

    public void setIsRecive(Integer isRecive) {
        this.isRecive = isRecive;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Override
    public String toString() {
        return "ChallengeRewardEntity{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", challengeId=" + challengeId +
                ", challengeName='" + challengeName + '\'' +
                ", rewardId=" + rewardId +
                ", rewardName='" + rewardName + '\'' +
                ", gainTime=" + gainTime +
                ", themeIcon='" + themeIcon + '\'' +
                ", sendTime=" + sendTime +
                ", isSend=" + isSend +
                ", isRecive=" + isRecive +
                '}';
    }
}
