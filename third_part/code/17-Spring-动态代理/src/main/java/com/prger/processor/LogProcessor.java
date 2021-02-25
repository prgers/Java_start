package com.prger.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object target, String beanName) throws BeansException {
        return Proxy.newProxyInstance(
                getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new LogInvocationHandler(target));
    }

    private static class LogInvocationHandler implements InvocationHandler {

        private Object target;

        public LogInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("1--------------------");
            Object result = method.invoke(target, args);
            System.out.println("2--------------------");
            return result;
        }
    }
}
