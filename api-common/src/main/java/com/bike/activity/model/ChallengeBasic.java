package com.bike.activity.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by allen duan on 17/1/6.
 *
 * 挑战基本信息
 */
@pbdb_alias("t_challenge_basic")
public class ChallengeBasic implements Serializable {
    @Expose
    @pbdb_alias("id")
    private Integer id;

    @Expose
    @pbdb_alias("challenge_name")
    private String challengeName;//'挑战名称'

    @Expose
    @pbdb_alias("status")
    private Integer status;//'挑战状态 0在线 1下线'

    @Expose
    @pbdb_alias("sorted")
    private Integer sorted;//'排序'

    @Expose
    @pbdb_alias("banner_image")
    private String bannerImage;//'banner图'

    @Expose
    @pbdb_alias("detail_banner_image")
    private String detailBannerImage;//'详情banner图'

    @Expose
    @pbdb_alias("banner_redurl")
    private String bannerRedurl;//'banner跳转地址'


    @Expose
    @pbdb_alias("advert_image")
    private String advertImage;//'广告图'

    @Expose
    @pbdb_alias("advert_redurl")
    private String advertRedurl;//'广告图跳转地址'


    @Expose
    @pbdb_alias("advert_start_time")
    private Date advertStartTime;//'广告有效开始时间'

    @Expose
    @pbdb_alias("advert_end_time")
    private Date advertEndTime;//'广告有效结束时间'

    @Expose
    @pbdb_alias("advert_status")
    private Integer advertStatus;//'广告状态 0 无效 1有效'

    @Expose
    @pbdb_alias("explain")
    private String explain;//'活动说明'

    @Expose
    @pbdb_alias("create_time")
    private Date createTime;//'活动创建时间'

    @Expose
    @pbdb_alias("visible_start_time")
    private Date visibleStartTime;//'活动可见开始时间'

    @Expose
    @pbdb_alias("visible_end_time")
    private Date visibleEndTime;//'活动可见结束时间'

    @Expose
    @pbdb_alias("start_time")
    private Date startTime;//'活动统计开始时间'

    @Expose
    @pbdb_alias("end_time")
    private Date endTime;//'活动统计结束时间'

    @Expose
    @pbdb_ignore
    private Integer finishCount;//完成挑战人数



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
    @pbdb_alias("share_title")
    private String shareTitle;//'分享标题'

    @Expose
    @pbdb_alias("share_content")
    private String shareContent;//'分享标题'

    @Expose
    @pbdb_alias("challenge_card_image")
    private String challengeCardImage;//挑战卡图片

    @Expose
    @pbdb_alias("forward_url")
    private String forwardUrl;//挑战卡图片


    private Integer challengeId;//'挑战id'


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSorted() {
        return sorted;
    }

    public void setSorted(Integer sorted) {
        this.sorted = sorted;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getBannerRedurl() {
        return bannerRedurl;
    }

    public void setBannerRedurl(String bannerRedurl) {
        this.bannerRedurl = bannerRedurl;
    }

    public String getAdvertImage() {
        return advertImage;
    }

    public void setAdvertImage(String advertImage) {
        this.advertImage = advertImage;
    }

    public String getAdvertRedurl() {
        return advertRedurl;
    }

    public void setAdvertRedurl(String advertRedurl) {
        this.advertRedurl = advertRedurl;
    }

    public Date getAdvertStartTime() {
        return advertStartTime;
    }

    public void setAdvertStartTime(Date advertStartTime) {
        this.advertStartTime = advertStartTime;
    }

    public Date getAdvertEndTime() {
        return advertEndTime;
    }

    public void setAdvertEndTime(Date advertEndTime) {
        this.advertEndTime = advertEndTime;
    }

    public Integer getAdvertStatus() {
        return advertStatus;
    }

    public void setAdvertStatus(Integer advertStatus) {
        this.advertStatus = advertStatus;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getVisibleStartTime() {
        return visibleStartTime;
    }

    public void setVisibleStartTime(Date visibleStartTime) {
        this.visibleStartTime = visibleStartTime;
    }

    public Date getVisibleEndTime() {
        return visibleEndTime;
    }

    public void setVisibleEndTime(Date visibleEndTime) {
        this.visibleEndTime = visibleEndTime;
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


    public Integer getIsOverTime() {
        return isOverTime;
    }

    public void setIsOverTime(Integer isOverTime) {
        this.isOverTime = isOverTime;
    }

    public Integer getJoinCount() {
        return joinCount;
    }

    public void setJoinCount(Integer joinCount) {
        this.joinCount = joinCount;
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

    public String getChallengeCardImage() {
        return challengeCardImage;
    }

    public void setChallengeCardImage(String challengeCardImage) {
        this.challengeCardImage = challengeCardImage;
    }

    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    public Integer getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    @Override
    public String toString() {
        return "ChallengeBasic{" +
                "id=" + id +
                ", challengeName='" + challengeName + '\'' +
                ", status=" + status +
                ", sorted=" + sorted +
                ", bannerImage='" + bannerImage + '\'' +
                ", detailBannerImage='" + detailBannerImage + '\'' +
                ", bannerRedurl='" + bannerRedurl + '\'' +
                ", advertImage='" + advertImage + '\'' +
                ", advertRedurl='" + advertRedurl + '\'' +
                ", advertStartTime=" + advertStartTime +
                ", advertEndTime=" + advertEndTime +
                ", advertStatus=" + advertStatus +
                ", explain='" + explain + '\'' +
                ", createTime=" + createTime +
                ", visibleStartTime=" + visibleStartTime +
                ", visibleEndTime=" + visibleEndTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", finishCount=" + finishCount +
                ", isOverTime=" + isOverTime +
                ", dynamicCount=" + dynamicCount +
                ", joinCount=" + joinCount +
                ", shareTitle='" + shareTitle + '\'' +
                ", shareContent='" + shareContent + '\'' +
                ", challengeCardImage='" + challengeCardImage + '\'' +
                ", forwardUrl='" + forwardUrl + '\'' +
                '}';
    }
}
