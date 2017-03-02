package com.bike.dynamic.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by allen duan on 16/9/28.
 * 动态评论
 */
@pbdb_alias("t_card_image_dynamic_comment")
public class DynamicComment implements Serializable{
    @Expose
    @pbdb_alias("id")
    private Integer id;
    @Expose
    @pbdb_alias("dynamic_id")
    private Integer dynamicId;
    @Expose
    @pbdb_alias("comment_id")
    private Integer commentId;
    @Expose
    @pbdb_ignore
    private String image_url;
    @Expose
    @pbdb_alias("account_id")
    private String accountId;
    @Expose
    @pbdb_alias("who_reply")
    private String who_reply;
    @Expose
    @pbdb_ignore
    private String whoReplyNickName;//昵称
    @Expose
    @pbdb_ignore
    private String whoReplyUserFace;//头像
    @Expose
    @pbdb_ignore
    private Integer whoReplySex;//remark:1:男 2:女;length:10
    @Expose
    @pbdb_alias("reply_who")
    private String  reply_who;
    @Expose
    @pbdb_ignore
    private String replyWhoNickName;//昵称
    @Expose
    @pbdb_ignore
    private String replyWhoUserFace;//头像
    @Expose
    @pbdb_ignore
    private Integer replyWhoSex;//remark:1:男 2:女;length:10

    @Expose
    @pbdb_alias("comment")
    private String  comment;

    @Expose
    @pbdb_alias("comment_time")
    private Date comment_time;


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

    public String getWho_reply() {
        return who_reply;
    }

    public void setWho_reply(String who_reply) {
        this.who_reply = who_reply;
    }

    public String getWhoReplyNickName() {
        return whoReplyNickName;
    }

    public void setWhoReplyNickName(String whoReplyNickName) {
        this.whoReplyNickName = whoReplyNickName;
    }

    public String getWhoReplyUserFace() {
        return whoReplyUserFace;
    }

    public void setWhoReplyUserFace(String whoReplyUserFace) {
        this.whoReplyUserFace = whoReplyUserFace;
    }

    public Integer getWhoReplySex() {
        return whoReplySex;
    }

    public void setWhoReplySex(Integer whoReplySex) {
        this.whoReplySex = whoReplySex;
    }

    public String getReply_who() {
        return reply_who;
    }

    public void setReply_who(String reply_who) {
        this.reply_who = reply_who;
    }

    public String getReplyWhoNickName() {
        return replyWhoNickName;
    }

    public void setReplyWhoNickName(String replyWhoNickName) {
        this.replyWhoNickName = replyWhoNickName;
    }

    public String getReplyWhoUserFace() {
        return replyWhoUserFace;
    }

    public void setReplyWhoUserFace(String replyWhoUserFace) {
        this.replyWhoUserFace = replyWhoUserFace;
    }

    public Integer getReplyWhoSex() {
        return replyWhoSex;
    }

    public void setReplyWhoSex(Integer replyWhoSex) {
        this.replyWhoSex = replyWhoSex;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
