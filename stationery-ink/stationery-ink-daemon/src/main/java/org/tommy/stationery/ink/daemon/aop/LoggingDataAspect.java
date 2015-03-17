package org.tommy.stationery.ink.daemon.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by kun7788 on 14. 12. 16..
 */
@Aspect
@Service
public class LoggingDataAspect {
    public static Logger logger = LoggerFactory.getLogger(LoggingDataAspect.class);

    @Pointcut("@annotation( org.tommy.stationery.ink.daemon.annotation.LoggingData)")
    public void logginhDataPutPointcut() {
    }

    @AfterReturning(pointcut = "logginhDataPutPointcut()", returning="retVal")
    public void loggingPutAction(JoinPoint jp, Object retVal) throws Throwable {
        Class clazz = jp.getTarget().getClass();
        String className = jp.getTarget().getClass().getSimpleName();
        String methodName = jp.getSignature().getName();
        Object[] params = jp.getArgs();

        String _params = "";
        if (params != null) {
            for (int i=0;i<params.length;i++) {
                _params += params[i] + ",";
            }
        }
        logger.info("LOGGING: className: " + className + "   methodName: " + methodName + "    params: " + _params);
    }
}
