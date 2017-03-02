package com.bike.bananacard.common.emu;

/**
 * Created by a700 on 16/1/11.
 * 接入方式枚举
 */
public enum PaltmType {
    a("AND", 1), i("IOS", 2);

    private String paltName;
    private int type;

    PaltmType(String paltName, int type) {
        this.paltName = paltName;
        this.type = type;
    }

    public String getPaltName() {
        return paltName;
    }

    public void setPaltName(String paltName) {
        this.paltName = paltName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
