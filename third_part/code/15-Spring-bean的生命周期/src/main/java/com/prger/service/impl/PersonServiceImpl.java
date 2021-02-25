package com.prger.service.impl;
import com.prger.service.PersonService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PersonServiceImpl implements PersonService, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private Integer age;

    public PersonServiceImpl() {
        System.out.println("01 - PersonServiceImpl");
    }

    public void setAge(Integer age) {
        this.age = age;
        System.out.println("02 - setAge -" + age);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("03 - BeanNameAware -" + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("04 - ApplicationContextAware -" + applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("06 - InitializingBean - afterPropertiesSet");
    }

    public void init() {
        System.out.println("07 - init-method");
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("09 - PersonServiceImpl - login - " + username + "_" + password);
        return false;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("10 - InitializingBean - destroy");
    }

    public void dealloc() {
        System.out.println("11 - destroy-method");
    }

    /*
    # 构造方法
    01 - PersonServiceImpl

    # 属性注入
    02 - setAge -20

    # 让你知道bean的名字
    03 - BeanNameAware -personService

    # 让你知道你在那个容器里面
    04 - ApplicationContextAware -org.springframework.context.support.ClassPathXmlApplicationContext@53ca01a2, started on Thu Feb 25 11:42:18 CST 2021

    # 初始化方法调用之前调用
    05 - BeanPostProcessor - before - personService

    # 构造、注入完毕之后调用①(初始化， 加载资源)
    06 - InitializingBean - afterPropertiesSet

    # 构造、注入完毕之后调用②(初始化， 加载资源)
    07 - init-method

    # 初始化方法调用之后调用
    08 - BeanPostProcessor - after - personService

    # 业务方法
    09 - PersonServiceImpl - login - 123_456

    # 销毁之前调用①(释放资源)
    10 - InitializingBean - destroy

    # 销毁之前调用②(释放资源)
    11 - destroy-method
     */





}
