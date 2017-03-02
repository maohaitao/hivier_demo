package com.bike.bananacard.common.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/15
 * time: 上午11:08
 * description: 本地缓存方式
 */
public class LocalCacheMap implements CacheMap {
    private final Map<String, Object> cacheMap = new HashMap<String, Object>();

    private LocalCacheMap() {

    }

    public static LocalCacheMap getInstance() {
        return Singleton.instance;
    }

    @Override
    public void put(String key, Object value) {
        cacheMap.put(key, value);
    }

    @Override
    public void putAll(Map<String, Object> objectMap) {
        cacheMap.putAll(objectMap);
    }

    @Override
    public Object get(String key) {
        return cacheMap.get(key);
    }

    @Override
    public void remove(String key) {
        cacheMap.remove(key);
    }

    @Override
    public boolean isEmpty() {
        return cacheMap.isEmpty();
    }

    private static class Singleton {
        private static final LocalCacheMap instance = new LocalCacheMap();
    }
}
