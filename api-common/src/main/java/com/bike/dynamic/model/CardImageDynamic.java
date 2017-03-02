package com.bike.dynamic.model;

import com.bike.activity.model.ChallengeBean;
import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by allen duan on 16/9/21.
 */
@pbdb_alias("t_card_image_dynamic")
public class CardImageDynamic implements Serializable {
    @Expose
    @pbdb_alias("id")
    private Integer id;
    @Expose
    @pbdb_alias("account_id")
    private String accountId;//用户帐号
    @Expose
    @pbdb_ignore
    private String nickName;//昵称
    @Expose
    @pbdb_ignore
    private String userFace;//头像
    @Expose
    @pbdb_ignore
    private Integer sex;//remark:1:男 2:女;length:10
    @Expose
    @pbdb_alias("card_id")
    private Integer card_id;//卡片id
    @Expose
    @pbdb_alias("card_name")
    private String card_name;//卡片名称
    @Expose
    @pbdb_alias("card_style")
    private Integer card_style;//卡片类型
    @Expose
    @pbdb_alias("card_unit")
    private String card_unit;//卡片单位
    @Expose
    @pbdb_alias("card_result_id")
    private Integer card_result_id;//卡片上传结果id
    @Expose
    @pbdb_alias("result")
    private Double result;//打卡结果
    @Expose
    @pbdb_alias("final_result")
    private Double finalResult;//打卡结果
    @Expose
    @pbdb_alias("plan_result")
    private Double plan_result;//打卡目标
    @Expose
    @pbdb_alias("start_time")
    private Date start_time;//开始时间
    @Expose
    @pbdb_alias("end_time")
    private Date end_time;//结束时间
    @Expose
    @pbdb_alias("create_time")
    private Date create_time;//上传时间
    @Expose
    @pbdb_alias("totaltime")
    private Integer totaltime;//耗时
    @Expose
    @pbdb_alias("speed")
    private Double speed;//平均速度
    @Expose
    @pbdb_alias("run_pace")
    private String run_pace;//配速
    @Expose
    @pbdb_alias("calorie")
    private Integer calorie;//
    @Expose
    @pbdb_alias("distance")
    private Double distance;
    @Expose
    @pbdb_alias("bmi")
    private Double bmi;
    @Expose
    @pbdb_alias("times")
    private Integer times;//第几次打该类卡
    @Expose
    @pbdb_alias("content")
    private String content;//图文内容
    @Expose
    @pbdb_alias("default_image_url")
    private String default_image_url;//默认图片
    @Expose
    @pbdb_alias("image_url")
    private String image_url;//上传图片
    @Expose
    @pbdb_ignore
    private Date push_time;
    @Expose
    @pbdb_alias("publish_time")
    private Date publish_time;//发布时间

    @Expose
    @pbdb_alias("update_time")
    private Date update_time;//更新时间
    @Expose
    @pbdb_alias("is_open")
    private Integer is_open;//是否私密 0 否 1 是 默认0
    @Expose
    @pbdb_alias("is_del")
    private Integer is_del;//是否删除 0 否 1 是 默认0
    @Expose
    @pbdb_alias("is_fb")
    private Integer is_fb;//是否禁止 0 否 1 是 默认0
    @Expose
    @pbdb_alias("is_publish")
    private Integer is_publish;//是否发布 0 否 1 是 默认0
    @Expose
    @pbdb_alias("is_recommend")
    private Integer is_recommend;//是否被推荐 0 否 1 是 m默认否
    @Expose
    @pbdb_ignore
    private Integer thumbupsCount;//点赞总数
    @Expose
    @pbdb_ignore
    private Integer commentCount;//评论总数
    @Expose
    @pbdb_ignore
    private Integer is_thumbup;//是否点过赞
    @Expose
    @pbdb_alias("is_yellow")
    private String is_yellow;//是否涉黄 0 否 1 是
    @Expose
    @pbdb_alias("is_default_yellow")
    private String is_default_yellow;//是否涉黄 0 否 1 是

    @Expose
    @pbdb_ignore
    private String publishTimeStr;

    @Expose
    @pbdb_ignore
    private Integer followStatus;

    @pbdb_alias("run_type")
    private Integer runType;//remark:跑步类型: 0：室外跑 1：室内跑;length：11;default：0

    @Expose
    @pbdb_alias("dynamic_update_time")
    private Date dynamic_update_time;//动态更新时间
    @Expose
    @pbdb_alias("is_approve")
    private Integer isApprove;//涉黃是否審批

    @Expose
    @pbdb_alias("challengeIds")
    private String challengeIds;//挑战id串

    @Expose
    @pbdb_alias("isCheat")
    private Integer isCheat;//是否作弊0否 1是

    @Expose
    @pbdb_ignore
    private List<ChallengeBean> challengeBasicList;



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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public Integer getCard_style() {
        return card_style;
    }

    public void setCard_style(Integer card_style) {
        this.card_style = card_style;
    }

    public String getCard_unit() {
        return card_unit;
    }

    public void setCard_unit(String card_unit) {
        this.card_unit = card_unit;
    }

    public Integer getCard_result_id() {
        return card_result_id;
    }

