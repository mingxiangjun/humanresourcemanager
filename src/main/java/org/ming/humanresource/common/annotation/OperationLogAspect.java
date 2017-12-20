package org.ming.humanresource.common.annotation;

import antlr.StringUtils;
import net.sf.json.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.ming.humanresource.common.model.OperatorLog;
import org.ming.humanresource.common.util.CommonConstants;
import org.ming.humanresource.common.util.SpelParserUtil;
import org.ming.humanresource.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 操作日志切面类
 *
 * @author MingXiangjun
 * @create 2017-12-14 10:28
 */
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private JmsTemplate jmsTemplate;
    @AfterReturning(value = "@annotation(operLog)",returning = "result")
    public Object afterCompletion(JoinPoint joinPoint, OperationLogAnnotation operLog, Object result) throws Throwable {
        String targetLog = operLog.targetLog();
        OperatorLog sendLog = null;
        if (StringUtil.isNotEmpty(targetLog)){
            sendLog = getTargetLog(joinPoint,targetLog);
        }else{
            String operatorId = operLog.operateId();
            operatorId = getOperateId(joinPoint,operatorId);
            int operType = operLog.operatorType();
            StringBuffer appendDes = new StringBuffer();
            switch (operType){
                case CommonConstants.OPERTYPE_INSERT:
                    appendDes.append("插入主键为【"+operatorId+"】的对象！");
                    break;
                case CommonConstants.OPERTYPE_DELETE:
                    appendDes.append("删除主键为【"+operatorId+"】的对象！");
                    break;
                case CommonConstants.OPERTYPE_QUERY:
                    appendDes.append("查询主键为【"+operatorId+"】的对象！");
                    break;
                case CommonConstants.OPERTYPE_UPDATE:
                    appendDes.append("更新主键为【"+operatorId+"】的对象！");
                    break;
            }
            sendLog = new OperatorLog();
            sendLog.setTitle("系统操作日志：");
            sendLog.setContent(appendDes.toString());
        }
        final OperatorLog finalSendLog = sendLog;
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(JSONObject.fromObject(finalSendLog).toString());
            }
        });
        return result;
    }

    /**
     *  根据形参获取目标日志对象
     * @param log
     * @return
     */
    private OperatorLog getTargetLog(JoinPoint joinPoint,String log){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        return (OperatorLog) SpelParserUtil.getParamArg(log,methodSignature.getParameterNames(),joinPoint.getArgs());
    }

    /**
     * 根据占位符获取id值
     * @return
     */
    private String getOperateId(JoinPoint joinPoint,String log){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        return (String) SpelParserUtil.getParamArg(log,methodSignature.getParameterNames(),joinPoint.getArgs());
    }
}
