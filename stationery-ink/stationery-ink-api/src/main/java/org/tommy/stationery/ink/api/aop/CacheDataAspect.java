package org.tommy.stationery.ink.api.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommy.stationery.ink.api.annotation.CacheData;
import org.tommy.stationery.ink.api.component.CacheDataUtil;

import java.lang.reflect.Method;

/**
 * Created by kun7788 on 14. 12. 16..
 */

@Aspect
@Service
public class CacheDataAspect {
    public static Logger logger = LoggerFactory.getLogger(CacheDataAspect.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    CacheDataUtil cacheDataUtil;

    @Pointcut("@annotation( org.tommy.stationery.ink.api.annotation.CacheData)")
    public void cacheDataGetAndPutPointcut() {

    }

    @Around("cacheDataGetAndPutPointcut()")
    public Object cacheGetAndPutAction(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Object[] params = pjp.getArgs();
        Object returnObj = null;
        String cacheKey = null;

        if (method.isAnnotationPresent(CacheData.class)) {
            try {
                long startTime = System.currentTimeMillis();

                //get cache
                cacheKey = cacheDataUtil.generateKey(method.getClass().getName(), method.getName(), params);
                logger.info("CACHE KEY : " + cacheKey + " : " + method.getName());
                if (cacheDataUtil.exist(cacheKey)) {
                    String ret = cacheDataUtil.get(cacheKey);
                    Object rt = objectMapper.readValue(ret, new TypeReference<Object>() {
                    });
                    logger.info("CACHE HITED : " + cacheKey);

                    long estimatedTime = System.currentTimeMillis() - startTime;
                    logger.info("PRECESSING_COMPLETED_TIME(CACHED) : " + method.getName() + " : " + estimatedTime + "ms");
                    return rt;
                }

                returnObj = pjp.proceed();
                //make cache
                if (cacheKey != null && returnObj != null) {
                    cacheDataUtil.put(cacheKey, objectMapper.writeValueAsString(returnObj));
                    logger.info("CACHE MAKE : " + cacheKey);
                }

                long estimatedTime = System.currentTimeMillis() - startTime;
                logger.info("PRECESSING_COMPLETED_TIME(NO_CACHED) : " + method.getName() + " : " + estimatedTime + "ms");
            } catch (Exception ex) {
                logger.error("CACHE ERROR : " + ex.getMessage());
                returnObj = pjp.proceed();
            }
            return returnObj;
        }

        returnObj = pjp.proceed();
        return returnObj;
    }
}
