package com.bike.apicommon;


import com.sf.common.reflection.property.PropertiesUtil;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/11
 * time: 下午2:16
 * description: 加解密密钥
 */
public enum Keys {
    PRIVATEKEY(PropertiesUtil.getValue("privateKey")),
    PUBLICKEY(PropertiesUtil.getValue("publicKey"));

    private String value;

    Keys(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Keys{" +
                "value='" + value + '\'' +
                '}';
    }
}
