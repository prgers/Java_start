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

}
