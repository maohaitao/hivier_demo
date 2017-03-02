package com.bike.bananacard.bean;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;

/*  */
@pbdb_alias("t_course")
public class TCourse implements Serializable{
    @pbdb_ignore
    private Integer id;//remark:ID;length:10; not null,default:null
    private String name;//remark:课程名称;length:64; not null,default:null
    private Double version;//remark:版本;length:22; not null,default:null
    private String images;//remark:封面图，多张图片以;隔开;length:1000; not null,default:null
    @pbdb_alias("short_desc")
    private String shortDesc;//remark:短介绍;length:128
    @pbdb_alias("long_desc")
    private String longDesc;//remark:课程详细介绍;length:255
    @pbdb_alias("is_fixed_date")
    private Integer isFixedDate;//remark:是否固定日期开始 0:是 1:否;length:10; not null,default:1
    private Integer week;//remark:课程长度，单位 周;length:10; not null,default:null
    private Integer difficulty;//remark:课程难度 1 容易 2 较难 3 难;length:10; not null,default:1
    private Integer lesson;//remark:对应课程节数;length:10; not null,default:null
    @pbdb_alias("apply_gender")
    private Integer applyGender;//remark:课程适合性别 1 男 2 女 3 通用;length:10; not null,default:1
    private Integer type;//remark:课程类型 1 跑步 2 体能 3 竞速;length:10; not null,default:1
    private String resource;//remark:;length:128; not null,default:null
    @pbdb_alias("config_flie")
    private String configFlie;//remark:配置文件路径;length:128; not null,default:null
    @pbdb_alias("min_frequency")
    private Integer minFrequency;//remark:训练频率/每周;length:10; not null,default:null
    @pbdb_alias("max_frequency")
    private Integer maxFrequency;//remark:;length:10; not null,default:null
    private Integer status;//remark:课程状态 1 新建 2 上线 3 下线;length:10; not null,default:1

    public TCourse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public Integer getIsFixedDate() {
        return isFixedDate;
    }

    public void setIsFixedDate(Integer isFixedDate) {
        this.isFixedDate = isFixedDate;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getLesson() {
        return lesson;
    }

    public void setLesson(Integer lesson) {
        this.lesson = lesson;
    }

    public Integer getApplyGender() {
        return applyGender;
    }

    public void setApplyGender(Integer applyGender) {
        this.applyGender = applyGender;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getConfigFlie() {
        return configFlie;
    }

    public void setConfigFlie(String configFlie) {
        this.configFlie = configFlie;
    }

    public Integer getMinFrequency() {
        return minFrequency;
    }

    public void setMinFrequency(Integer minFrequency) {
        this.minFrequency = minFrequency;
    }

    public Integer getMaxFrequency() {
        return maxFrequency;
    }

    public void setMaxFrequency(Integer maxFrequency) {
        this.maxFrequency = maxFrequency;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}