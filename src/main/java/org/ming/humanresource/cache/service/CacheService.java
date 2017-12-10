package org.ming.humanresource.cache.service;
/**
 * CacheService.java
 * @author MingXiangjun
 * @create 2017/12/10-11:55
 */
public interface CacheService {
    /**
     * 根据key从缓存中获取数据
     * @param key
     * @param cacheName
     * @param <V>
     * @return
     */
    public <V> V cacheResult(String key, String cacheName);

    /**
     * 从缓存中删除数据
     * @param key
     * @param cacheName
     */
    public void cacheRemove(String key, String cacheName);

    /**
     * 存入数据到缓存
     * @param key
     * @param value
     * @param cacheName
     * @param <V>
     */
    public <V> void cachePut(String key, V value, String cacheName);
}
