package com.bike.theme.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.io.Serializable;
import java.util.Date;

/*  */
@pbdb_alias("t_achieve_info")
public class TAchieveInfo implements Serializable {
	@pbdb_ignore
	@Expose
	private Integer id;//remark:;length:10; not null,default:null
	@pbdb_alias("achieve_name")
	@Expose
	private String achieveName;//remark:活动名;length:64; not null,default:null
	@pbdb_alias("achieve_des")
	@Expose
	private String achieveDes;//remark:活动说明;length:128
	@pbdb_alias("noachieve_type")
	@Expose
	private Integer noachieveType;//remark:活动类型 1 新注册 2 累计抵达城市数 3 累计抵达大洲 4 关注好友数 5 相互关注数 6 点赞数 7获得赞数 8排行榜排名x内 与卡片无关;length:10
	@pbdb_alias("nochieve_value")
	@Expose
	private Integer nochieveValue;//remark:成就达标的阀值;length:10
	@pbdb_alias("achieve_type")
	@Expose
	private Integer achieveType;//remark:活动类型  1 连续打卡天数、 2 累计打卡次数、3 累计打卡数 4累计打卡天数 5步数 6跑步距离 7跑步配速 8跑步时长 9跑步大卡 10跑步时间段 11跑步日期  ;length:10
	@pbdb_alias("achieve_value")
	@Expose
	private Integer achieveValue;//remark:成就达标的阀值;length:10
	@pbdb_alias("card_id")
	@Expose
	private Integer cardId;//remark:对应的卡片Id 0 不关联卡片Id即所有卡 非0 关联对应卡片;length:10; not null,default:0
	@pbdb_alias("create_time")
	@Expose
	private Date createTime;//remark:创建时间;length:19; not null,default:null
	@pbdb_alias("theme_url")
	@Expose
	private String themeUrl;//remark:皮肤URL;length:200
	@pbdb_alias("theme_icon")
	@Expose
	private String themeIcon;//remark:皮肤预览URL;length:200
	@pbdb_alias("is_del")
	@Expose
	private Integer isDel;//remark:0未删除 1已删除;length:10; not null,default:0
	@Expose
	private String des;//remark:说明;length:250
	@pbdb_alias("achieve_stime")
	@Expose
	private String achieveStime;//remark:成就开始时间,如:9:00;length:19
	@pbdb_alias("achieve_etime")
	@Expose
	private String achieveEtime;//remark:成就结束时间,如:10:00;length:19
	@pbdb_alias("achieve_sdate")
	@Expose
	private java.util.Date achieveSdate;//remark:成就开始日期;length:19
	@pbdb_alias("achieve_edate")
	@Expose
	private java.util.Date achieveEdate;//remark:成就结束日期;length:19

	@pbdb_alias("cityBgColor")
	@Expose
	private String cityBgColor;

	@pbdb_alias("calendarBgColor")
	@Expose
	private String calendarBgColor;

	@pbdb_alias("calendarCircleColor")
	@Expose
	private String calendarCircleColor;


	public TAchieveInfo() {
	}

	@Override
	public String toString() {
		return "TAchieveInfo{" +
				"achieveDes='" + achieveDes + '\'' +
				", id=" + id +
				", achieveName='" + achieveName + '\'' +
				", noachieveType=" + noachieveType +
				", nochieveValue=" + nochieveValue +
				", achieveType=" + achieveType +
				", achieveValue=" + achieveValue +
				", cardId=" + cardId +
				", createTime=" + createTime +
				", themeUrl='" + themeUrl + '\'' +
				", themeIcon='" + themeIcon + '\'' +
				", isDel=" + isDel +
				", des='" + des + '\'' +
				", achieveStime='" + achieveStime + '\'' +
				", achieveEtime='" + achieveEtime + '\'' +
				", achieveSdate=" + achieveSdate +
				", achieveEdate=" + achieveEdate +
				", cityBgColor='" + cityBgColor + '\'' +
				", calendarBgColor='" + calendarBgColor + '\'' +
				", calendarCircleColor='" + calendarCircleColor + '\'' +
				'}';
	}

	public String getCalendarBgColor() {
		return calendarBgColor;
	}

	public void setCalendarBgColor(String calendarBgColor) {
		this.calendarBgColor = calendarBgColor;
	}

	public String getCalendarCircleColor() {
		return calendarCircleColor;
	}

	public void setCalendarCircleColor(String calendarCircleColor) {
		this.calendarCircleColor = calendarCircleColor;
	}

	public String getCityBgColor() {
		return cityBgColor;
	}

	public void setCityBgColor(String cityBgColor) {
		this.cityBgColor = cityBgColor;
	}

	public String getAchieveDes() {
		return achieveDes;
	}

	public void setAchieveDes(String achieveDes) {
		this.achieveDes = achieveDes;
	}

	public String getAchieveName() {
		return achieveName;
	}

	public void setAchieveName(String achieveName) {
		this.achieveName = achieveName;
	}

	public Integer getAchieveType() {
		return achieveType;
	}

	public void setAchieveType(Integer achieveType) {
		this.achieveType = achieveType;
	}

	public Integer getAchieveValue() {
		return achieveValue;
	}

	public void setAchieveValue(Integer achieveValue) {
		this.achieveValue = achieveValue;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
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

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getNoachieveType() {
		return noachieveType;
	}

	public void setNoachieveType(Integer noachieveType) {
		this.noachieveType = noachieveType;
	}

	public Integer getNochieveValue() {
		return nochieveValue;
	}

	public void setNochieveValue(Integer nochieveValue) {
		this.nochieveValue = nochieveValue;
	}

	public String getThemeIcon() {
		return themeIcon;
	}

	public void setThemeIcon(String themeIcon) {
		this.themeIcon = themeIcon;
	}

	public String getThemeUrl() {
		return themeUrl;
	}

	public void setThemeUrl(String themeUrl) {
		this.themeUrl = themeUrl;
	}

	public Date getAchieveEdate() {
		return achieveEdate;
	}

	public void setAchieveEdate(Date achieveEdate) {
		this.achieveEdate = achieveEdate;
	}


	public Date getAchieveSdate() {
		return achieveSdate;
	}

	public void setAchieveSdate(Date achieveSdate) {
		this.achieveSdate = achieveSdate;
	}

	public String getAchieveEtime() {
		return achieveEtime;
	}

	public void setAchieveEtime(String achieveEtime) {
		this.achieveEtime = achieveEtime;
	}

	public String getAchieveStime() {
		return achieveStime;
	}

	public void setAchieveStime(String achieveStime) {
		this.achieveStime = achieveStime;
	}
}