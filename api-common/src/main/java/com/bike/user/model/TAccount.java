package com.bike.user.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_account")
public class TAccount implements Serializable{
    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:账号ID;length:64; not null,default:null
    @pbdb_alias("account_no")
    @Expose
    private String accountNo;//remark:;length:64 @pbdb_alias("nick_name")
    @pbdb_alias("nick_name")
    @Expose
    private String nickName;//remark:账号昵称;length:50; not null,default:null
    @pbdb_alias("user_face")
    @Expose
    private String userFace;//remark:头像;length:100
    @pbdb_alias("phone_number")
    @Expose
    private String phoneNumber;//remark:手机号码;length:20
    @Expose
    private String email;//remark:邮箱地址;length:100
    @pbdb_alias("pass_word")
//    @Expose
    private String passWord;//remark:密码;length:45
    @pbdb_alias("version_name")
//    @Expose
    private String versionName;
    @Expose
    private Integer sex;//remark:1:男 2:女;length:10
    @Expose
    private Integer height;//remark:身高/CM;length:10
    @Expose
    private Double weight;//remark:体重;length:10
    @pbdb_alias("is_operating")
    @Expose
    private Integer isOperating;//remark:是否为运营账号 0:是 1:否;length:10
    @Expose
    private String birthday;//remark:例如：2015-12-30;length:20

    @Expose
    private String province;//remark:所在省份;length:45
    @Expose
    private String city;//remark:所在城市;length:45
    @pbdb_alias("device_no")
//    @Expose
    private String deviceNo;//remark:手机设备ID;length:100; not null,default:null
    @pbdb_alias("device_type")
    @Expose
    private Integer deviceType;//remark:1:安卓用户 2:ios用户;length:10; not null,default:1
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:注册时间;length:19; not null,default:null
    @pbdb_ignore
    @pbdb_alias("update_time")
    @Expose
    private Date updateTime;//remark:修改时间;length:19; not null,default:CURRENT_TIMESTAMP

    @pbdb_ignore
    @Expose
    private int iscompleteinfo = 1;//     int            资料是否完整    0 不完整  1 完整

    @Expose
    @pbdb_ignore
    private boolean newUser = false;//     int            是否新用户    false 否  true 是

    @Expose
    @pbdb_ignore
    private String openId;//     int            是否新用户    false 否  true 是

    @Expose
    @pbdb_alias("ip")
    private String ip;//     int            是否新用户    false 否  true 是

    @Expose
    @pbdb_alias("user_profile")
    private String userProfile;//     int            是否新用户    false 否  true 是

    public TAccount() {

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getIsOperating() {
        return isOperating;
    }

    public void setIsOperating(Integer isOperating) {
        this.isOperating = isOperating;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getIscompleteinfo() {
        return iscompleteinfo;
    }

    public void setIscompleteinfo(int iscompleteinfo) {
        this.iscompleteinfo = iscompleteinfo;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public boolean isNewUser() {
        return newUser;
    }

    public void setNewUser(boolean newUser) {
        this.newUser = newUser;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "TAccount{" +
                "accountId='" + accountId + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userFace='" + userFace + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", versionName='" + versionName + '\'' +
                ", sex=" + sex +
                ", height=" + height +
                ", weight=" + weight +
                ", isOperating=" + isOperating +
                ", birthday='" + birthday + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", deviceNo='" + deviceNo + '\'' +
                ", deviceType=" + deviceType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", iscompleteinfo=" + iscompleteinfo +
                ", newUser=" + newUser +
                ", openId='" + openId + '\'' +
                ", ip='" + ip + '\'' +
                ", user_profile='" + userProfile + '\'' +
                '}';
    }
}