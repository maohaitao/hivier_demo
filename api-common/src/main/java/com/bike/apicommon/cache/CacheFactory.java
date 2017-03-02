package com.bike.apicommon.cache;

import com.sf.common.log.LogService;

/**
 * @author hesin
 * @Created with： com.qy.cache
 * @Des: 缓存工厂类
 * @date 2015/9/11
 */
public class CacheFactory {
    private static CacheService service;

    public static CacheService createCacheService(Integer proType) {
        switch (proType) {
            case 1:
                service = createJVM();
                break;
            case 2:
                service = createRedis();
                break;
            default:
                return service = createJVM();
        }
        return service;
    }

    private static CacheService createCacheService(Class c) {
        try {
            service = (CacheService) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            LogService.error("CacheService 创建失败:", e);
            return null;
        }
        return service;
    }

    private static CacheService createJVM() {
        return createCacheService(JVMCacheService.class);
    }

    private static CacheService createRedis() {
        return createCacheService(RedisCacheService.class);
    }

}
