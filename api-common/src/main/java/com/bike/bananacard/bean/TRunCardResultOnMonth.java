package com.bike.bananacard.bean;

import com.sf.common.reflection.annotations.pbdb_alias;

import java.io.Serializable;

/**
 * Created by a700 on 16/10/4.
 */
public class TRunCardResultOnMonth implements Serializable{
    @pbdb_alias("totalDistance")
    private Double totalDistance;//跑步月總數

    @pbdb_alias("month")
    private String month;//跑步月分

    @pbdb_alias("count")
    private  Integer count;//跑步總次數


    public String getMonth(){
        return  month;
    }

    public void setMonth(String month){
        this.month = month;
    }

    public  Double getTotalDistance(){
        return  totalDistance;
    }

    public  void setTotalDistance(Double totalDistance){
        this.totalDistance = totalDistance;
    }

    public Integer getCount(){
        return  count;
    }

    public  void setCount(Integer count ){
        this.count = count;
    }

}
