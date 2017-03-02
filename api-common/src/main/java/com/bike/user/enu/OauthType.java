package com.bike.user.enu;

/**
 * Created by a700 on 16/1/11.
 * 第三方登录的方式枚举
 */
public enum OauthType {
    // `type` INT NOT NULL COMMENT '绑定类型 1:微信 2:微博 3 qq',
    QQ("qq", 3), WECHAT("微信", 1), WEIBO("微博", 2);

    private String oauthName;
    private int oauthType;


    private OauthType(String oauthName, int oauthType) {
        this.oauthName = oauthName;
        this.oauthType = oauthType;
    }

    public String getOauthName() {
        return oauthName;
    }

    public void setOauthName(String oauthName) {
        this.oauthName = oauthName;
    }

    public int getOauthType() {
        return oauthType;
    }

    public void setOauthType(int oauthType) {
        this.oauthType = oauthType;
    }


}
