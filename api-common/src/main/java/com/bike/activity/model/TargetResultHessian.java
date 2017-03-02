package com.bike.activity.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by a700 on 17/1/12.
 */
public class TargetResultHessian implements Serializable {

    /**
     * 挑战相关
     */
    private Integer id;
    private String accountId;//'用户id'
    private Integer challengeId;//'挑战id'
    private Integer cardId;// '目标类型 -1 所有卡 0 运动卡 1 计步卡 2 跑步卡 50体重卡'
    private Integer countType;//'统计类型 1 打卡天数 2 连续打卡天数 3 公里和 4 连续走步天数 5 计步和'
    private Date startTime;//'统计开始时间'
    private Date endTime;//'统计截止时间'
    private Double target;//'目标数'
    private Double result;//'目标达成情况'
    private Integer status;//'0未达成 1已达成'
    private Integer startWalkCount;//'大于x步'
    private String startRunPace;//'目标数'
    private String endRunPace;//'配速小于X'
    private Double startPerDistance;//'单次跑步公里小于'
    private Double endPerDistance;//'单次跑步公里大于'
    private Integer challengeStatus;//'挑战状态'

    /**
     * 用户打卡相关
     */
    private Integer userCardId;//'卡片id'
    private Integer userCardResultId;//'卡片结果id'
    private Double userCardResult;//'卡片结果'
    private Double userCardPlanResult;//'卡片预期结果'
    private Date userCardStartTime;//'打卡开始时间' 计步、体重用到

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

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getCountType() {
        return countType;
    }

    public void setCountType(Integer countType) {
        this.countType = countType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStartWalkCount() {
        return startWalkCount;
    }

    public void setStartWalkCount(Integer startWalkCount) {
        this.startWalkCount = startWalkCount;
    }

    public String getStartRunPace() {
        return startRunPace;
    }

    public void setStartRunPace(String startRunPace) {
        this.startRunPace = startRunPace;
    }

    public String getEndRunPace() {
        return endRunPace;
    }

    public void setEndRunPace(String endRunPace) {
        this.endRunPace = endRunPace;
    }

    public Double getStartPerDistance() {
        return startPerDistance;
    }

    public void setStartPerDistance(Double startPerDistance) {
        this.startPerDistance = startPerDistance;
    }

    public Double getEndPerDistance() {
        return endPerDistance;
    }

    public void setEndPerDistance(Double endPerDistance) {
        this.endPerDistance = endPerDistance;
    }

    public Integer getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(Integer userCardId) {
        this.userCardId = userCardId;
    }

    public Integer getUserCardResultId() {
        return userCardResultId;
    }

    public void setUserCardResultId(Integer userCardResultId) {
        this.userCardResultId = userCardResultId;
    }

    public Double getUserCardResult() {
        return userCardResult;
    }

    public void setUserCardResult(Double userCardResult) {
        this.userCardResult = userCardResult;
    }

    public Date getUserCardStartTime() {
        return userCardStartTime;
    }

    public void setUserCardStartTime(Date userCardStartTime) {
        this.userCardStartTime = userCardStartTime;
    }

    public Double getUserCardPlanResult() {
        return userCardPlanResult;
    }

    public void setUserCardPlanResult(Double userCardPlanResult) {
        this.userCardPlanResult = userCardPlanResult;
    }

    public Integer getChallengeStatus() {
        return challengeStatus;
    }

    public void setChallengeStatus(Integer challengeStatus) {
        this.challengeStatus = challengeStatus;
    }

    @Override
    public String toString() {
        return "TargetResultHessian{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", challengeId=" + challengeId +
                ", cardId=" + cardId +
                ", countType=" + countType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", target=" + target +
                ", result=" + result +
                ", status=" + status +
                ", startWalkCount=" + startWalkCount +
                ", startRunPace='" + startRunPace + '\'' +
                ", endRunPace='" + endRunPace + '\'' +
                ", startPerDistance=" + startPerDistance +
                ", endPerDistance=" + endPerDistance +
                ", userCardId=" + userCardId +
                ", userCardResultId=" + userCardResultId +
                ", userCardResult=" + userCardResult +
                ", userCardStartTime=" + userCardStartTime +
                '}';
    }
}
