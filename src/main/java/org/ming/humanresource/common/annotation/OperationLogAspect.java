package org.ming.humanresource.common.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

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

    @AfterReturning(value = "@annotation(operationLogAnnotation)",returning = "result")
    public Object afterCompletion(JoinPoint joinPoint, OperationLogAnnotation operationLogAnnotation,Object result) throws Throwable {
        Object[] args= joinPoint.getArgs();
        for (Object param:args){
            System.out.println(param.toString());
        }
        return result;
    }
}
