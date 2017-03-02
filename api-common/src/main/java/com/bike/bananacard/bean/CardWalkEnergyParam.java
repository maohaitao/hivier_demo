package com.bike.bananacard.bean;

import java.io.Serializable;

/**
 * Created by allen duan on 16/12/19.
 */
public class CardWalkEnergyParam implements Serializable {
    private String date;//打卡日期 yyyy-MM-dd HH:mi:ss
    private String version;//版本参数
    private String planResult;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlanResult() {
        return planResult;
    }

    public void setPlanResult(String planResult) {
        this.planResult = planResult;
    }
}
