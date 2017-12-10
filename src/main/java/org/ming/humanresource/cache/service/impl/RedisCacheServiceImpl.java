package org.ming.humanresource.cache.service.impl;

import org.ming.humanresource.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

public class RedisCacheServiceImpl implements CacheService {
    @Autowired
    private CacheManager cacheManager;
    @Override
    public <V> V cacheResult(String key, String cacheName) {
        ValueWrapper valueWrapper = cacheManager.getCache(cacheName).get(key);
        return null;
    }

    @Override
    public void cacheRemove(String key, String cacheName) {
        cacheManager.getCache(cacheName).evict(key);
    }

    @Override
    public <V> void cachePut(String key, V value, String cacheName) {
        cacheManager.getCache(cacheName).put(key,value);
    }
}
