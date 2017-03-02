package com.bikemanage.model.authorized;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("user")
public class User {

    @pbdb_ignore
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("login_name")
    private String loginName;//remark:;length:20; not null,default:null
    private String name;//remark:;length:20; not null,default:null
    private String password;//remark:;length:255; not null,default:null
    private String salt;//remark:;length:255
    private Date birthday;//remark:;length:0
    private Integer gender;//remark:;length:5
    private String email;//remark:;length:255
    private String phone;//remark:;length:20
    private String icon;//remark:;length:500
    @pbdb_alias("create_time")
    private Date createTime;//remark:;length:0
    private Integer state;//remark:;length:1
    private String description;//remark:;length:65535
    @pbdb_alias("login_count")
    private Integer loginCount;//remark:;length:10
    @pbdb_alias("previous_visit")
    private Date previousVisit;//remark:;length:0
    @pbdb_alias("last_visit")
    private Date lastVisit;//remark:;length:0
    @pbdb_alias("is_del")
    private Integer isDel;
    @pbdb_alias("error_count")
    private Integer errorCount;

    @pbdb_ignore
    private Integer roleId;

    public User() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getPreviousVisit() {
        return previousVisit;
    }

    public void setPreviousVisit(Date previousVisit) {
        this.previousVisit = previousVisit;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }
}