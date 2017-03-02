package com.bike.sns.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("basns_game_together")
public class BasnsGameTogether implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:用户关注并同行表;length:10; not null,default:null
    @pbdb_alias("follow_who")
    @Expose
    private String followWho;//remark:关注谁;length:200
    @pbdb_alias("who_follow")
    @Expose
    private String whoFollow;//remark:谁关注;length:200; not null,default:null
    @pbdb_ignore
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:修改时间;length:19; not null,default:CURRENT_TIMESTAMP

    public BasnsGameTogether() {
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFollowWho() {
        return followWho;
    }

    public void setFollowWho(String followWho) {
        this.followWho = followWho;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhoFollow() {
        return whoFollow;
    }

    public void setWhoFollow(String whoFollow) {
        this.whoFollow = whoFollow;
    }
}