package com.bike.apicommon.cache;

import com.sf.common.log.LogService;
import com.sf.common.util.JsonUtil;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author hesinoogs
 * @Created with： com.pc.buyer.cache
 * @Des: Redis业务处理缓存
 * @date 2015/8/18
 */
public class RedisCacheService<T> implements CacheService<T> {

    public boolean putHash(List<T> list, String key) {
        if (list != null) {
            for (T b : list) {
                if (b == null) {
                    continue;
                }
                Method methodGet = null;
                try {
                    methodGet = b.getClass().getDeclaredMethod(GET_KEY);
                    if (methodGet == null) {
                        continue;
                    }
                    Object object = methodGet.invoke(b);
                    long re = RedisService.getJedisCache().hset(key, object + "", JsonUtil.toJsonTreeSequence(b).toString());
                } catch (Exception e) {
                    LogService.error("putHash error:", e);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public T getHash(String key, String field, Class<T> cla) {
        if (key != null && field != null) {
            String re = RedisService.getJedisCache().hget(key, field);
            if (re != null) {
                return JsonUtil.parse(re, cla);
            } else
                return null;
        } else {
            return null;
        }
    }

    @Override
    public Map<String, Object> getHash(String key, String field) {
        return null;
    }

    public boolean setHash(String key, String field, T b) {
        if (b != null) {
            if (b == null) {
                return false;
            }
            Method methodGet = null;
            try {
                methodGet = b.getClass().getDeclaredMethod(GET_KEY);
                if (methodGet == null) {
                    return false;
                }
                Object object = methodGet.invoke(b);
                RedisService.getJedisCache().hset(key, object + "", JsonUtil.toJsonTreeSequence(b).toString());
            } catch (Exception e) {
                LogService.error(" putHash error:", e);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean rmHash(String key, String field) {
        if (key != null && field != null) {
            RedisService.getJedisCache().hdel(key, field + "");
            return true;
        } else {
            return false;
        }
    }


    public T get(String key, String id, Class<T> cla) {
        if (id == null || "".equals(id.trim()) || key == null || "".equals(key.trim())) {
            return null;
        }
        String re = RedisService.getJedisCache().get(key + modekey + id);
        if (re != null) {
            return JsonUtil.parse(re, cla);
        } else
            return null;
    }

    public boolean set(T t, String key, int epri) {
        if (t != null) {
            Method methodGet = null;
            try {
                methodGet = t.getClass().getDeclaredMethod(GET_KEY);
                if (methodGet == null) {
                    return false;
                }
                Object object = methodGet.invoke(t);
                RedisService.set(key + modekey + object, JsonUtil.toJsonTreeSequence(t).toString(), epri);
            } catch (Exception e) {
                LogService.error("set error:", e);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean del(String id, String key) {
        if (id == null || "".equals(id.trim()) || key == null || "".equals(key.trim())) {
            return false;
        }
        long re = RedisService.getJedisCache().del(key + modekey + id);
        return re > 0 ? true : false;
    }

    @Override
    public boolean del(String key) {
        if (key == null || "".equals(key.trim())) {
            return false;
        }
        long re = RedisService.getJedisCache().del(key);
        return re > 0 ? true : false;
    }

    @Override
    public boolean set(String key, Object o, int expr) {
        return RedisService.set(key, o, expr);
    }

    @Override
    public Object get(String key, Class type) {
        return RedisService.get(key, type);
    }

    @Override
    public Map<String, Object> getMapStr() {
        return null;
    }


    public boolean setString(String key, String o, int expr) {
        boolean flag = RedisService.setString(key, o, expr);
        return flag;
    }

    public String getString(String key) {
        String re = (String) RedisService.getString(key);
        return re;
    }

}