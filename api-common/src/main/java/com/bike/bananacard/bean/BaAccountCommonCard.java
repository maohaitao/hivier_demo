package com.bike.bananacard.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by a700 on 16/12/30.
 */
public class BaAccountCommonCard  extends UserCard implements Serializable {

    private Date createTime;//remark:卡片开始日期;length:0; not null,default:null

    private Integer sort;//remark:排序;length:10

    private Integer isExtend=0;

    private String extendImage;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsExtend() {
        return isExtend;
    }

    public void setIsExtend(Integer isExtend) {
        this.isExtend = isExtend;
    }

    public String getExtendImage() {
        return extendImage;
    }

    public void setExtendImage(String extendImage) {
        this.extendImage = extendImage;
    }
}
