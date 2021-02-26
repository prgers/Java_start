package com.prger;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(ctx.getBean("person"));
        System.out.println(ctx.getBean("dog"));
        System.out.println(ctx.getBean("user"));
        System.out.println(ctx.getBean("userDaoImpl"));
        System.out.println(ctx.getBean("userServiceImpl"));
        System.out.println(ctx.getBean("userServlet"));

    }
}
