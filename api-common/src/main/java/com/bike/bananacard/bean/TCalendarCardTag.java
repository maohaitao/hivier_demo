package com.bike.bananacard.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by a700 on 16/12/30.
 */
public class TCalendarCardTag implements Serializable{
    private  Integer tagId;
    private  String tagName;
    private  List<Integer> cardList;

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

    public List<Integer> getCardList() {
        return cardList;
    }

    public void setCardList(List<Integer> cardList) {
        this.cardList = cardList;
    }
}
