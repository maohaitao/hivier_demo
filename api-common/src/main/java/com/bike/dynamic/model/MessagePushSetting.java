package com.bike.dynamic.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;

/**
 * Created by allen duan on 16/9/30.
 * 消息栏推送设置
 */
@pbdb_alias("t_message_push_setting")
public class MessagePushSetting implements Serializable{

    @Expose
    @pbdb_alias("account_id")
    private String accountId;

    @Expose
    @pbdb_alias("total_mes_setting")
    private int total_mes_setting;

    @Expose
    @pbdb_alias("comment_mes_setting")
    private int comment_mes_setting;

    @Expose
    @pbdb_alias("thumbup_mes_setting")
    private int thumbup_mes_setting;

    @Expose
    @pbdb_alias("newfans_mes_setting")
    private int newfans_mes_setting;

    @Expose
    @pbdb_alias("daywalk_mes_setting")
    private int daywalk_mes_setting;

    @Expose
    @pbdb_alias("firthumb_mes_setting")
    private int firthumb_mes_setting;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getTotal_mes_setting() {
        return total_mes_setting;
    }

    public void setTotal_mes_setting(int total_mes_setting) {
        this.total_mes_setting = total_mes_setting;
    }

    public int getComment_mes_setting() {
        return comment_mes_setting;
    }

    public void setComment_mes_setting(int comment_mes_setting) {
        this.comment_mes_setting = comment_mes_setting;
    }

    public int getThumbup_mes_setting() {
        return thumbup_mes_setting;
    }

    public void setThumbup_mes_setting(int thumbup_mes_setting) {
        this.thumbup_mes_setting = thumbup_mes_setting;
    }

    public int getNewfans_mes_setting() {
        return newfans_mes_setting;
    }

    public void setNewfans_mes_setting(int newfans_mes_setting) {
        this.newfans_mes_setting = newfans_mes_setting;
    }

    public int getDaywalk_mes_setting() {
        return daywalk_mes_setting;
    }

    public void setDaywalk_mes_setting(int daywalk_mes_setting) {
        this.daywalk_mes_setting = daywalk_mes_setting;
    }

    public int getFirthumb_mes_setting() {
        return firthumb_mes_setting;
    }

    public void setFirthumb_mes_setting(int firthumb_mes_setting) {
        this.firthumb_mes_setting = firthumb_mes_setting;
    }
}
