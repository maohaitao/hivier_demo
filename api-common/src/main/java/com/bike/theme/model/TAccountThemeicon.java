package com.bike.theme.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_account_themeicon")
public class TAccountThemeicon implements Serializable {
	@pbdb_ignore
	@Expose
	private Integer id;//remark:;length:10; not null,default:null
	@pbdb_alias("account_id")
	@Expose
	private String accountId;//remark:用户Id;length:64; not null,default:null
	@pbdb_alias("theme_type")
	@Expose
	private Integer themeType;//remark:主题皮肤类型 1成就皮肤、 2 挑战皮肤、 0 到达城市 ;length:10
	@pbdb_alias("create_time")
	@Expose
	private Date createTime;//remark:创建时间;length:19; not null,default:null
	@pbdb_alias("theme_url")
	@Expose
	private String themeUrl;//remark:皮肤URL;length:200
	@pbdb_alias("theme_icon")
	@Expose
	private String themeIcon;//remark:皮肤预览URL;length:200
	@Expose
	private String des;//remark:说明;length:250
	@pbdb_alias("relation_id")
	@Expose
	private Integer relationId;//remark:与之有关联的Id;length:10

	public TAccountThemeicon() {
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

	public String getThemeIcon() {
		return themeIcon;
	}

	public void setThemeIcon(String themeIcon) {
		this.themeIcon = themeIcon;
	}

	public Integer getThemeType() {
		return themeType;
	}

	public void setThemeType(Integer themeType) {
		this.themeType = themeType;
	}

	public String getThemeUrl() {
		return themeUrl;
	}

	public void setThemeUrl(String themeUrl) {
		this.themeUrl = themeUrl;
	}

	@Override
	public String toString() {
		return "TAccountThemeicon{" +
				"accountId='" + accountId + '\'' +
				", id=" + id +
				", themeType=" + themeType +
				", createTime=" + createTime +
				", themeUrl='" + themeUrl + '\'' +
				", themeIcon='" + themeIcon + '\'' +
				", des='" + des + '\'' +
				", relationId=" + relationId +
				'}';
	}
}