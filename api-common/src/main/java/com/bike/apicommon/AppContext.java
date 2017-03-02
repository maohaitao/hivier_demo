package com.bike.apicommon;

import com.bike.bananacard.common.tools.PropertiesUtils;
import com.sf.common.reflection.property.PropertiesUtil;

/**
 * @ClassName: AppContext
 * @Des: 配置上下文
 */
public final class AppContext {

    public static boolean IS_STARTED = true;
    public static boolean IS_DEBUG = false;

    // 游客 1 是 0 否
    public static String VISITOR_YES="1";
    public static String VISITOR_NO="0";

    // 状态 1 正常 0 下下
    public static String STATUS_YES = "1";
    public static String STATUS_NO = "0";

    // 0号码 1 微信 2 微博 3 QQ 4试用 5小米
    public static int OAUTH_XIAOMI=5;
    public static int OAUTH_VISITOR=4;
    public static int OAUTH_QQ=3;
    public static int OAUTH_WEIBO=2;
    public static int OAUTH_WECHAT=1;
    public static int OAUTH_PHONE=0;
//    public static int OAUTH_FALSE=21; //虚拟用户

    // 短信接口配置
    public static String SMS_URL = PropertiesUtil.getValue("sms_url");// 短信接口URL
    public static String SMS_UN = PropertiesUtil.getValue("sms_un");// 短信接入用户
    public static String SMS_PW = PropertiesUtil.getValue("sms_pw");// 短信接入码
    public static String SMS_VERCODE = PropertiesUtil.getValue("sms_vercode");// 短信验证码内容
    public static String ISDEBUG = PropertiesUtil.getValue("IS_DEBUG");// 短信验证码内容
    public static String REGISTER_VERCODE = "register_code_";
    public static String FUNDPW_VERCODE = "fundpw_code_";

    static {
        if (ISDEBUG.equals("1")) {
            IS_DEBUG = true;
        }
    }

    //打开Android双入口升级推送
    public final static int UPGRADE_STATUS_OPEN = 1;
    //关闭Android双入口升级推送
    public final static int  UPGRADE_STATUS_CLOSE = 0;

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
    //public static String BASE_URL = PropertiesUtils.getValue("rsync.url");

    //体重卡ID
    public static Integer WEIGHT_CARDID=50;

    // 系统短IP，如 1.32
    //	public static final String SYS_SHORT_IP = T.getShortLocalIpAddress();

    //打卡动态相关
    public static final int IS_DYNAMIC_THUMBUP=1;
    public static final int IS_USER_THUMBUP=2;
    //点赞 取消点赞
    public static final int ADD_DYNAMIC_THUMBUP=0;
    public static final int DEL_DYNAMIC_THUMBUP=1;
    //查询动态列表类型
    public static final int SELFS_LIST = 1;//本人列表
    public static final int OTHER_LIST = 2;//他人列表
    public static final int RECOM_LIST = 3;//关注列表
    public static final int FREND_LIST = 4;//关注列表
    //点赞缓存
    public static final String  WHO_THUMBUP_DYNAMIC="who_thumbup_dynamic";//动态点赞
    public static final String  DYNAMIC_THUMBUP_COUNT="dynamic_thumbup_count";//动态点赞总数
    public static final String  THUMBUP_COUNT_NEW="thumbup_count_new";//最新点赞总数
    public static final String  COMMENT_COUNT_NEW="comment_count_new";//用户得到的评论数
    public static final String  PUBLIST_TIME="publish_time";//发布时间
    public static final String  IMAGE_URL="image_url";//发布动态图片
    public static final String  KEY_MAP="key_map";
    //点赞缓存
    public static final String  DYNAMIC_COMMENT_COUNT="dynamic_comment_count";//动态评论
    //举报缓存
    public static final String  TIP_OFF="tip_off";
    //上次查看到的最新动态的时间
    public static final String  NEW_DYNAMIC_TIME="new_dynamic_time";
    //最近动态图片列表
    public static final String  DYNAMIC_IMAGE_URL="dynamic_image_url";
    //个人缓存动态图数量
    public static final int IMAGE_RUL_NUM=8;
    public static final int USER_IMAGE_RUL_NUM=3;

    //消息 开0 关1 好友2
    public static final int OPEN=0;
    public static final int CLOSE=1;
    public static final int FREND=2;

    public static final int DYNAMIC_TIP=1;
    public static final int COMMENT_TIP=2;

    //消息中心上次阅读时间
    public static final String MESSAGE_CENTER_READ_TIME="message_center_read_time";

