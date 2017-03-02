package com.bike.route.model;

import java.io.Serializable;

/**
 * Created by a700 on 16/4/11.
 */
public class RunResulteMesage implements Serializable {
    private int mark;
    private String message;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RunResulteMesage{" +
                "mark=" + mark +
                ", message='" + message + '\'' +
                '}';
    }
}
