package com.hi.model;

/**
 * Created by a700 on 17/3/3.
 */

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

@pbdb_alias("hi_product")
public class HiProduct {

    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("pro_sku")
    @Expose
    private String proSku;//remark:sku;length:255

    @pbdb_alias("pro_name")
    @Expose
    private String proName;//remark:名称;length:255

    @Expose
    private String url;//remark:icon;length:255
    @Expose
    private String icon;//remark:icon;length:255

    @Expose
    private String category;//remark:类别;length:255

    @pbdb_alias("c_time")
    @Expose
    private Date cTime;//remark:创建时间;length:255

    @pbdb_alias("p_status")
    @Expose
    private Integer pStatus;// '0' COMMENT '状态 0 无效 1有效',

    @Override
    public String toString() {
        return "HiProduct{" +
                "category='" + category + '\'' +
                ", id=" + id +
                ", proSku='" + proSku + '\'' +
                ", proName='" + proName + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", cTime=" + cTime +
                ", pStatus=" + pStatus +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProSku() {
        return proSku;
    }

    public void setProSku(String proSku) {
        this.proSku = proSku;
    }

    public Integer getpStatus() {
        return pStatus;
    }

    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