    //新消息状态
    public final static String NEW_YES = "1";
    //非新消息状态
    public final static String NEW_NO = "0";
    //已读状态
    public final static String READED_YES = "1";
    //未读状态
    public final static String READED_NO = "0";
    public final static String NOT_READ_CACHE = "not_read";
    //点赞时间戳
    public static final String THUMBUP_START_TIME = "thumbup_start_time";
    public static final String THUMBUP_END_TIME = "thumbup_end_time";
    //评论时间戳
    public static final String COMMENT_START_TIME = "comment_start_time";
    public static final String COMMENT_END_TIME = "comment_end_time";

    //运动时间线增量数
    public static final int SPORT_TIME_LINE_NUM=500;

    //最新的查询，无客户端缓存
    public static final int NEW_SEARCH_YES=1;
    public static final int NEW_SEARCH_NO=0;

    //小于类型
    public static final int LESS_THAN=1;
    //大于类型
    public static final int MORE_THAN=2;

    //是否禁止
    public static final int FB_YES=1;
    public static final int FB_NO=0;

    //动态最新首页列表
    public final static int NEW_LIST_YES = 1;
    //非动态最新首页列表
    public final static int NEW_LIST_NO = 0;

    //点赞类型
    public static final int THUMBUP_DYNAMIC=1;
    public static final int THUMBUP_USER=2;

    //是否查询推荐用户图片缓存
    public static final int Recommend_YES=1;
    public static final int Recommend_NO=0;

    //是否等於
    public static final int EQUAL_YES=1;
    public static final int EQUAL_NO=0;

    //是否新消息
    public static final int NEW_DATA_YES=1;
    public static final int NEW_DATA_NO=2;

    //是否发布
    public static final int PUBLISH_YES=1;
    public static final int PUBLISH_NO=0;

    //是否涉黃
    public static final String YELLOW_YES="1";
    public static final String YELLOW_NO="0";

    //是否默认图
    public static final int DEFAULT_IMAGE_NO=1;
    public static final int DEFAULT_IMAGE_YES=2;

    //是否公开
    public static final int OPEN_YES=0;
    public static final int OPEN_NO=1;//私密

    //是否新增
    public static final int ADD_YES=1;
    public static final int ADD_NO=0;

    //挑战列表类型
    public static final int BANNER_CHALLENGES=1;//banner页挑战列表（未开始或进行中的）
    public static final int PAGE_CHALLENGES=2;//挑战详情页挑战列表（所有的）

    //参与挑战标识
    public static final String JOIN_CHALLENGE = "join_challenge";
    public static final String JOIN_CHALLENGE_COUNT_STR = "join_challenge_count_str";

    //参与/退出挑战
    public static final int JOIN_CHALLENGES=0;//参与挑战
    public static final int QUIT_CHALLENGES=1;//退出挑战

    //用户挑战状态
    public static final int CHALLENGE_STATUS_JOIN_NO=0;//未挑战
    public static final int CHALLENGE_STATUS_JOIN_YES=1;//参与挑战
    public static final int CHALLENGE_STATUS_GOING=2;//进行中
    public static final int CHALLENGE_STATUS_SUCCESS=3;//成功
    public static final int CHALLENGE_STATUS_FAILD=4;//失败

    //参与挑战总数、完成挑战总数
    public static final int JOIN_CHALLENGE_COUNT=1;//参与挑战数
    public static final int FINISH_CHALLENGE_COUNT=2;//完成挑战数

    //挑战是否过期
    public static final int CHALLENGE_OVERTIME_NO=0;//否
    public static final int CHALLENGE_OVERTIME_YES=1;//是

    //所有挑战、进行中挑战
    public static final int ALL_USER_CHALLENGES=1;//参与挑战数
    public static final int CUR_USER_CHALLENGES=2;//完成挑战数

    public static final String TOTAL_CARD = "challenge_total_card";
    public static final String TOTAL_WALK = "challenge_total_walk";
    public static final String CONTINIU_CARD = "challenge_continue_card_date";
    public static final String CONTINIU_WALK = "challenge_continue_walk_date";
    public static final int CHALLENGE_SUCCESS = 2;
    public static final int REQUEST_ERROR = 0;
    public static final int REQUEST_SUCCESS = 1;

    public static final int TARGET_SUCCESS_NO=0;//否
    public static final int TARGET_SUCCESS_YES=1;//是

    //皮肤类型 1成就皮肤、 2 挑战皮肤、 0 到达城市
    public static final int THEME_MAP=0;
    public static final int THEME_ACHIEVE=1;
    public static final int THEME_CHALLENGE=2;
    // 主题 是否解锁 // 0未 1解锁 TODO
    public static final int THEME_CLOCK=0;
    public static final int THEME_UNCLOCK=1;
}
