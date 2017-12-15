package org.ming.humanresource.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解发送操作日志 OperationLogAnnotation.java
 * @author MingXiangjun
 * @create 2017/12/13-12:01
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLogAnnotation {
    //操作类型
    int operatorType() default  0;
    //操作结果
    int resultType() default 0;
}
