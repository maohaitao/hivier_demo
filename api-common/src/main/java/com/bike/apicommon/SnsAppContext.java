package com.bike.apicommon;

/**
 * Created by a700 on 16/8/8.
 * SNS 配置上下文
 */
public final class SnsAppContext {

    public static Integer Page_size = 20;

    /**
     * 被关注 redis缓存Key
     */
    public static String KEY_FANS_COUNT = "_fans";

    /**
     * 新增关注的粉丝列表
     */
    public static String KEY_FANS_NEW_LIST = "_fans_new_list";
    public static String KEY_FANS_NEW_LIST_COUNT = "_fans_newlist_count";

    /**
     * 用户关注用户
     */
    public static String FOLLOW="_follow_";

    /**
     * 关注 redis缓存Key
     */
    public static String KEY_FOLLOW_COUNT = "_follow";

    /**
     * 用户点赞的总数
     */
    public static String KEY_LIKE_COUNT = "_like";

    /**
     * 新点赞的总数
     */
    public static String KEY_LIKE_NEW_LIST_COUNT = "_like_newlist_count";

    /**
     * 当天只能点赞一次
     */
    public static String KEY_LIKE_TODAY = "_liketo_";

    /**
     * 关注通知推送
     */
    public static Integer SMS_TYPE_FOLLOW = 2;

    /**
     * 点赞通知推送
     */
    public static Integer SMS_TYPE_LIKE = 1;

}
