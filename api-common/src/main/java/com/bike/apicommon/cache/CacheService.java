package com.bike.apicommon.cache;

import java.util.List;
import java.util.Map;

/**
 * @author hesin
 * @Created with： com.qy.cache
 * @Des: 緩存的接口
 * @date 2015/9/11
 */
public interface CacheService<T> {
    public static String GET_KEY = "getId";
    public static String modekey = "#"; //的分隔符号

    public boolean putHash(List<T> list, String key);

    public T getHash(String key, String field, Class<T> cla);

    public Map<String, Object> getHash(String key, String field);

    public boolean setHash(String key, String field, T b);

    public boolean rmHash(String key, String field);

    public T get(String key, String id, Class<T> cla);

    public boolean set(T t, String key, int epri);

    public boolean del(String id, String key);

    public boolean del(String key);

    public boolean set(String key, Object o, int expr);

    public Object get(String key, Class type);

    public Map<String, Object> getMapStr();

    public boolean setString(String key, String o, int expr);

    public Object getString(String key);
}
