package com.bike.mq;

/**
 * Created by a700 on 16/11/30.
 * 消息类型的枚举
 */
public enum MQType {

//    //评论动态
//    public static final Integer BANANA_COMMENT_DYNAMIC =1;
//    //    动态点赞
//    public static final Integer BANANA_LIKE_DYNAMIC=2;
//    //    收到第一个点赞 不处理
//    public static final Integer BANANA_FIRST_LIKE=3;
//    //    收到关注
//    public static final Integer BANANA_FOLLOW=4;


    BANANA_COMMENT_DYNAMIC(1, "comment_dynamic"),
    BANANA_LIKE_DYNAMIC(2, "like_dynamic"),
    BANANA_FIRST_LIKE(3, "first_like"),
    BANANA_FOLLOW(4, "follow"),
    BANANA_COMMENT_TIPOFF(5, "banana_comment_tipoff"),
    BANANA_DYNAMIC_TIPOFF(6, "banana_dynamic_tipoff"),
    CHALLENGE_SUCCESS(7, "challenge_success");





    private int type;
    private String typevalue;

    MQType(int type, String typevalue) {
        this.type = type;
        this.typevalue = typevalue;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypevalue() {
        return typevalue;
    }

    public void setTypevalue(String typevalue) {
        this.typevalue = typevalue;
    }



    }
