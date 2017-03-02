package com.bike.bananacard.common.cache.data;

import com.bike.bananacard.common.cache.CacheMap;
import com.bike.bananacard.common.cache.LocalCacheMap;
import com.bike.bananacard.common.jdbc.JdbcDao;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/14
 * time: 下午7:06
 * description: 缓存加载器
 */

public abstract class CacheLoader {
    private CacheMap localCache = LocalCacheMap.getInstance();

    protected abstract void loadData(JdbcDao jdbcDao);

    protected void set(String key, Object value) {
        localCache.put(key, value);
    }

}
