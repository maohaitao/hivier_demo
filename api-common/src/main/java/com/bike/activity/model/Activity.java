package com.bike.activity.model;

import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by a700 on 16/12/22.
 */

@pbdb_alias("activity_info")
public class Activity implements Serializable {

    private static final long serialVersionUID = -3275179415088939720L;

    private Long activityId;// 活动ID

    private String activityName;// 活动名称

    private String coverPic;// 活动图片

    private String summary;// 活动简介

    private String content;// 活动详情

    private String address;// 活动地址

    private Date startTime;// 开始时间

    private Date endTime;// 结束时间

    private Integer weight;// 排序

    private String createUser;// 活动创建者

    private Date createTime;// 活动创建时间

    private Integer pv;// 访问量

    private String pics;// 多张图片，英文逗号隔开

    private Integer display;// 是否展示0：隐藏；1：显示；2：删除。

    private Integer type;// 活动类别 1普通活动 2：竞技活动

    private Integer sportsType;// 竞技活动类别 1里程

    private Integer recommend;// 是否首页推荐，0否；1是

    private Integer maxNum;// 最大报名人数

    private Integer isPrice;// 是否收费 1 收费 0 不收费

    private Float price;// 活动收费价格1收费 0 不收费

    private Integer isApply;// 是否需要报名

    private Date applyEndTime;// 截止报名时间

    private String payLink;// 支付链接

    private Date modifyTime;// 修改时间

    private String modifyUser;// 修改者

    private Integer target;// 活动目标里程km

    private Integer formId;// 表单Id

    private String prize;

    private Date applyStartTime;

    private Integer isOtherApply;// 是否是其他报名方式 1是 0 不是

    private String otherApplyLink;// 其他报名链接

    private Integer uv;// 独立访问个数

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public Date getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getPayLink() {
        return payLink;
    }

    public void setPayLink(String payLink) {
        this.payLink = payLink;
    }

    public Date getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public Integer getSportsType() {
        return sportsType;
    }

    public void setSportsType(Integer sportsType) {
        this.sportsType = sportsType;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getIsApply() {
        return isApply;
    }

    public void setIsApply(Integer isApply) {
        this.isApply = isApply;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsOtherApply() {
        return isOtherApply;
    }

    public void setIsOtherApply(Integer isOtherApply) {
        this.isOtherApply = isOtherApply;
    }

    public String getOtherApplyLink() {
        return otherApplyLink;
    }

    public void setOtherApplyLink(String otherApplyLink) {
        this.otherApplyLink = otherApplyLink;
    }

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

}
