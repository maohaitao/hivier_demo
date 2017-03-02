package com.bike.apicommon;

import com.bike.dynamic.model.MessagePushSetting;
import com.bike.route.model.TAccountRoute;
import com.bike.route.model.TRouteLevel;
import com.bike.route.model.TRouteMap;
import com.bike.route.model.TRouteProps;
import com.bike.apicommon.cache.CacheFactory;
import com.bike.apicommon.cache.CacheService;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Des: 缓存配置上下文
 */
public final class CacheModel {

    // cache key
    public static String CITY_KEY = "city";// 城市列表
    public static String LEVEL_KEY = "level";// 等级
    public static String ACCOUNT_ROUTE = "account_route";// 用户路线
    public static String ROUTE_PROPS = "route_props";// 道具
    public static String MESSAGE_SETTING = "message_setting";//
    public static int EXPRI = 60 * 60 * 8;// 有效期8小时


    public static CacheService cacheService = CacheFactory.createCacheService(1);
    public static CacheService rediscacheService = CacheFactory.createCacheService(2);

    public static boolean putCityMapCache(List<TRouteMap> tRouteMaps) {
        cacheService.putHash(tRouteMaps, CITY_KEY);
        return true;
    }

    public static Map<String, TRouteMap> getCityMapCache() {
        return cacheService.getHash(CITY_KEY, "");
    }

    public static TRouteMap getCityMapCache(String id) {
        return (TRouteMap) cacheService.getHash(CITY_KEY, id, TRouteMap.class);
    }

    public static boolean putLevelCache(List<TRouteLevel> tRouteMaps) {
        cacheService.putHash(tRouteMaps, LEVEL_KEY);
        return true;
    }

    public static Map<String, TRouteLevel> getLevelCache() {
        return cacheService.getHash(LEVEL_KEY, "");
    }

    public static TRouteLevel getLevelCache(String id) {
        return (TRouteLevel) cacheService.getHash(LEVEL_KEY, id, TRouteLevel.class);
    }

    public static boolean putLevelCache(TRouteLevel level) {
        return cacheService.setHash(LEVEL_KEY, "", level);
    }

    public static boolean putTAccountRoute(TAccountRoute tAccountRoute) {
        if (tAccountRoute == null) {
            return false;
        } else {
            return rediscacheService.set(tAccountRoute.getAccountId() + ACCOUNT_ROUTE, tAccountRoute, EXPRI);
        }
    }

    public static TAccountRoute getTAccountRoute(String accountId) {
        if (!CommonUtil.isNull(accountId)) {
            return null;
        } else {
            return (TAccountRoute) rediscacheService.get(accountId + ACCOUNT_ROUTE, TAccountRoute.class);
        }
    }

    public static boolean putMessagePushSetting(MessagePushSetting messagePushSetting){
        if (messagePushSetting == null) {
            return false;
        } else {
            return rediscacheService.set(messagePushSetting.getAccountId() + MESSAGE_SETTING, messagePushSetting, EXPRI);
        }
    }

    public static boolean removeMessagePushSetting(MessagePushSetting messagePushSetting){
        if (messagePushSetting == null) {
            return false;
        }else {
            return rediscacheService.del(messagePushSetting.getAccountId() + MESSAGE_SETTING);
        }
    }

    public static MessagePushSetting getMessagePushSetting(String accountId){
        if (CommonUtil.isNull(accountId)) {
            return null;
        } else {
            return (MessagePushSetting) rediscacheService.get(accountId + MESSAGE_SETTING, MessagePushSetting.class);
        }
    }

    public static boolean putRoutePropsCache(List<TRouteProps> routePropses) {
        cacheService.putHash(routePropses, ROUTE_PROPS);
        return true;
    }

    public static Map<String, Object> getRoutePropsCache() {
        Map<String, Object> result = checkMap(cacheService.getHash(ROUTE_PROPS, ""), TRouteProps.class);
        return result;
    }

    public static TRouteProps getRoutePropsCache(String id) {
        return (TRouteProps) cacheService.getHash(ROUTE_PROPS, id, TRouteProps.class);
    }

    private static Map<String, Object> checkMap(Map<String, Object> map, Class c) {
        Map<String, Object> result = new HashMap<>();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                result.put(entry.getKey(), JsonUtil.fromJson(JsonUtil.parse(entry.getValue().toString()), c));
            }
        }
        return result;
    }
}
