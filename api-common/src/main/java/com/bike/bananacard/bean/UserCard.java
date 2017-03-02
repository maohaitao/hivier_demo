package com.bike.bananacard.bean;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/14
 * time: 下午2:05
 * description: 用户日历卡片
 */
public class UserCard implements Serializable {
    @pbdb_ignore
    private Integer id;
    @pbdb_alias("card_icon")
    private String cardIcon;
    @pbdb_alias("card_name")
    private String cardName;
    @pbdb_alias("card_style")
    private Integer cardStyle;
    @pbdb_alias("card_unit")
    private String cardUnit;
    @pbdb_alias("card_type")
    private Integer cardType;
    @pbdb_alias("card_recommend")
    private String cardRecommend;
    @pbdb_alias("card_default_value")
    private Integer cardDefaultValue;//remark:;length:10
    @pbdb_alias("is_del")
    private Integer isDel;//remark:是否已删除 0:是 1:否;length:10

    @pbdb_ignore
    private Date startDate;
    @pbdb_ignore
    private Date endDate;
    @pbdb_ignore
    private Integer isDayCard;
    @pbdb_ignore
    private Integer courseId;
    @pbdb_ignore
    private Set<ValidDate> validDates;


//  alter table t_calendar_cards add  `is_common` int(11) NOT NULL DEFAULT '1' COMMENT '是否常用卡片:1.是 0否';
//  alter table t_calendar_cards add  `c_status` int(11) NOT NULL DEFAULT '1' COMMENT '卡片状态 0 新建 1 正常 2下架';
//  alter table t_calendar_cards add  `defoult_common` int(11) NOT NULL DEFAULT '0' COMMENT '默认常用卡片 1.是 0否';

    @pbdb_alias("is_common")
    private Integer isCommon;

    @pbdb_alias("c_status")
    private Integer cStatus;

    @pbdb_alias("default_common")
    private Integer defaultCommon;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardIcon() {
        return cardIcon;
    }

    public void setCardIcon(String cardIcon) {
        this.cardIcon = cardIcon;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getCardStyle() {
        return cardStyle;
    }

    public void setCardStyle(Integer cardStyle) {
        this.cardStyle = cardStyle;
    }

    public String getCardUnit() {
        return cardUnit;
    }

    public void setCardUnit(String cardUnit) {
        this.cardUnit = cardUnit;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardRecommend() {
        return cardRecommend;
    }

    public void setCardRecommend(String cardRecommend) {
        this.cardRecommend = cardRecommend;
    }

    public Integer getCardDefaultValue() {
        return cardDefaultValue;
    }

    public void setCardDefaultValue(Integer cardDefaultValue) {
        this.cardDefaultValue = cardDefaultValue;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getIsDayCard() {
        return isDayCard;
    }

    public void setIsDayCard(Integer isDayCard) {
        this.isDayCard = isDayCard;
    }

    public final Set<ValidDate> getValidDates() {
        return validDates;
    }

    public final void setValidDates(Set<ValidDate> validDates) {
        this.validDates = validDates;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public Integer getDefaultCommon() {
        return defaultCommon;
    }

    public void setDefaultCommon(Integer defaultCommon) {
        this.defaultCommon = defaultCommon;
    }

    public Integer getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(Integer isCommon) {
        this.isCommon = isCommon;
    }

    @Override
    public String toString() {
        return "UserCard{" +
                "cardDefaultValue=" + cardDefaultValue +
                ", id=" + id +
                ", cardIcon='" + cardIcon + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardStyle=" + cardStyle +
                ", cardUnit='" + cardUnit + '\'' +
                ", cardType=" + cardType +
                ", cardRecommend='" + cardRecommend + '\'' +
                ", isDel=" + isDel +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isDayCard=" + isDayCard +
                ", courseId=" + courseId +
                ", validDates=" + validDates +
                ", isCommon=" + isCommon +
                ", cStatus=" + cStatus +
                ", defaultCommon=" + defaultCommon +
                '}';
    }
}
