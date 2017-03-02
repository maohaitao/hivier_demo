package com.bike.activity.model;

import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by a700 on 16/12/23.
 */
@pbdb_alias("activity_info")
public class ActivityMobileDTO implements Serializable {

    private static final long serialVersionUID = -6955801852357222166L;

    private Long activityId;// 活动ID

    private String activityName;// 活动名称

    private String coverPic;// 活动图片

    private String content;// 活动详情

    private Date startTime;// 开始时间

    private Date endTime;// 结束时间

    private String createUser;// 活动创建者

    private Date createTime;// 活动创建时间

    private Integer type;// 活动类别 1普通活动 2：竞技活动

    private Integer sportsType;// 竞技活动类别 1里程

    private Integer maxNum;// 最大报名人数

    private Integer isPrice;// 是否收费

    private Integer price;// 活动收费价格

    private Integer isApply;// 是否需要报名

    private Date applyEndTime;// 截止报名时间

    private String payLink;// 支付链接

//	private List<UserActivity> userList;// 活动排名信息

    // extend
    private String typeName;// 活动类型名

    public ActivityMobileDTO() {
    }

//	public List<UserActivity> getUserList() {
//		return userList;
//	}
//
//	public void setUserList(List<UserActivity> userList) {
//		this.userList = userList;
//	}

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSportsType() {
        return sportsType;
    }

    public void setSportsType(Integer sportsType) {
        this.sportsType = sportsType;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Integer getIsPrice() {
        return isPrice;
    }

    public void setIsPrice(Integer isPrice) {
        this.isPrice = isPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIsApply() {
        return isApply;
    }

    public void setIsApply(Integer isApply) {
        this.isApply = isApply;
    }

    public Date getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public String getPayLink() {
        return payLink;
    }

    public void setPayLink(String payLink) {
        this.payLink = payLink;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}

