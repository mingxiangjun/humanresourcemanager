package org.ming.humanresource.cache.service;

import java.io.Serializable;
import java.util.Map;

/**
 * @author MingXiangjun
 * @create 2017-12-17 13:58
 **/
public interface MessageDelegate {
    void handleMessage(String message);

    void handleMessage(Map message);

    void handleMessage(byte[] message);

    void handleMessage(Serializable message);

    // pass the channel/pattern as well
    void handleMessage(Serializable message, String channel);
}
