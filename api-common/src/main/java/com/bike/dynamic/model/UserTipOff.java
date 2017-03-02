package com.bike.dynamic.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by allen on 16/9/28.
 * 用户举报动态或评论接口
 */
@pbdb_alias("t_user_tip_off")
public class UserTipOff implements Serializable{
    @Expose
    @pbdb_alias("id")
    private Integer id;
    @Expose
    @pbdb_alias("tip_off_id")
    private Integer tip_off_id;//动态或评论id
    @Expose
    @pbdb_alias("type")
    private Integer type;//1 图文动态举报 2 评论举报
    @Expose
    @pbdb_alias("who_tips")
    private String who_tips;//举报人
    @Expose
    @pbdb_alias("tips_who")
    private String  tips_who;//被举报人
    @Expose
    @pbdb_alias("content")
    private String  content;//举报内容
    @Expose
    @pbdb_alias("reason_type")
    private Integer reason_type;//0-其他 1-淫秽色情 2-垃圾营销 3-违法信息
    @Expose
    @pbdb_alias("tips_time")
    private Date tips_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTip_off_id() {
        return tip_off_id;
    }

    public void setTip_off_id(Integer tip_off_id) {
        this.tip_off_id = tip_off_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getWho_tips() {
        return who_tips;
    }

    public void setWho_tips(String who_tips) {
        this.who_tips = who_tips;
    }

    public String getTips_who() {
        return tips_who;
    }

    public void setTips_who(String tips_who) {
        this.tips_who = tips_who;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReason_type() {
        return reason_type;
    }

    public void setReason_type(Integer reason_type) {
        this.reason_type = reason_type;
    }

    public Date getTips_time() {
        return tips_time;
    }

    public void setTips_time(Date tips_time) {
        this.tips_time = tips_time;
    }
}
