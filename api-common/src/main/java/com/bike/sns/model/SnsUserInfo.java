package com.bike.sns.model;

import com.bike.user.model.TAccount;
import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

/**
 * Created by a700 on 16/8/4.
 */
@pbdb_alias("t_account")
public class SnsUserInfo extends TAccount {

    private Integer energyValue;//remark:能量值;length:10
    @pbdb_alias("city_id")
    @Expose
    private Integer cityId;//remark:当前城市;length:255
    @Expose
    @pbdb_ignore
    private String cityName;//remark:当前城市;length:255

    @pbdb_alias("next_city_id")
    @Expose
    private Integer nextCityId;//remark:下一个城市;length:255
    @Expose
    @pbdb_ignore
    private String nextCityName;//remark:下一个城市;length:255

    @pbdb_alias("v_distance")
    @Expose
    private Integer vDistance;//remark:虚拟距离;length:10
    @Expose
    private Integer followed = 0;// 关注数
    @Expose
    private Integer beFollow = 0;// 粉丝数
    @Expose
    private Integer beLike = 0;// 点赞数
    @Expose
    private Integer mapId = 0;

    private Integer cardNum = 1;// 用户打卡数量
    private Integer isFollow = 0;// 是否关注 1未关注 2关注 3被关注 4互相关注
    private Integer isLike = 0;// 是否当天已经点赞 0未点赞 1点赞
    private Long likeTime;// 关注时间
    private Long followTime;// 关注时间

    private String isTogether;

    private String mapImage;

    private Double runDistance;

    private Integer walkCount;


    private String cityBgColor;

    private Integer continueCardCount;



    public String getIsTogether(){
        return  isTogether;
    }

    public void setIsTogether(String isTogether){
        this.isTogether = isTogether;
    }

    public Integer getCardNum() {
        return cardNum;
    }

    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(Integer energyValue) {
        this.energyValue = energyValue;
    }

    public Integer getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(Integer isFollow) {
        this.isFollow = isFollow;
    }

    public Integer getNextCityId() {
        return nextCityId;
    }

    public void setNextCityId(Integer nextCityId) {
        this.nextCityId = nextCityId;
    }

    public String getNextCityName() {
        return nextCityName;
    }

    public void setNextCityName(String nextCityName) {
        this.nextCityName = nextCityName;
    }

    public Integer getvDistance() {
        return vDistance;
    }

    public void setvDistance(Integer vDistance) {
        this.vDistance = vDistance;
    }

    public Integer getBeFollow() {
        return beFollow;
    }

    public void setBeFollow(Integer beFollow) {
        this.beFollow = beFollow;
    }

    public Integer getBeLike() {
        return beLike;
    }

    public void setBeLike(Integer beLike) {
        this.beLike = beLike;
    }

    public Integer getFollowed() {
        return followed;
    }

    public void setFollowed(Integer followed) {
        this.followed = followed;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public Long getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Long likeTime) {
        this.likeTime = likeTime;
    }

    public Long getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Long followTime) {
        this.followTime = followTime;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public String getMapImage() {
        return mapImage;
    }

    public void setMapImage(String mapImage) {
        this.mapImage = mapImage;
    }

    public Double getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(Double runDistance) {
        this.runDistance = runDistance;
    }

    public Integer getWalkCount() {
        return walkCount;
    }

    public void setWalkCount(Integer walkCount) {
        this.walkCount = walkCount;
    }

    public String getCityBgColor() {
        return cityBgColor;
    }

    public void setCityBgColor(String cityBgColor) {
        this.cityBgColor = cityBgColor;
    }

    public Integer getContinueCardCount() {
        return continueCardCount;
    }

    public void setContinueCardCount(Integer continueCardCount) {
        this.continueCardCount = continueCardCount;
    }

    @Override
    public String toString() {
        return "SnsUserInfo{" +
                "energyValue=" + energyValue +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", nextCityId=" + nextCityId +
                ", nextCityName='" + nextCityName + '\'' +
                ", vDistance=" + vDistance +
                ", followed=" + followed +
                ", beFollow=" + beFollow +
                ", beLike=" + beLike +
                ", mapId=" + mapId +
                ", cardNum=" + cardNum +
                ", isFollow=" + isFollow +
                ", isLike=" + isLike +
                ", likeTime=" + likeTime +
                ", followTime=" + followTime +
                ", isTogether='" + isTogether + '\'' +
                ", mapImage='" + mapImage + '\'' +
                ", runDistance=" + runDistance +
                ", walkCount=" + walkCount +
                ", cityBgColor='" + cityBgColor + '\'' +
                '}';
    }
}
