package com.bike.bananacard.bean;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;

/**
 * Created by a700 on 16/12/30.
 */
@pbdb_alias("t_calendar_relation")
public class TCalendarRelation implements Serializable{
    @Expose
    @pbdb_alias("tag_id")
    private Integer tagId;//标签id
    @Expose
    @pbdb_alias("tag_name")
    private String tagName;//标签名称
    @Expose
    @pbdb_alias("card_id")
    private Integer cardId;//卡片id
    @Expose
    @pbdb_alias("card_name")
    private String cardName;//卡片名称

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
