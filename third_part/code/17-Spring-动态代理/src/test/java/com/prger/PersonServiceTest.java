package com.prger;

import com.prger.service.PersonService;
import com.prger.service.SkillService;
import com.prger.service.UserService;
import com.prger.service.impl.PersonServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersonServiceTest {

    @Test
    public void test3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        SkillService skillService = ctx.getBean("skillService", SkillService.class);
        skillService.save();

        //获取目标对象
        PersonService personService = ctx.getBean("personService", PersonService.class);

        personService.login("123", "456");

        UserService userService = ctx.getBean("userService", UserService.class);
        userService.run();
    }


    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取目标对象
        PersonService personService = ctx.getBean("personService", PersonService.class);

        personService.login("123", "456");

        UserService userService = ctx.getBean("userService", UserService.class);
        userService.run();
    }


    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取目标对象
        PersonService target = ctx.getBean("personService", PersonService.class);

        //获取代理对象
        PersonService personService = (PersonService) Proxy.newProxyInstance(
                getClass().getClassLoader(), //类加载器
                target.getClass().getInterfaces(), //代理类需要实现的接口(目标类的接口)
                (Object proxy, Method method, Object[] args) -> {//附加的代码(代理类的具体实现)

                        System.out.println("proxy---------1");
                        Object result = method.invoke(target, args);
                        System.out.println("proxy---------2");
                        return result;
                    }
                );

        personService.login("123", "456");

//        UserService userService = ctx.getBean("userService", UserService.class);
//        userService.run();
    }
}
