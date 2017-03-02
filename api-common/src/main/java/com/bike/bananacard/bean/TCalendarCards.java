package com.bike.bananacard.bean;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_calendar_cards")
public class TCalendarCards extends UserCard implements Serializable {

    @pbdb_alias("sport_id")
    private Integer sportId;//remark:运动项目ID;length:10

    @pbdb_alias("create_time")
    private Date createTime;//remark:创建时间;length:0; not null,default:null
    @pbdb_ignore
    @pbdb_alias("update_time")
    private Date updateTime;//remark:修改时间;length:0; not null,default:CURRENT_TIMESTAMP

    @pbdb_alias("course_id")
    private Integer courseId;

    @pbdb_alias("isExtend")
    private Integer isExtend;

    @pbdb_alias("extendImage")
    private String extendImage;

    @pbdb_alias("calorie")
    private Double calorie;





    public TCalendarCards() {
    }

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


    public Integer getIsExtend() {
        return isExtend;
    }

    public void setIsExtend(Integer isExtend) {
        this.isExtend = isExtend;
    }

    public String getExtendImage() {
        return extendImage;
    }

    public void setExtendImage(String extendImage) {
        this.extendImage = extendImage;
    }


    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }

    @Override
    public String toString() {
        return "TCalendarCards{" +
                "courseId=" + courseId +
                ", sportId=" + sportId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}