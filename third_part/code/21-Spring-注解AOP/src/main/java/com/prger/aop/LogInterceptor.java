package com.prger.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("LogInterceptor - before");
        Object result = methodInvocation.proceed();
        System.out.println("LogInterceptor - after");
        return result;
    }
}
