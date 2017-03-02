package com.bike.user.model;

import java.io.Serializable;

public class OauthUser implements Serializable {
    private String openid;
    private int openTypeIndex;
    private String petName;
    private int sex;
    private String portraiturl;

    /**
     * @return 获取openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     * @Description 设置openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * @return 获取openTypeIndex
     */
    public int getOpenTypeIndex() {
        return openTypeIndex;
    }

    /**
     * @param openTypeIndex
     * @Description 设置openTypeIndex
     */
    public void setOpenTypeIndex(int openTypeIndex) {
        this.openTypeIndex = openTypeIndex;
    }

    /**
     * @return 获取petName
     */
    public String getPetName() {
        return petName;
    }

    /**
     * @param petName
     * @Description 设置petName
     */
    public void setPetName(String petName) {
        this.petName = petName;
    }

    /**
     * @return 获取sex
     */
    public int getSex() {
        return sex;
    }

    /**
     * @param sex
     * @Description 设置sex
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * @return 获取portraiturl
     */
    public String getPortraiturl() {
        return portraiturl;
    }

    /**
     * @param portraiturl
     * @Description 设置portraiturl
     */
    public void setPortraiturl(String portraiturl) {
        this.portraiturl = portraiturl;
    }

}
