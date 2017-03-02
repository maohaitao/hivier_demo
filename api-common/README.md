
Redis存储:
--用户信息
accountId   --->  token
token       --->  Obj[userInfo]
accountId account_route --->  Obj[userRoute]

--关注与粉丝
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

