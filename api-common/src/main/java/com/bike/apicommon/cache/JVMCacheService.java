package com.bike.apicommon.cache;

import com.google.gson.Gson;
import com.sf.common.log.LogService;
import com.sf.common.util.JsonUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author hesin
 * @Created with： com.qy.cache
 * @Des: Jvm 缓存
 * @date 2015/9/11
 */
public class JVMCacheService<T> implements CacheService<T> {
    private static ConcurrentMap<String, Object> JVMstrcache = new ConcurrentHashMap<>();//jvm缓存
    private static ConcurrentMap<String, Map<String, Object>> JVMmapcache = new ConcurrentHashMap<>();//jvm缓存

    @Override
    public boolean putHash(List<T> list, String key) {
        Map<String, Object> map = new HashMap<>();
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
                    map.put(object + "", JsonUtil.toJsonTreeSequence(b));
                } catch (Exception e) {
                    LogService.error("putHash error:", e);
                }
            }
            JVMmapcache.put(key, map);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T getHash(String key, String field, Class<T> cla) {
        if (key != null && field != null) {
            Map<String, Object> map = JVMmapcache.get(key);
            Object re = map != null ? map.get(field) + "" : null;
            if (re != null) {
                return JsonUtil.parse(re.toString(), cla);
            } else
                return null;
        } else {
            return null;
        }
    }

    @Override
    public Map<String, Object> getHash(String key, String field) {
        if (key != null) {
            Map<String, Object> map = JVMmapcache.get(key);
            Gson gson = new Gson();
//            List<Object> list = gson.fromJson(jsondata, Object.);
            return map;
        } else {
            return null;
        }
    }

    @Override
    public boolean setHash(String key, String field, T b) {
        Map<String, Object> map = JVMmapcache.get(key);
        if (map == null) {
            map = new HashMap<>();
        }
        if (b != null) {
            Method methodGet = null;
            try {
                methodGet = b.getClass().getDeclaredMethod(GET_KEY);
                if (methodGet == null) {
                    return false;
                }
                Object object = methodGet.invoke(b);
                map.put(object + "", JsonUtil.toJsonTreeSequence(b));
            } catch (Exception e) {
                LogService.error("setHash error:", e);
            }
            JVMmapcache.put(key, map);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean rmHash(String key, String field) {
        if (key != null && field != null) {
            Map<String, Object> map = JVMmapcache.get(key);
            map.remove(field);
            return true;
        } else {
            return true;
        }
    }

    @Override
    public T get(String key, String id, Class<T> cla) {
        if (id == null || "".equals(id.trim()) || key == null || "".equals(key.trim())) {
            return null;
        }
        Object re = JVMstrcache.get(key + modekey + id);
        if (re != null) {
            return JsonUtil.parse(re.toString(), cla);
        } else
            return null;
    }

    @Override
    public boolean set(T t, String key, int epri) {
        if (t != null) {
            Method methodGet = null;
            try {
                methodGet = t.getClass().getDeclaredMethod(GET_KEY);
                if (methodGet == null) {
                    return false;
                }
                Object object = methodGet.invoke(t);
                JVMstrcache.put(key + modekey + object, JsonUtil.toJsonTreeSequence(t));
            } catch (Exception e) {
                LogService.error("set error:", e);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean del(String id, String key) {
        if (id == null || "".equals(id.trim()) || key == null || "".equals(key.trim())) {
            return false;
        }
        JVMstrcache.remove(key + modekey + id);
        return true;
    }

    @Override
    public boolean del(String key) {
        if (key == null || "".equals(key.trim())) {
            return false;
        }
        JVMstrcache.remove(key);
        return true;
    }

    @Override
    public boolean set(String key, Object o, int expr) {
        JVMstrcache.put(key, JsonUtil.toJsonTreeSequence(o));
        return true;
    }

    @Override
    public Object get(String key, Class type) {
        Object resultobj = null;
        Object re = JVMstrcache.get(key);
        if (re != null) {
            if (type == null) {
                resultobj = JsonUtil.parseEle(re.toString());
            } else {
                resultobj = JsonUtil.parse(re.toString(), type);
            }
        }
        return resultobj;
    }

    @Override
    public Map<String, Object> getMapStr() {
        return JVMstrcache;
    }

    @Override
    public boolean setString(String key, String o, int expr) {
        return false;
    }

    @Override
    public Object getString(String key) {
        return null;
    }

}
