package com.hi.model;

/**
 * Created by a700 on 17/3/3.
 */

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

@pbdb_alias("hi_blog")
public class HiBlog {

    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null

    @Expose
    private String title;//remark:'标题';length:255

    @Expose
    private String icon;//remark:icon;length:255

    @pbdb_alias("b_auther")
    @Expose
    private String bAuther;//remark:'作者';length:255

    @pbdb_alias("b_content")
    @Expose
    private String bContent;//remark:'内容';length:255

    @pbdb_alias("c_time")
    @Expose
    private Date cTime;//remark:创建时间;length:255

    @pbdb_alias("p_status")
    @Expose
    private Integer pStatus;// '0' COMMENT '状态 0 无效 1有效',

    @Override
    public String toString() {
        return "HiBlog{" +
                "bAuther='" + bAuther + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", bContent='" + bContent + '\'' +
                ", cTime=" + cTime +
                ", pStatus=" + pStatus +
                '}';
    }

    public String getbAuther() {
        return bAuther;
    }

    public void setbAuther(String bAuther) {
        this.bAuther = bAuther;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpStatus() {
        return pStatus;
    }

    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
