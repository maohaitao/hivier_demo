package com.bike.bananacard.bean;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by allen duan on 17/1/4.
 */
public class TCommonCard implements Serializable {

    private Integer card_id;
    private String card_icon;
    private String card_name;
    private Integer card_style;
    private String card_unit;
    private Integer card_type;
    private String card_desc;
    private Integer is_del;//remark:是否已删除 0:是 1:否;length:10
    private Date createTime;//remark:卡片开始日期;length:0; not null,default:null
    private Integer sort;//remark:排序;length:10
    private Integer isExtend=0;
    private String extendImage;
    private Double calorie;
    private Integer isDayCard;

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public String getCard_icon() {
        return card_icon;
    }

    public void setCard_icon(String card_icon) {
        this.card_icon = card_icon;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public Integer getCard_style() {
        return card_style;
    }

    public void setCard_style(Integer card_style) {
        this.card_style = card_style;
    }

    public String getCard_unit() {
        return card_unit;
    }

    public void setCard_unit(String card_unit) {
        this.card_unit = card_unit;
    }

    public Integer getCard_type() {
        return card_type;
    }

    public void setCard_type(Integer card_type) {
        this.card_type = card_type;
    }

    public String getCard_desc() {
        return card_desc;
    }

    public void setCard_desc(String card_desc) {
        this.card_desc = card_desc;
    }

    public Integer getIs_del() {
        return is_del;
    }

    public void setIs_del(Integer is_del) {
        this.is_del = is_del;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public Integer getIsDayCard() {
        return isDayCard;
    }

    public void setIsDayCard(Integer isDayCard) {
        this.isDayCard = isDayCard;
    }

    public void doCopyBaAccountCommonCard(BaAccountCommonCard baAccountCommonCard){
        if(null!=baAccountCommonCard){
            this.card_id=baAccountCommonCard.getId();
            this.card_desc=baAccountCommonCard.getCardRecommend();
            this.card_icon=baAccountCommonCard.getCardIcon();
            this.card_name=baAccountCommonCard.getCardName();
            this.card_style=baAccountCommonCard.getCardStyle();
            this.card_type=baAccountCommonCard.getCardType();
            this.card_unit=baAccountCommonCard.getCardUnit();
            this.createTime=baAccountCommonCard.getCreateTime();
            this.is_del=baAccountCommonCard.getIsDel();
            this.isExtend=baAccountCommonCard.getIsExtend();
            this.extendImage=baAccountCommonCard.getExtendImage();
            this.isDayCard=baAccountCommonCard.getIsDayCard();
        }
    }
    public void doCopyTCalendarCards(TCalendarCards baAccountCommonCard){
        if(null!=baAccountCommonCard){
            this.card_id=baAccountCommonCard.getId();
            this.card_desc=baAccountCommonCard.getCardRecommend();
            this.card_icon=baAccountCommonCard.getCardIcon();
            this.card_name=baAccountCommonCard.getCardName();
            this.card_style=baAccountCommonCard.getCardStyle();
            this.card_type=baAccountCommonCard.getCardType();
            this.card_unit=baAccountCommonCard.getCardUnit();
            this.createTime=baAccountCommonCard.getCreateTime();
            this.is_del=baAccountCommonCard.getIsDel();
            this.isExtend=baAccountCommonCard.getIsExtend();
            this.extendImage=baAccountCommonCard.getExtendImage();
            this.calorie=baAccountCommonCard.getCalorie();
            this.isDayCard=baAccountCommonCard.getIsDayCard();
        }
    }



}
