package org.ming.humanresource.common.annotation;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.util.Base64;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.ming.humanresource.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 缓存注解切面类
 *
 * @author MingXiangjun
 * @create 2017-12-26 21:30
 */
@Aspect
@Component
public class CacheDataAspect {
    private static Logger logger = Logger.getLogger(CacheDataAspect.class);

    @Autowired
    private CacheService cacheService;

    @Value("${redis.cacheName}")
    private String cacheName;

    @Value("${redis.backCacheName}")
    private String backCacheName;

    private static Lock lock = new ReentrantLock();

    @Around(value = "@annotation(cacheData)")
    public Object cacheData(ProceedingJoinPoint pjd, CacheData cacheData) throws NoSuchAlgorithmException {
        String key = getCacheKey(pjd);
        Object result = cacheService.cacheResult(key, cacheName);
        if (result != null){
            logger.info("-----------------------getDataFromCache------------------------");
            return result;
        }

        boolean isNeedLock = cacheData.isNeedLock();
        if (isNeedLock){
//            if (lock.tryLock()){
                try {
                    result = cacheService.cacheResult(key, cacheName);
                    logger.info("-----------------------getDataFromCache-inside------------------------");
                    if (result != null){
                        return result;
                    }
                    result = pjd.proceed();
                    logger.info("-----------------------getDataFromDB-inside------------------------");
                    cacheService.cachePut(key,result,cacheName);
                    cacheService.cachePut(key,result,backCacheName);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }/*finally {
                    lock.unlock();
                }*/
//            }
        }else{
            try {
                result = pjd.proceed();
                logger.info("-----------------------getDataFromDB-outside------------------------");
                cacheService.cachePut(key,result,cacheName);
                cacheService.cachePut(key,result,backCacheName);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return result;
    }

    private String getCacheKey(ProceedingJoinPoint pjd) throws NoSuchAlgorithmException {
        MethodSignature methodSignature = (MethodSignature) pjd.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();

        Object[] args = pjd.getArgs();
        StringBuffer buffer = new StringBuffer(methodName);
        for (int i = 0; i < args.length; i++) {
            buffer.append(args[i].toString());
            System.out.println("当前参数：" + args[i]);
        }
        byte[] baseEncode = Base64.encode(buffer.toString().getBytes());
        String key = getMd5(baseEncode);
        return key;
    }

    private String getMd5(byte[] input) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] md5Result = md5.digest(input);
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : md5Result) {
            int number = b & 0xff;
            if (number < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(number));
        }
        return stringBuffer.toString();
    }
}
