package com.prger.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogProcessor2 implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object target, String beanName) throws BeansException {

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(getClass().getClassLoader());
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new LogMethodInterceptor(target));
        return enhancer.create();
    }

    private static class LogMethodInterceptor implements MethodInterceptor {

        private Object target;

        public LogMethodInterceptor(Object target) {
            this.target = target;
        }

        @Override
        public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("1--------------------");
            Object result = method.invoke(target, args);
            System.out.println("2--------------------");
            return result;
        }
    }
}
