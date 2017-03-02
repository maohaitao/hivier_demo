package com.bike.sns.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("basns_account_list")
public class BasnsAccountList implements Serializable {
    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:推荐用户;length:200; not null,default:null
    @pbdb_alias("list_value")
    @Expose
    private Integer listValue;//remark:值;length:10
    @pbdb_ignore
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:创建时间;length:19; not null,default:CURRENT_TIMESTAMP
    @pbdb_alias("l_type")
    @Expose
    private Integer lType;//remark:榜单类型 1 连续打卡 ;length:10; not null,default:1
    @pbdb_alias("nick_name")
    @Expose
    private String nickName;//remark:昵称;length:245
    @pbdb_alias("user_face")
    @Expose
    private String userFace;//remark:;length:255
    @pbdb_alias("phone_number")
    @Expose
    private String phoneNumber;//remark:;length:45
    @Expose
    private String email;//remark:;length:45
    @Expose
    private Integer sex;//remark:;length:10
    @Expose
    private Double height;//remark:;length:12
    @Expose
    private Double weight;//remark:;length:15
    @Expose
    private String birthday;//remark:;length:45
    @Expose
    private String province;//remark:;length:45
    @Expose
    private String city;//remark:;length:45
    @pbdb_alias("device_no")
    @Expose
    private String deviceNo;//remark:;length:45
    @pbdb_alias("device_type")
    @Expose
    private Integer deviceType;//remark:;length:10
    @pbdb_alias("energy_value")
    @Expose
    private Integer energyValue;//remark:;length:10
    @pbdb_alias("city_id")
    @Expose
    private String cityId;//remark:;length:45
    @pbdb_alias("next_city_id")
    @Expose
    private String nextCityId;//remark:;length:45
    @pbdb_alias("v_distance")
    @Expose
    private Integer vDistance;//remark:;length:10
    @pbdb_alias("card_num")
    @Expose
    private Integer cardNum;//remark:打卡数量;length:10

    @Expose
    private Integer ranking;// 排名

    @pbdb_ignore
    @Expose
    private String cityName;//remark:当前城市;length:255

    @pbdb_ignore
    @Expose
    private String nextCityName;//remark:下一个城市;length:255


    public BasnsAccountList() {
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getNextCityName() {
        return nextCityName;
    }

    public void setNextCityName(String nextCityName) {
        this.nextCityName = nextCityName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getCardNum() {
        return cardNum;
    }

    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(Integer energyValue) {
        this.energyValue = energyValue;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getListValue() {
        return listValue;
    }

    public void setListValue(Integer listValue) {
        this.listValue = listValue;
    }

    public Integer getlType() {
        return lType;
    }

    public void setlType(Integer lType) {
        this.lType = lType;
    }

    public String getNextCityId() {
        return nextCityId;
    }

    public void setNextCityId(String nextCityId) {
        this.nextCityId = nextCityId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public Integer getvDistance() {
        return vDistance;
    }

    public void setvDistance(Integer vDistance) {
        this.vDistance = vDistance;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "BasnsAccountList{" +
                "accountId='" + accountId + '\'' +
                ", listValue=" + listValue +
                ", createTime=" + createTime +
                ", lType=" + lType +
                ", nickName='" + nickName + '\'' +
                ", userFace='" + userFace + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", height=" + height +
                ", weight=" + weight +
                ", birthday='" + birthday + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", deviceNo='" + deviceNo + '\'' +
                ", deviceType=" + deviceType +
                ", energyValue=" + energyValue +
                ", cityId='" + cityId + '\'' +
                ", nextCityId='" + nextCityId + '\'' +
                ", vDistance=" + vDistance +
                ", cardNum=" + cardNum +
                ", ranking=" + ranking +
                ", cityName='" + cityName + '\'' +
                ", nextCityName='" + nextCityName + '\'' +
                '}';
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}