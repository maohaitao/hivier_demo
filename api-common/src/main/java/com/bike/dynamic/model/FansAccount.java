package com.bike.dynamic.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;

/**
 * Created by allen duan on 16/9/22.
 */
@pbdb_alias("t_account")
public class FansAccount implements Serializable {
    @Expose
    @pbdb_alias("account_id")
    private String  account_id;
    @Expose
    @pbdb_ignore
    private String  nickName;
    @Expose
    @pbdb_ignore
    private String  userFace;
    @Expose
    @pbdb_ignore
    private Integer sex;
    @Expose
    @pbdb_ignore
    private Integer cardCount;
    @Expose
    @pbdb_ignore
    private Integer  relation_type;//1 未关注 2已关注
    @Expose
    @pbdb_ignore
    private Integer is_new;//1 未关注 2已关注

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCardCount() {
        return cardCount;
    }

    public void setCardCount(Integer cardCount) {
        this.cardCount = cardCount;
    }

    public Integer getRelation_type() {
        return relation_type;
    }

    public void setRelation_type(Integer relation_type) {
        this.relation_type = relation_type;
    }

    public Integer getIs_new() {
        return is_new;
    }

    public void setIs_new(Integer is_new) {
        this.is_new = is_new;
    }

    @Override
    public String toString() {
        return "FansAccount{" +
                "account_id='" + account_id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userFace='" + userFace + '\'' +
                ", sex='" + sex + '\'' +
                ", cardCount='" + cardCount + '\'' +
                ", relation_type='" + relation_type + '\'' +
                ", is_new='" + is_new + '\'' +
                '}';
    }

}
