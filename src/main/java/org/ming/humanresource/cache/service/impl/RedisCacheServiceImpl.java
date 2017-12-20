package org.ming.humanresource.cache.service.impl;

import org.ming.humanresource.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheElement;
import org.springframework.data.redis.cache.RedisCacheKey;

public class RedisCacheServiceImpl implements CacheService {
    @Autowired
    private CacheManager cacheManager;
    @Override
    public <V> V cacheResult(String key, String cacheName) {
        return (V) cacheManager.getCache(cacheName).get(key);
    }

    @Override
    public void cacheRemove(String key, String cacheName) {
        cacheManager.getCache(cacheName).evict(key);
    }

    @Override
    public <V> void cachePut(String key, V value, String cacheName) {
        cacheManager.getCache(cacheName).put(key,value);
    }

    /**
     * 存入数据至缓存，且设置过期时间
     *
     * @param key
     * @param value
     * @param cacheName
     * @param timeToLive
     */
    @Override
    public <V> void cachePut(String key, V value, String cacheName, long timeToLive) {
        RedisCacheElement element = new RedisCacheElement(new RedisCacheKey(key),value);
        element.setTimeToLive(timeToLive);
        RedisCache cache = (RedisCache) cacheManager.getCache(cacheName);
        cache.put(element);
    }
}
