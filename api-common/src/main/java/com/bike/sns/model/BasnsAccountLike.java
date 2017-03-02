package com.bike.sns.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("basns_account_like")
public class BasnsAccountLike implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:用点赞;length:10; not null,default:null
    @pbdb_alias("like_who")
    @Expose
    private String likeWho;//remark:喜欢谁;length:200; not null,default:null
    @pbdb_alias("who_like")
    @Expose
    private String whoLike;//remark:谁喜欢;length:45; not null,default:null
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:开始时间;length:19

    public BasnsAccountLike() {
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLikeWho() {
        return likeWho;
    }

    public void setLikeWho(String likeWho) {
        this.likeWho = likeWho;
    }

    public String getWhoLike() {
        return whoLike;
    }

    public void setWhoLike(String whoLike) {
        this.whoLike = whoLike;
    }
}