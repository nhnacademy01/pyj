package com.nhnacademy.edu.springframework.project.aspect;

import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
    private static final Log logger = LogFactory.getLog(DefaultStudentService.class);
    StopWatch stopWatch = new StopWatch();

    @Around("execution(* com.nhnacademy.edu.springframework.project.service.*.*(..)")
    public Object loggingSendMessage(ProceedingJoinPoint pjp) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        try{
            stopWatch.start();
            return pjp.proceed();
        }finally {
            stopWatch.stop();
            logger.info("실행 메서드 : "+ "[" + pjp.getSignature().getName() + "]");
            logger.info(stopWatch.prettyPrint());
        }
    }
}
