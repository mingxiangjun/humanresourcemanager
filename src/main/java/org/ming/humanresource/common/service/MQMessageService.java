package org.ming.humanresource.common.service;


import org.ming.humanresource.common.model.OperatorLog;

/**
 * 消息中间件发送Service
 * @author MingXiangjun
 * @create 2017-12-12 17:31
 **/
public interface MQMessageService {
    /**
     *
     * @param message
     */
    public void sendMsg(OperatorLog message);
}
