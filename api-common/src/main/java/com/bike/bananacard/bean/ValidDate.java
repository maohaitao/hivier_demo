package com.bike.bananacard.bean;

import com.bike.bananacard.common.tools.DateUtils;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/2/25
 * time: 下午8:08
 * description: 有效日期
 */
public class ValidDate implements Comparable<ValidDate> , Serializable{
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("end_date")
    private String endDate;

    private transient Integer isDayCard;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof ValidDate) {
            ValidDate validDate = (ValidDate) o;
            if (getStartDate().equals(validDate.getStartDate()) && getEndDate().equals(validDate.getEndDate())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int result = getStartDate().hashCode();
        result = 29 * result + ((getEndDate() == null) ? DateUtils.getDate().hashCode() : getEndDate().hashCode());
        return result;
    }

    public Integer getIsDayCard() {
        return isDayCard;
    }

    public void setIsDayCard(Integer isDayCard) {
        this.isDayCard = isDayCard;
    }

    @Override
    public int compareTo(ValidDate validDate) {
        if (validDate != null) {
            return (int) (DateUtils.getTime(this.startDate) - DateUtils.getTime(validDate.getStartDate()));
        }
        return 0;
    }
}