    public void setCard_result_id(Integer card_result_id) {
        this.card_result_id = card_result_id;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Double getPlan_result() {
        return plan_result;
    }

    public void setPlan_result(Double plan_result) {
        this.plan_result = plan_result;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(Integer totaltime) {
        this.totaltime = totaltime;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDefault_image_url() {
        return default_image_url;
    }

    public void setDefault_image_url(String default_image_url) {
        this.default_image_url = default_image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getIs_open() {
        return is_open;
    }

    public void setIs_open(Integer is_open) {
        this.is_open = is_open;
    }

    public Integer getIs_del() {
        return is_del;
    }

    public void setIs_del(Integer is_del) {
        this.is_del = is_del;
    }

    public Integer getIs_fb() {
        return is_fb;
    }

    public void setIs_fb(Integer is_fb) {
        this.is_fb = is_fb;
    }

    public Integer getIs_publish() {
        return is_publish;
    }

    public void setIs_publish(Integer is_publish) {
        this.is_publish = is_publish;
    }

    public Integer getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(Integer is_recommend) {
        this.is_recommend = is_recommend;
    }

    public Integer getThumbupsCount() {
        return thumbupsCount;
    }

    public void setThumbupsCount(Integer thumbupsCount) {
        this.thumbupsCount = thumbupsCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getIs_thumbup() {
        return is_thumbup;
    }

    public void setIs_thumbup(Integer is_thumbup) {
        this.is_thumbup = is_thumbup;
    }


    public String getIs_yellow() {
        return is_yellow;
    }

    public void setIs_yellow(String is_yellow) {
        this.is_yellow = is_yellow;
    }

    public String getIs_default_yellow() {
        return is_default_yellow;
    }

    public void setIs_default_yellow(String is_default_yellow) {
        this.is_default_yellow = is_default_yellow;
    }

    public String getPublishTimeStr() {
        return publishTimeStr;
    }

    public void setPublishTimeStr(String publishTimeStr) {
        this.publishTimeStr = publishTimeStr;
    }

    public String getRun_pace() {
        return run_pace;
    }

    public void setRun_pace(String run_pace) {
        this.run_pace = run_pace;
    }

    public Integer getCalorie() {
        return calorie;
    }

    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(Double finalResult) {
        this.finalResult = finalResult;
    }

    public Integer getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(Integer followStatus) {
        this.followStatus = followStatus;
    }

    public Date getPush_time() {
        return push_time;
    }

    public void setPush_time(Date push_time) {
        this.push_time = push_time;
    }

    public Integer getRunType() {
        return runType;
    }

    public void setRunType(Integer runType) {
        this.runType = runType;
    }

    public Date getDynamic_update_time() {
        return dynamic_update_time;
    }

    public void setDynamic_update_time(Date dynamic_update_time) {
        this.dynamic_update_time = dynamic_update_time;
    }

    public Integer getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Integer isApprove) {
        this.isApprove = isApprove;
    }

    public String getChallengeIds() {
        return challengeIds;
    }

    public void setChallengeIds(String challengeIds) {
        this.challengeIds = challengeIds;
    }

    public List<ChallengeBean> getChallengeBasicList() {
        return challengeBasicList;
    }

    public void setChallengeBasicList(List<ChallengeBean> challengeBasicList) {
        this.challengeBasicList = challengeBasicList;
    }

    public Integer getIsCheat() {
        return isCheat;
    }

    public void setIsCheat(Integer isCheat) {
        this.isCheat = isCheat;
    }


    @Override
    public String toString() {
        return "CardImageDynamic{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userFace='" + userFace + '\'' +
                ", sex=" + sex +
                ", card_id=" + card_id +
                ", card_name='" + card_name + '\'' +
                ", card_style=" + card_style +
                ", card_unit='" + card_unit + '\'' +
                ", card_result_id=" + card_result_id +
                ", result=" + result +
                ", finalResult=" + finalResult +
                ", plan_result=" + plan_result +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", create_time=" + create_time +
                ", totaltime=" + totaltime +
                ", speed=" + speed +
                ", run_pace='" + run_pace + '\'' +
                ", calorie=" + calorie +
                ", distance=" + distance +
                ", bmi=" + bmi +
                ", times=" + times +
                ", content='" + content + '\'' +
                ", default_image_url='" + default_image_url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", push_time=" + push_time +
                ", publish_time=" + publish_time +
                ", update_time=" + update_time +
                ", is_open=" + is_open +
                ", is_del=" + is_del +
                ", is_fb=" + is_fb +
                ", is_publish=" + is_publish +
                ", is_recommend=" + is_recommend +
                ", thumbupsCount=" + thumbupsCount +
                ", commentCount=" + commentCount +
                ", is_thumbup=" + is_thumbup +
                ", is_yellow='" + is_yellow + '\'' +
                ", is_default_yellow='" + is_default_yellow + '\'' +
                ", publishTimeStr='" + publishTimeStr + '\'' +
                ", followStatus=" + followStatus +
                ", runType=" + runType +
                ", dynamic_update_time=" + dynamic_update_time +
                ", isApprove=" + isApprove +
                ", challengeIds='" + challengeIds + '\'' +
                ", isCheat=" + isCheat +
                ", challengeBasicList=" + challengeBasicList +
                '}';
    }
}
