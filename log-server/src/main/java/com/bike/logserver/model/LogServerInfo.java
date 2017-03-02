package com.bike.logserver.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.*;

/*  */
@pbdb_alias("log_server_info")
public class LogServerInfo {
	@Expose
	private String code;//remark:统计标示;length:64; not null,default:null
	@pbdb_alias("device_no")
	@Expose
	private String deviceNo;//remark:设备号;length:128
	@Expose
	private String imei;//remark:imei;length:128
	@Expose
	private String imsi;//remark:imsi;length:128
	@Expose
	private String channel;//remark:channel 渠道;length:128
	@Expose
	private String locals;//remark:locals 国家;length:128
	@Expose
	private String lang;//remark:lang 语言;length:128
	@Expose
	private String sdk;//remark:sdk;length:128
	@Expose
	private String models;//remark:models;length:128
	@Expose
	private String dpi;//remark:dpi;length:128
	@Expose
	private String net;//remark:网络;length:128
	@Expose
	private String timestamps;//remark:时间;length:128
	@pbdb_alias("device_type")
	@Expose
	private Integer deviceType;//remark:活动类型 2 IOS 1 ANDROID;length:10
	@pbdb_alias("account_id")
	@Expose
	private String accountId;//remark:用户ID;length:128
	@pbdb_alias("count_id")
	@Expose
	private String countId;//remark:统计Id;length:200
	@pbdb_alias("ra_id")
	@Expose
	private String raId;//remark:统计Id;length:200

	public LogServerInfo() {
	}

	@Override
	public String toString() {
		return "LogServerInfo{" +
				"accountId='" + accountId + '\'' +
				", code='" + code + '\'' +
				", deviceNo='" + deviceNo + '\'' +
				", imei='" + imei + '\'' +
				", imsi='" + imsi + '\'' +
				", channel='" + channel + '\'' +
				", locals='" + locals + '\'' +
				", lang='" + lang + '\'' +
				", sdk='" + sdk + '\'' +
				", models='" + models + '\'' +
				", dpi='" + dpi + '\'' +
				", net='" + net + '\'' +
				", timestamps='" + timestamps + '\'' +
				", deviceType=" + deviceType +
				", countId='" + countId + '\'' +
				", raId='" + raId + '\'' +
				'}';
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountId() {
		return countId;
	}

	public void setCountId(String countId) {
		this.countId = countId;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getDpi() {
		return dpi;
	}

	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLocals() {
		return locals;
	}

	public void setLocals(String locals) {
		this.locals = locals;
	}

	public String getModels() {
		return models;
	}

	public void setModels(String models) {
		this.models = models;
	}

	public String getNet() {
		return net;
	}

	public void setNet(String net) {
		this.net = net;
	}

	public String getRaId() {
		return raId;
	}

	public void setRaId(String raId) {
		this.raId = raId;
	}

	public String getSdk() {
		return sdk;
	}

	public void setSdk(String sdk) {
		this.sdk = sdk;
	}

	public String getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(String timestamps) {
		this.timestamps = timestamps;
	}
}