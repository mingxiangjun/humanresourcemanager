package org.ming.humanresource.cache.service.impl;

import org.ming.humanresource.cache.service.MessageDelegate;

import java.io.Serializable;
import java.util.Map;

/**
 * @author MingXiangjun
 * @create 2017-12-17 14:00
 */
public class RedisKeyExpiredMessageDelegate implements MessageDelegate{
    @Override
    public void handleMessage(String message) {
        System.out.println(message);
        System.out.println("-------------RedisKeyExpiredMessageDelegate:handleMessage(String message)-------------");
    }

    @Override
    public void handleMessage(Map message) {
        System.out.println("-------------RedisKeyExpiredMessageDelegate:handleMessage(Map message)-------------");
    }

    @Override
    public void handleMessage(byte[] message) {
        System.out.println("-------------RedisKeyExpiredMessageDelegate:handleMessage(byte[] message)-------------");
    }

    @Override
    public void handleMessage(Serializable message) {
        System.out.println("-------------RedisKeyExpiredMessageDelegate:handleMessage(Serializable message)-------------");
    }

    @Override
    public void handleMessage(Serializable message, String channel) {
        System.out.println("-------------RedisKeyExpiredMessageDelegate:handleMessage(Serializable message, String channel)-------------");
    }
}
