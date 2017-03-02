package com.bike.user.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_account_config")
public class TAccountConfig implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("is_public")
    @Expose
    private Integer isPublic;//remark:0:不公开 1:公开;length:10
    @pbdb_alias("default_calendar")
    @Expose
    private Integer defaultCalendar;//remark:0:月 1:周;length:10
    @pbdb_alias("walk_step")
    @Expose
    private Integer walkStep;//remark:走路步数目标;length:10
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:创建时间;length:19; not null,default:null
    @pbdb_ignore
    @pbdb_alias("update_time")
    @Expose
    private Date updateTime;//remark:修改时间;length:19; not null,default:CURRENT_TIMESTAMP
    @pbdb_alias("account_id")
    @Expose
    private String accountId;//remark:;length:64; not null,default:null

    public TAccountConfig() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getDefaultCalendar() {
        return defaultCalendar;
    }

    public void setDefaultCalendar(Integer defaultCalendar) {
        this.defaultCalendar = defaultCalendar;
    }

    public Integer getWalkStep() {
        return walkStep;
    }

    public void setWalkStep(Integer walkStep) {
        this.walkStep = walkStep;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}