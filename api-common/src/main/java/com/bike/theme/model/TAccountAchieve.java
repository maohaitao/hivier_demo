package com.bike.theme.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_account_achieve")
public class TAccountAchieve implements Serializable{
	@pbdb_ignore
	@Expose
	private Integer id;//remark:;length:10; not null,default:null
	@pbdb_alias("account_id")
	@Expose
	private String accountId;//remark:用户Id;length:64; not null,default:null
	@pbdb_alias("create_time")
	@Expose
	private Date createTime;//remark:创建时间;length:19; not null,default:null
	@Expose
	private String des;//remark:说明;length:250
	@pbdb_alias("relation_id")
	@Expose
	private Integer relationId;//remark:与之有关联的Id;length:10

	public TAccountAchieve() {

	}

	@Override
	public String toString() {
		return "TAccountAchieve{" +
				"accountId='" + accountId + '\'' +
				", id=" + id +
				", createTime=" + createTime +
				", des='" + des + '\'' +
				", relationId=" + relationId +
				'}';
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRelationId() {
		return relationId;
	}

	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}
}