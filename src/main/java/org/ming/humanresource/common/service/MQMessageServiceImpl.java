package org.ming.humanresource.common.service;

import org.apache.activemq.ScheduledMessage;
import org.ming.humanresource.common.model.OperatorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 发送消息实现
 *
 * @author MingXiangjun
 * @create 2017-12-12 17:36
 */
public class MQMessageServiceImpl implements MQMessageService{
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息至消息中间件
     *
     * @param message
     */
    @Override
    public void sendMsg(final OperatorLog message) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage jmsMessage = session.createTextMessage(message.toString());
                jmsMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY,System.currentTimeMillis());
                return jmsMessage;
            }
        });
    }
}
