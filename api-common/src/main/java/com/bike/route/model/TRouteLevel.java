package com.bike.route.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_route_level")
public class TRouteLevel implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("level_name")
    @Expose
    private String levelName;//remark:关卡名称;length:255
    @pbdb_alias("level_modulus")
    @Expose
    private Integer levelModulus;//remark:虚拟转化系数;length:10
    @pbdb_alias("level_energy_max")
    @Expose
    private Integer levelEnergyMax;//`level_energy_max` Int DEFAULT 10 COMMENT '能量上限',

    @pbdb_alias("map_url")
    @Expose
    private String mapUrl;//`map_url` varchar(128) DEFAULT NULL COMMENT '资源地址',
    @pbdb_alias("download_map_bg")
    @Expose
    private String downloadMapBg;//`download_map_bg` varchar(128) DEFAULT NULL COMMENT '下载预览背景图',
    @pbdb_alias("download_map_img")
    @Expose
    private String downloadMapImg;//`download_map_img` varchar(128) DEFAULT NULL COMMENT '下载进度图',
    @Expose
    private Integer memory;// `memory` int(11) DEFAULT NULL COMMENT '资源包大小，KB为单位',
    @pbdb_alias("c_status")
    @Expose
    private Integer cStatus;//`c_status` int(11) DEFAULT NULL,

    @pbdb_alias("file_md5")
    @Expose
    private String fileMd5;//`file_md5` varchar(32) DEFAULT NULL COMMENT '文件MD5',


    @pbdb_alias("next_country_id")
    @Expose
    private Integer nextCountryId;//`next_country_id` varchar(32) DEFAULT NULL COMMENT '下个国家Id',


    @pbdb_alias("c_time")
    @Expose
    private Date cTime;//remark:;length:19

    public TRouteLevel() {
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevelModulus() {
        return levelModulus;
    }

    public void setLevelModulus(Integer levelModulus) {
        this.levelModulus = levelModulus;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getLevelEnergyMax() {
        return levelEnergyMax;
    }

    public void setLevelEnergyMax(Integer levelEnergyMax) {
        this.levelEnergyMax = levelEnergyMax;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public String getDownloadMapBg() {
        return downloadMapBg;
    }

    public void setDownloadMapBg(String downloadMapBg) {
        this.downloadMapBg = downloadMapBg;
    }

    public String getDownloadMapImg() {
        return downloadMapImg;
    }

    public void setDownloadMapImg(String downloadMapImg) {
        this.downloadMapImg = downloadMapImg;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Integer getNextCountryId() {
        return nextCountryId;
    }

    public void setNextCountryId(Integer nextCountryId) {
        this.nextCountryId = nextCountryId;
    }

    @Override
    public String toString() {
        return "TRouteLevel{" +
                "cStatus=" + cStatus +
                ", id=" + id +
                ", levelName='" + levelName + '\'' +
                ", levelModulus=" + levelModulus +
                ", levelEnergyMax=" + levelEnergyMax +
                ", mapUrl='" + mapUrl + '\'' +
                ", downloadMapBg='" + downloadMapBg + '\'' +
                ", downloadMapImg='" + downloadMapImg + '\'' +
                ", memory=" + memory +
                ", fileMd5='" + fileMd5 + '\'' +
                ", nextCountryId='" + nextCountryId + '\'' +
                ", cTime=" + cTime +
                '}';
    }
}