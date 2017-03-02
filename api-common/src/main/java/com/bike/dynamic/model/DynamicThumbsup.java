package com.bike.dynamic.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by allen duan on 16/9/22.
 */
@pbdb_alias("t_dynamic_thumbsup")
public class DynamicThumbsup implements Serializable {
    @Expose
    @pbdb_alias("id")
    private Integer id;
    @Expose
    @pbdb_alias("dynamic_id")
    private Integer dynamicId;
    @Expose
    @pbdb_ignore
    private String image_url;
    @Expose
    @pbdb_alias("who_gave")
    private String who_gave;
    @Expose
    @pbdb_ignore
    private String nickName;//昵称
    @Expose
    @pbdb_ignore
    private String userFace;//头像
    @Expose
    @pbdb_ignore
    private Integer sex;//remark:1:男 2:女;length:10
    @Expose
    @pbdb_alias("gave_who")
    private String  gave_who;
    @Expose
    @pbdb_alias("create_time")
    private Date create_time;
    @Expose
    @pbdb_alias("type")
    private Integer  type;//1  图文动态点赞 2 个人点赞
    @Expose
    @pbdb_ignore
    private Integer  is_new;

    @Expose
    @pbdb_ignore
    private Integer followStatus;

    @Expose
    @pbdb_ignore
    private Integer card_id;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getWho_gave() {
        return who_gave;
    }

    public void setWho_gave(String who_gave) {
        this.who_gave = who_gave;
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

    public String getGave_who() {
        return gave_who;
    }

    public void setGave_who(String gave_who) {
        this.gave_who = gave_who;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIs_new() {
        return is_new;
    }

    public void setIs_new(Integer is_new) {
        this.is_new = is_new;
    }

    public Integer getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(Integer followStatus) {
        this.followStatus = followStatus;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    @Override
    public String toString() {
        return "DynamicThumbsup{" +
                "id='" + id + '\'' +
                ", dynamic_id='" + dynamicId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userFace='" + userFace + '\'' +
                ", sex='" + sex + '\'' +
                ", who_gave='" + who_gave + '\'' +
                ", gave_who='" + gave_who + '\'' +
                ", type='" + type + '\'' +
                ", is_new=" + is_new +
                '}';
    }
}
