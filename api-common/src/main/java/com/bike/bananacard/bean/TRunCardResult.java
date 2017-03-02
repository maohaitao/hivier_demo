package com.bike.bananacard.bean;

import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/14
 * time: 下午9:13
 * description: 跑步卡片结果
 */
@pbdb_alias("t_run_card_result")
public class TRunCardResult extends CardResult implements Serializable {

    @pbdb_alias("total_time")
    private Integer totalTime;//remark:总时间;length:50; not null,default:null
    @pbdb_alias("total_distance")
    private Double totalDistance;//remark:跑步总距离/公里;length:22; not null,default:null
    private Double speed;//remark:平均时速;length:22; not null,default:null
    @pbdb_alias("fast_speed")
    private Double fastSpeed;//remark:最快时速;length:22; not null,default:null
    @pbdb_alias("step_number")
    private Integer stepNumber;//remark:步数;length:10; not null,default:null
    @pbdb_alias("altitude_max")
    private Double altitudeMax;//remark:最高海拔高度/米;length:10
    @pbdb_alias("altitude_min")
    private Double altitudeMin;//remark:最低海拔高度/米;length:10
    @pbdb_alias("run_style")
    private Integer runStyle;//remark:跑步模式 1:自由跑 2:时间跑 3:距离跑 4:卡里路跑;length:10; not null,default:null
    @pbdb_alias("run_target_value")
    private String runTargetValue;//remark:跑步目标值 例如:时间跑，跑30分钟值为30;length:50
    @pbdb_alias("track_data")
    private String trackData;//remark:轨迹行程数据;length:16777215; not null,default:null

    @pbdb_alias("create_time")
    private Date createTime;//remark:创建时间;length:0; not null,default:null
    @pbdb_alias("course_week")
    private Integer courseWeek;
    @pbdb_alias("course_lesson")
    private Integer courseLesson;
    @pbdb_alias("course_day")
    private Integer courseDay;
    @pbdb_alias("run_pace")
    private String runPace;
    @pbdb_alias("course_lesson_name")
    private String courseLessonName;
    @pbdb_alias("city_name")
    private String cityName;//remark:城市名称;length:128;
    @pbdb_alias("run_type")
    private Integer runType;//remark:跑步类型: 0：室外跑 1：室内跑;length：11;default：0

    @pbdb_alias("runCardImage")
    private String runCardImage;//跑步打卡圖片存储路径

    @pbdb_alias("isCheat")
    private Integer isCheat;//是否作弊：1 作弊 0 未作弊

    @pbdb_alias("is_del")
    private Integer is_del;//逻辑删除：1 删除 0 未删除

    @pbdb_alias("client_time")
    private Date client_time;//客戶端日期


    public TRunCardResult() {
    }

    public Integer getIsCheat() {
        return isCheat;
    }

    public void setIsCheat(Integer isCheat) {
        this.isCheat = isCheat;
    }

    public Integer getIs_del() {
        return is_del;
    }

    public void setIs_del(Integer is_del) {
        this.is_del = is_del;
    }

    public String getRunCardImage(){
        return runCardImage;
    }

    public void setRunCardImage(String runCardImage){
        this.runCardImage = runCardImage;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public Integer getRunStyle() {
        return runStyle;
    }

    public void setRunStyle(Integer runStyle) {
        this.runStyle = runStyle;
    }

    public String getRunTargetValue() {
        return runTargetValue;
    }

    public void setRunTargetValue(String runTargetValue) {
        this.runTargetValue = runTargetValue;
    }

    public String getTrackData() {
        return trackData;
    }

    public void setTrackData(String trackData) {
        this.trackData = trackData;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getFastSpeed() {
        return fastSpeed;
    }

    public void setFastSpeed(Double fastSpeed) {
        this.fastSpeed = fastSpeed;
    }

    public Double getAltitudeMax() {
        return altitudeMax;
    }

    public void setAltitudeMax(Double altitudeMax) {
        this.altitudeMax = altitudeMax;
    }

    public Double getAltitudeMin() {
        return altitudeMin;
    }

    public void setAltitudeMin(Double altitudeMin) {
        this.altitudeMin = altitudeMin;
    }

    public Integer getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(Integer courseWeek) {
        this.courseWeek = courseWeek;
    }

    public Integer getCourseLesson() {
        return courseLesson;
    }

    public void setCourseLesson(Integer courseLesson) {
        this.courseLesson = courseLesson;
    }

    public Integer getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(Integer courseDay) {
        this.courseDay = courseDay;
    }

    public String getCourseLessonName() {
        return courseLessonName;
    }

    public void setCourseLessonName(String courseLessonName) {
        this.courseLessonName = courseLessonName;
    }

    public String getRunPace() {
        return runPace;
    }

    public void setRunPace(String runPace) {
        this.runPace = runPace;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getRunType() {
        return runType;
    }

    public void setRunType(Integer runType) {
        this.runType = runType;
    }

    public Date getClient_time() {
        return client_time;
    }

    public void setClient_time(Date client_time) {
        this.client_time = client_time;
    }
}