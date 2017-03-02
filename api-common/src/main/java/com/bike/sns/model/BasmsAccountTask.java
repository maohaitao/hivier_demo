package com.bike.sns.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("basms_account_task")
public class BasmsAccountTask implements Serializable {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("t_id")
    @Expose
    private Integer tId;//remark:任务ID;length:10; not null,default:null
    @pbdb_alias("acc_id")
    @Expose
    private String accId;//remark:用户的ID;length:255; not null,default:null
    @pbdb_ignore
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:创建时间;length:19
    @pbdb_alias("assoc_acc_id")
    @Expose
    private String assocAccId;//remark:关联的用户ID;length:10
    @pbdb_alias("u_type")
    @Expose
    private Integer uType;//remark:1:点赞 2:关注;length:10
    @pbdb_alias("u_status")
    @Expose
    private Integer uStatus;//remark:1:待发送 2:发送中 3:成功 4:失败;length:10

    public BasmsAccountTask() {
    }

    @Override
    public String toString() {
        return "BasmsAccountTask{" +
                "accId='" + accId + '\'' +
                ", id=" + id +
                ", tId=" + tId +
                ", createTime=" + createTime +
                ", assocAccId=" + assocAccId +
                ", uType=" + uType +
                ", uStatus=" + uStatus +
                '}';
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getAssocAccId() {
        return assocAccId;
    }

    public void setAssocAccId(String assocAccId) {
        this.assocAccId = assocAccId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public Integer getuType() {
        return uType;
    }

    public void setuType(Integer uType) {
        this.uType = uType;
    }
}