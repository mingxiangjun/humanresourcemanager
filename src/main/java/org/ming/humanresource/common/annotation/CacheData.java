package org.ming.humanresource.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheData {
    /**
     * 缓存名称
     * @return
     */
    String cacheName() default "";

    /**
     * 备用缓存名称
     * @return
     */
    String backCacheName() default "";

    /**
     * 是否需要添加同步锁
     * @return
     */
    boolean isNeedLock() default true;
}
