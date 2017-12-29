package org.ming.humanresource.cache.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.ming.humanresource.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheElement;
import org.springframework.data.redis.cache.RedisCacheKey;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

@Service(value = "cacheService")
public class RedisCacheServiceImpl implements CacheService {

    @Value("${redis.isUsePrefix}")
    public Boolean isUsePrefix=false;

    @Autowired
    private CacheManager cacheManager;
    @Override
    public <V> V cacheResult(String key, String cacheName) {
        ValueWrapper valueWrapper = cacheManager.getCache(cacheName).get(key);
        return valueWrapper!=null? (V) valueWrapper.get() :null;
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
        RedisCacheKey redisCacheKey = new RedisCacheKey(key.getBytes());
        if (isUsePrefix){
            RedisSerializer serializer = new StringRedisSerializer();
            byte[] prefix = serializer.serialize(cacheName.concat(":"));
            redisCacheKey.usePrefix(prefix);
        }
        RedisCacheElement element = new RedisCacheElement(redisCacheKey,value);
        element.setTimeToLive(timeToLive);
        RedisCache cache = (RedisCache) cacheManager.getCache(cacheName);
        cache.put(element);
    }
}
