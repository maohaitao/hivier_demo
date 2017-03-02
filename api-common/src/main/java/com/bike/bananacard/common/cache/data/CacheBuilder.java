package com.bike.bananacard.common.cache.data;

import com.bike.bananacard.common.tools.PropertiesUtils;
import com.bike.bananacard.common.jdbc.JdbcDao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/20
 * time: 下午2:29
 * description: 缓存构造器
 */
public class CacheBuilder {
    //加载缓存延迟时间
    private final static Long FIXED_DELAY_CACHE = PropertiesUtils.getValue("task.fixed.delay", 1000 * 60 * 24L);
    private static final Map<String, CacheLoader> CACHE_LOADER = new HashMap<String, CacheLoader>();
    private static Long LAST_LOAD_TIME;

    public CacheBuilder append(CacheLoader cacheLoader) {
        String key = cacheLoader.getClass().getName();
        if (!CACHE_LOADER.containsKey(key)) {
            CACHE_LOADER.put(key, cacheLoader);
        }
        return this;
    }

    public void loadData(JdbcDao jdbcDao) {
        if (jdbcDao == null) {
            return;
        }
        if (check()) {
            return;
        }
        for (Map.Entry<String, CacheLoader> entry : CACHE_LOADER.entrySet()) {
            entry.getValue().loadData(jdbcDao);
        }
    }

    private boolean check() {
        boolean result = false;
        Date now = new Date();
        if (LAST_LOAD_TIME == null) {
            LAST_LOAD_TIME = now.getTime();
        }
        Long diversityTime = now.getTime() - LAST_LOAD_TIME;
        if (diversityTime == 0) {
            LAST_LOAD_TIME = now.getTime();
            result = true;
        }
        if (diversityTime >= FIXED_DELAY_CACHE) {
            LAST_LOAD_TIME = now.getTime();
            result = true;
        }
        return !result;

    }
}
