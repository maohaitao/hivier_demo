package com.hi.model;

/**
 * Created by a700 on 17/3/3.
 */

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

@pbdb_alias("hi_user_info")
public class HiUserInfo {

    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("user_name")
    @Expose
    private String userName;//remark:sku;length:255

    @Expose
    private String email;//remark:icon;length:255

    @pbdb_alias("c_time")
    @Expose
    private Date cTime;//remark:创建时间;length:255

    @Override
    public String toString() {
        return "HiUserInfo{" +
                "cTime=" + cTime +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
