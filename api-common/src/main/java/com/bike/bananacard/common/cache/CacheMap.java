package com.bike.bananacard.common.cache;

import java.util.Map;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/14
 * time: 下午7:06
 * description: 缓存接口
 */
public interface CacheMap {


    void put(String key, Object value);

    void putAll(Map<String, Object> objectMap);

    Object get(String key);

    void remove(String key);

    boolean isEmpty();
}
