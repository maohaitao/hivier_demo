package com.bike.apicommon.cache;

import com.sf.common.log.LogService;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.JsonUtil;
import com.sf.redis.JedisCache;

/**
 * @author hesin
 * @Created with： com.pc.buyer.cache
 * @Des: redis处理
 * @date 2015/8/25
 */
public class RedisService {
    private static int expri = 1 * 24 * 60 * 60; // 默认有效期 1天

    private static JedisCache cache = null;

    public static JedisCache getJedisCache() {
        try {
            if (cache == null) {
                cache = new JedisCache();
            }
        } catch (Exception e) {
            LogService.error("getJedisCache  error:", e);
        }
        return cache;
    }

//    private static SingleServerJedisCache cache=null;
//    //静态工厂方法
//    public static SingleServerJedisCache getJedisCache() {
//        if (cache == null) {
//            cache = new SingleServerJedisCache();
//        }
//        return cache;
//    }

    public static boolean set(String key, Object o, int expr) {
        if (expr <= 0) {
            expr = expri;
        }
        boolean flag = getJedisCache().setex(key, expr, JsonUtil.toJsonTree(o).toString());
        return flag;
    }


    public static boolean setString(String key, String o, int expr) {
        if (expr <= 0) {
            expr = expri;
        }
        boolean flag = getJedisCache().setex(key, expr, o);
        return flag;
    }

    public static Object getString(String key) {
        String re = getJedisCache().get(key);
        return re;
    }


    public static Object get(String key, Class type) {
        Object resultobj = null;
        String re = getJedisCache().get(key);
        if (re != null) {
            if (type == null) {
                resultobj = JsonUtil.parseEle(re);
            } else {
                resultobj = JsonUtil.parse(re, type);
            }
        }
        return resultobj;
    }


    public static boolean hset(String key, String field, Object o) {
        long re = getJedisCache().hset(key, field, JsonUtil.toJsonTree(o).getAsString());
        return re > 0 ? true : false;
    }

    public static long ttl(String key) {
        if (CommonUtil.isNull(key)) {
            return 0;
        } else {
            return getJedisCache().ttl(key);
        }
    }

    public static void main(String[] args) {
        System.out.println("end!");
        String key = "test";
        String value = "test111";
        RedisService redisService = new RedisService();
        redisService.setString(key, value, 345340);
        System.out.println(RedisService.getString(key));
    }
}
