package com.nhnacademy.edu.springframework.aspect;

import com.nhnacademy.edu.springframework.messagesender.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {

    @Order(1)
    @Around("execution(public * sendMessage(..))")
    public Object loggingSendMessage(ProceedingJoinPoint pjp) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        System.out.println("loggingSendMessage start");
        try{
            stopWatch.start();
            return pjp.proceed();
        }finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }

    @Order(2)
    @Around("execution(public * sendMessage(..)) && args(user, message)")
    public Object loggingSendMessageUser(ProceedingJoinPoint pjp, User user, String message) throws Throwable{
        System.out.println("loggingSendMessageUser start");
        try{
            return pjp.proceed();
        }finally {
            System.out.println("[AOP] "+user.toString());
        }
    }
}


