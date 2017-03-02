package com.bike.bananacard.bean;

import com.sf.common.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/11
 * time: 下午4:18
 * description: 协议头信息单元
 */
public class ProtocolHeader implements Serializable {
    private String device_no;
    private String imei;
    private String imsi;
    private String channel;
    private String local;
    private String lang;
    private String sdk;
    private String models;
    private String dpi;
    private String net;
    private Long timestamp;

    public String getDevice_no() {
        return device_no;
    }

    public void setDevice_no(String device_no) {
        this.device_no = device_no;
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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getSdk() {
        return sdk;
    }

    public void setSdk(String sdk) {
        this.sdk = sdk;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String string(){
        return "" +
                "" + device_no +
                "||" + imei +
                "||" + imsi +
                "||" + channel +
                "||" + local +
                "||" + lang +
                "||" + sdk +
                "||" + models +
                "||" + dpi +
                "||" + net +
                "||" + DateUtil.formatDateToStringDefault(new Date());
    }

    @Override
    public String toString() {
        return "ProtocolHeader{" +
                "device_no='" + device_no + '\'' +
                ", imei='" + imei + '\'' +
                ", imsi='" + imsi + '\'' +
                ", channel='" + channel + '\'' +
                ", local='" + local + '\'' +
                ", lang='" + lang + '\'' +
                ", sdk='" + sdk + '\'' +
                ", models='" + models + '\'' +
                ", dpi='" + dpi + '\'' +
                ", net='" + net + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
