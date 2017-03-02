package com.bikemanage.common.tools;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：
 * 创建时间：15/5/11
 */

public class DateRange implements Serializable {

    private static final long serialVersionUID = 7099749496174999964L;

    private Date startDateTime;
    private Date endDateTime;
    private String text;

    // ------------------------------------------------------------------------------------
    // 构造方法

    public DateRange() {
        super();
    }

    public DateRange(Date startDateTime, Date endDateTime, String text) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.text = text;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        return text;
    }

}
