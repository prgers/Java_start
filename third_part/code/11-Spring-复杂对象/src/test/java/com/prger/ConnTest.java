package com.prger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnTest {

    @Test
    public void test(){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(ctx.getBean("conn3"));
    }
}
