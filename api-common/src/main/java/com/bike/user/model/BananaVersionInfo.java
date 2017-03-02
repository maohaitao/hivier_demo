package com.bike.user.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("banana_version_info")
public class BananaVersionInfo implements Serializable {

//    CREATE TABLE `banana_version_info` (
//            `id` int(11) NOT NULL AUTO_INCREMENT,
//    `version_id` varchar(255) NOT NULL COMMENT '版本Id',
//            `version_content` text NOT NULL COMMENT '版本修改内容',
//            `device_type` int(1) NOT NULL DEFAULT '2' COMMENT '用户类型： 1 and 2 ios',
//            `c_time` datetime DEFAULT NULL,
//    PRIMARY KEY (`id`)
//    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    @Expose
    private Integer id;
    @pbdb_alias("version_id")
    @Expose
    private Integer versionId;
    @pbdb_alias("version_name")
    @Expose
    private String versionName;
    @pbdb_alias("version_content")
    @Expose
    private String versionContent;
    @pbdb_alias("device_type")
    @Expose
    private Integer deviceType;
    @pbdb_alias("v_status")
    @Expose
    private Integer vStatus;
    @pbdb_alias("c_time")
    @Expose
    private Date cTime;//remark:注册时间;length:19; not null,default:null

    @pbdb_alias("upgrade_status")
    @Expose
    private Integer upgradeStatus;

    public BananaVersionInfo() {

    }

    @Override
    public String toString() {
        return "BananaVersionInfo{" +
                "cTime=" + cTime +
                ", id=" + id +
                ", versionId=" + versionId +
                ", versionName='" + versionName + '\'' +
                ", versionContent='" + versionContent + '\'' +
                ", deviceType=" + deviceType +
                ", vStatus=" + vStatus +
                ", upgradeStatus=" + upgradeStatus +
                '}';
    }

    public Integer getvStatus() {
        return vStatus;
    }

    public void setvStatus(Integer vStatus) {
        this.vStatus = vStatus;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersionContent() {
        return versionContent;
    }

    public void setVersionContent(String versionContent) {
        this.versionContent = versionContent;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Integer getUpgradeStatus(){
        return  upgradeStatus;
    }

    public void setUpgradeStatus(Integer upgradeStatus){
        this.upgradeStatus = upgradeStatus;
    }
}