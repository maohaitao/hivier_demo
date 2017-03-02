package com.bike.user.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("banana_feedback_info")
public class BananaFeedbackInfo implements Serializable {

//    CREATE TABLE `banana_version_info` (
//            `id` int(11) NOT NULL AUTO_INCREMENT,
//    `phead` varchar(255) NOT NULL COMMENT '头消息',
//            `feedback_content` text NOT NULL COMMENT '反馈内容',
//            `feedback_contact` varchar(255) NOT NULL DEFAULT '2' COMMENT '联系方式',
//            `c_time` timestamp NOT NULL DEFAULT  CURRENT_TIMESTAMP COMMENT '创建时间',
//    PRIMARY KEY (`id`)
//    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


    private String id;
    @Expose
    private String phead;
    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:账号ID;length:64; not null,default:null

    @pbdb_alias("feedback_content")
    @Expose
    private String feedbackContent;
    @pbdb_alias("feedback_contact")
    private String feedbackContact;
    @pbdb_alias("c_time")
    private Date cTime;//remark:注册时间;length:19; not null,default:null

    @pbdb_alias("card_id")
    private Integer card_id;//remark:卡片ID;length:10; not null,default:null
    @pbdb_alias("card_result_id")
    private Integer card_result_id;

    public BananaFeedbackInfo() {

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "BananaFeedbackInfo{" +
                "accountId='" + accountId + '\'' +
                ", id='" + id + '\'' +
                ", phead='" + phead + '\'' +
                ", feedbackContent='" + feedbackContent + '\'' +
                ", feedbackContact='" + feedbackContact + '\'' +
                ", cTime=" + cTime +
                '}';
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getFeedbackContact() {
        return feedbackContact;
    }

    public void setFeedbackContact(String feedbackContact) {
        this.feedbackContact = feedbackContact;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhead() {
        return phead;
    }

    public void setPhead(String phead) {
        this.phead = phead;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public Integer getCard_result_id() {
        return card_result_id;
    }

    public void setCard_result_id(Integer card_result_id) {
        this.card_result_id = card_result_id;
    }
}