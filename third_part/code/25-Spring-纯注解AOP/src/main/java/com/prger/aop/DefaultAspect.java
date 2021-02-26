package com.prger.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DefaultAspect {

    @Pointcut("execution(* *(..))")
    public void pcAll(){}

    @Around("pcAll()")
    public Object log(ProceedingJoinPoint point) throws Throwable {

        System.out.println("log -------------- 1");
        Object result = point.proceed();
        System.out.println("log -------------- 2");
        return result;
    }
}
