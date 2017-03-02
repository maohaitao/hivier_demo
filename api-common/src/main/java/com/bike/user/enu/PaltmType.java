package com.bike.user.enu;

/**
 * Created by a700 on 16/1/11.
 * 接入方式枚举
 */
public enum PaltmType {
    // p代表平台类型(a：Android、i：IOS)
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
