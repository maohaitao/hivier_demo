package com.bike.dynamic.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by a700 on 16/9/30.
 */
@pbdb_alias("t_account_recommend")
public class AccountRecommend implements Serializable{
    @Expose
    @pbdb_alias("account_id")
    private String  accountId;
    @Expose
    @pbdb_ignore
    private String  nickName;
    @Expose
    @pbdb_ignore
    private String  userFace;
    @Expose
    @pbdb_ignore
    private List<String> imageUrlList;
    @Expose
    @pbdb_ignore
    private Integer sex;
    @Expose
    @pbdb_alias("comment")
    private String  comment;
    @Expose
    @pbdb_ignore
    private Integer is_vip;//vip_type
    @Expose
    @pbdb_ignore
    private Integer vip_type;//vip类型 1 官方帐号 2 明星帐号
    @Expose
    @pbdb_alias("push_time")
    private Date push_time;
    @Expose
    @pbdb_alias("is_top")
    private Integer is_top;//vip类型 1 官方帐号 2 明星帐号
    @Expose
    @pbdb_alias("top_time")
    private Date    top_time;
    @Expose
    @pbdb_ignore
    private Integer followStatus;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String account_id) {
        this.accountId = account_id;
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

    public List<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getIs_vip() {
        return is_vip;
    }

    public void setIs_vip(Integer is_vip) {
        this.is_vip = is_vip;
    }

    public Integer getVip_type() {
        return vip_type;
    }

    public void setVip_type(Integer vip_type) {
        this.vip_type = vip_type;
    }

    public Date getPush_time() {
        return push_time;
    }

    public void setPush_time(Date push_time) {
        this.push_time = push_time;
    }

    public Integer getIs_top() {
        return is_top;
    }

    public void setIs_top(Integer is_top) {
        this.is_top = is_top;
    }

    public Date getTop_time() {
        return top_time;
    }

    public void setTop_time(Date top_time) {
        this.top_time = top_time;
    }

    public Integer getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(Integer followStatus) {
        this.followStatus = followStatus;
    }

    @Override
    public String toString() {
        return "AccountRecommend{" +
                "account_id='" + accountId + '\'' +
                "imageUrlList='" + imageUrlList + '\'' +
                ", comment='" + comment + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userFace='" + userFace + '\'' +
                ", sex='" + sex + '\'' +
                ", vip_type='" + vip_type + '\'' +
                ", push_time='" + push_time + '\'' +
                ", is_top='" + is_top + '\'' +
                ", top_time=" + top_time +
                '}';
    }

}
