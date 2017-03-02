package com.bike.bananacard.common.constant;


import com.bike.bananacard.common.tools.PropertiesUtils;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/11
 * time: 下午2:16
 * description: 加解密密钥
 */
public enum Keys {
    PRIVATEKEY(PropertiesUtils.getValue("privateKey")), PUBLICKEY(PropertiesUtils.getValue("publicKey"));
    private String value;

    Keys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
