package com.bike.activity.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;

/**
 * Created by allen duan on 17/1/6.
 *
 * 挑战目标
 */
@pbdb_alias("t_challenge_target")
public class ChallengeTarget implements Serializable {
    @Expose
    @pbdb_alias("id")
    private Integer id;

    @Expose
    @pbdb_alias("challenge_id")
    private Integer challengeId;//'挑战id'

    @Expose
    @pbdb_alias("card_id")
    private Integer cardId;// '目标类型 -1 所有卡 0 运动卡 1 计步卡 2 跑步卡 50体重卡'

    @Expose
    @pbdb_alias("count_type")
    private Integer countType;//'统计类型 1 打卡天数 2 连续打卡天数 3 公里和 4 连续走步天数 5 计步和'

    @Expose
    @pbdb_alias("target")
    private Double target;//'目标数'

    @Expose
    @pbdb_alias("start_walk_count")
    private Integer startWalkCount;//'大于x步'

    @Expose
    @pbdb_alias("start_run_pace")
    private String startRunPace;//'目标数'

    @Expose
    @pbdb_alias("end_run_pace")
    private String endRunPace;//'配速小于X'

    @Expose
    @pbdb_alias("start_per_distance")
    private Double startPerDistance;//'单次跑步公里小于'

    @Expose
    @pbdb_alias("end_per_distance")
    private Double endPerDistance;//'单次跑步公里大于'

    @Expose
    @pbdb_alias("explain")
    private String explain;//'目标说明'


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

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
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

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Override
    public String toString() {
        return "ChallengeTarget{" +
                "id=" + id +
                ", challengeId=" + challengeId +
                ", cardId=" + cardId +
                ", countType=" + countType +
                ", target=" + target +
                ", startWalkCount=" + startWalkCount +
                ", startRunPace='" + startRunPace + '\'' +
                ", endRunPace='" + endRunPace + '\'' +
                ", startPerDistance=" + startPerDistance +
                ", endPerDistance=" + endPerDistance +
                ", explain='" + explain + '\'' +
                '}';
    }
}
