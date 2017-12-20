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
    //操作类型：创建，查询，删除，更新
    int operatorType() default  0;
    //操作数据id
    String operateId() default "";
    //日志信息
    String targetLog() default  "";
}
