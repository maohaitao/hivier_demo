package com.bike.bananacard.common.cache.data;

import com.bike.bananacard.common.cache.LocalCacheMap;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/15
 * time: 下午12:09
 * description: 提供统一的缓存查询
 */
public class QueryCache {
    @SuppressWarnings({"unchecked"})
    public static <T> T get(String key) {
        return (T) LocalCacheMap.getInstance().get(key);
    }

    @SuppressWarnings({"unchecked"})
    public static <T> T get(String key, Integer id) {
        return (T) LocalCacheMap.getInstance().get(key + id);
    }
}
