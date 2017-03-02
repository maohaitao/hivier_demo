package com.bike.bananacard.common.constant;

import com.bike.bananacard.common.tools.PropertiesUtils;

/**
 * 描述：上下文常量
 * 创建时间：15/4/10
 * 作者：yanghui
 */
public class AppContext {
    //删除状态
    public final static int DEL_YES = 1;
    //非删除状态
    public final static int DEL_NO = 0;

    public static final String PRODUCES = "application/json;charset=UTF-8";

    //是否为每日卡-是
    public static final int IS_DAY_CARD_YES = 1;
    //是否为每日卡-否
    public static final int IS_DAY_CARD_NO = 0;

    //课程状态
    public static final int COURSE_STATUS_RUN = 2;
    // 是否常用卡片:1.是 0否
    public static final int IS_COMMON_CARD_YES = 1;
    public static final int IS_COMMON_CARD_NO = 0;
    // 卡片状态 0 新建 1 正常 2下架
    public static final int IS_CARD_STATUS_NEW = 0;
    public static final int IS_CARD_STATUS_UP = 1;
    public static final int IS_CARD_STATUS_WODN = 2;
    // '默认常用卡片 1.是 0否'; default_common
    public static final int IS_DEFAULT_COMMON_YES = 1;
    public static final int IS_DEFAULT_COMMON_NO = 0;
    //是否新用户
    public static final int IS_NEWUSER_YES = 1;
    public static final int IS_NEWUSER_NO = 0;
    public static final int DEFINTION_ID_START = 10000;
    //异步请求前缀路径
    public static String BASE_URL = PropertiesUtils.getValue("rsync.url");

    //体重卡ID
    public static Integer WEIGHT_CARDID=50;


    // 压缩处理 解压处理
    public static String GZIP="1";
    public static String UNGZIP="1";

}
