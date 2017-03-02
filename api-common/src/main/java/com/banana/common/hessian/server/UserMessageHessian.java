package com.banana.common.hessian.server;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by allen duan on 16/9/22.
 */
@pbdb_alias("t_user_message_push")
public class UserMessageHessian implements Serializable {
    @Expose
    @pbdb_alias("id")
    private Integer id;
    @Expose
    @pbdb_alias("title")
    private String  title;
    @Expose
    @pbdb_alias("account_id")
    private String  account_id;
    @Expose
    @pbdb_alias("push_record_id")
    private Integer push_record_id;
    @Expose
    @pbdb_alias("push_type")
    private Integer push_type;//1 用户精选 2 动态精选 3 动态被禁 4评论被禁 0 其他推送 5 活动挑战
    @Expose
    @pbdb_alias("push_time")
    private Date    push_time;
    @Expose
    @pbdb_alias("redirect_url")
    private String  redirect_url;
    @Expose
    @pbdb_alias("is_del")
    private String  isDel; //ALTER TABLE `t_user_message_push` ADD COLUMN `is_del` int(2) NOT NULL DEFAULT 0 COMMENT '0未删除 1删除';
    @Expose
    @pbdb_alias("is_readed")
    private String  isReaded; //ALTER TABLE `t_user_message_push` ADD COLUMN `is_readed` int(2) NOT NULL DEFAULT 0 COMMENT '是否已读 0未 1已';
    @Expose
    @pbdb_alias("comment")
    private String  comment;
    @Expose
    @pbdb_ignore
    private Integer is_new;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public Integer getPush_record_id() {
        return push_record_id;
    }

    public void setPush_record_id(Integer push_record_id) {
        this.push_record_id = push_record_id;
    }

    public Integer getPush_type() {
        return push_type;
    }

    public void setPush_type(Integer push_type) {
        this.push_type = push_type;
    }

    public Date getPush_time() {
        return push_time;
    }

    public void setPush_time(Date push_time) {
        this.push_time = push_time;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getIs_new() {
        return is_new;
    }

    public void setIs_new(Integer is_new) {
        this.is_new = is_new;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getIsReaded() {
        return isReaded;
    }

    public void setIsReaded(String isReaded) {
        this.isReaded = isReaded;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "account_id='" + account_id + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", push_record_id=" + push_record_id +
                ", push_type=" + push_type +
                ", push_time=" + push_time +
                ", redirect_url='" + redirect_url + '\'' +
                ", isDel='" + isDel + '\'' +
                ", isReaded='" + isReaded + '\'' +
                ", comment='" + comment + '\'' +
                ", is_new=" + is_new +
                '}';
    }
}
