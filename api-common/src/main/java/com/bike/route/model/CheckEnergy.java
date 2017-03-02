package com.bike.route.model;

import java.io.Serializable;

/**
 * Created by a700 on 16/5/26.
 */
public class CheckEnergy implements Serializable {
    private String info;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
