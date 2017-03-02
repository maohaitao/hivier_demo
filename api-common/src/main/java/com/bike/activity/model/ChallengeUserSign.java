package com.bike.activity.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by allen duan on 17/1/6.
 *
 * 挑战报名
 */
@pbdb_alias("t_challenge_user_sign")
public class ChallengeUserSign implements Serializable{
    @Expose
    @pbdb_alias("id")
    private Integer id;

    @Expose
    @pbdb_alias("account_id")
    private String accountId;//'用户id'

    @Expose
    @pbdb_alias("challenge_id")
    private Integer challengeId;//'挑战id'

    private String challengeName;//'挑战名称'

    private String themeIcon;// '预览图'

    private String bannerImage;//'banner图'

    private String detailBannerImage;//'详情banner图'

    private String bannerRedurl;//'详情跳转地址'


    private String explain;//'活动说明'

    @Expose
    @pbdb_alias("status")
    private Integer status;//'0未报名 1 已报名 2 取消报名 3 成功 4 失败'

    @Expose
    @pbdb_alias("join_time")
    private Date joinTime;//'参与时间'

    @Expose
    @pbdb_alias("success_time")
    private Date successTime;//'达成时间'

    @Expose
    @pbdb_alias("out_time")
    private Date outTime;//'取消时间'


    @Expose
    @pbdb_alias("start_time")
    private Date startTime;//'统计开始时间'

    @Expose
    @pbdb_alias("end_time")
    private Date endTime;//'统计截至时间'


    @Expose
    @pbdb_ignore
    private Integer isOverTime;//0否 1是

    @Expose
    @pbdb_ignore
    private Integer dynamicCount;//关联的动态总数


    @Expose
    @pbdb_ignore
    private Integer joinCount;//参与挑战人数

    @Expose
    @pbdb_ignore
    private Integer finishCount;//完成挑战人数

    @Expose
    @pbdb_ignore
    private String cardIds;

    private List<String> cardIdList;
    @Expose
    @pbdb_ignore
    private String currentDate;

    @Expose
    @pbdb_ignore
    private String nickName;//昵称
    @Expose
    @pbdb_ignore
    private String userFace;//头像

    private String challengeShareUrl;//挑战详情分享

    private String challengeResultUrl;//挑战结果分享

    private String challengeCardImage;//挑战卡图片

    private String shareTitle;//'分享标题'

    private String shareContent;//'分享标题'

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getIsOverTime() {
        return isOverTime;
    }

    public void setIsOverTime(Integer isOverTime) {
        this.isOverTime = isOverTime;
    }

    public Integer getDynamicCount() {
        return dynamicCount;
    }

    public void setDynamicCount(Integer dynamicCount) {
        this.dynamicCount = dynamicCount;
    }

    public Integer getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(Integer finishCount) {
        this.finishCount = finishCount;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public String getThemeIcon() {
        return themeIcon;
    }

    public void setThemeIcon(String themeIcon) {
        this.themeIcon = themeIcon;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Integer getJoinCount() {
        return joinCount;
    }

    public void setJoinCount(Integer joinCount) {
        this.joinCount = joinCount;
    }


    public String getCardIds() {
        return cardIds;
    }

    public void setCardIds(String cardIds) {
        this.cardIds = cardIds;
    }

    public List<String> getCardIdList() {
        return cardIdList;
    }

    public void setCardIdList(List<String> cardIdList) {
        this.cardIdList = cardIdList;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
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

    public String getChallengeShareUrl() {
        return challengeShareUrl;
    }

    public void setChallengeShareUrl(String challengeShareUrl) {
        this.challengeShareUrl = challengeShareUrl;
    }

    public String getChallengeResultUrl() {
        return challengeResultUrl;
    }

    public void setChallengeResultUrl(String challengeResultUrl) {
        this.challengeResultUrl = challengeResultUrl;
    }

    public String getChallengeCardImage() {
        return challengeCardImage;
    }

    public void setChallengeCardImage(String challengeCardImage) {
        this.challengeCardImage = challengeCardImage;
    }

    public String getBannerRedurl() {
        return bannerRedurl;
    }

    public void setBannerRedurl(String bannerRedurl) {
        this.bannerRedurl = bannerRedurl;
    }


    public String getDetailBannerImage() {
        return detailBannerImage;
    }

    public void setDetailBannerImage(String detailBannerImage) {
        this.detailBannerImage = detailBannerImage;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    @Override
    public String toString() {
        return "ChallengeUserSign{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", challengeId=" + challengeId +
                ", challengeName='" + challengeName + '\'' +
                ", themeIcon='" + themeIcon + '\'' +
                ", bannerImage='" + bannerImage + '\'' +
                ", detailBannerImage='" + detailBannerImage + '\'' +
                ", bannerRedurl='" + bannerRedurl + '\'' +
                ", explain='" + explain + '\'' +
                ", status=" + status +
                ", joinTime=" + joinTime +
                ", successTime=" + successTime +
                ", outTime=" + outTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", isOverTime=" + isOverTime +
                ", dynamicCount=" + dynamicCount +
                ", joinCount=" + joinCount +
                ", finishCount=" + finishCount +
                ", cardIds='" + cardIds + '\'' +
                ", cardIdList=" + cardIdList +
                ", currentDate='" + currentDate + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userFace='" + userFace + '\'' +
                ", challengeShareUrl='" + challengeShareUrl + '\'' +
                ", challengeResultUrl='" + challengeResultUrl + '\'' +
                ", challengeCardImage='" + challengeCardImage + '\'' +
                '}';
    }
}
