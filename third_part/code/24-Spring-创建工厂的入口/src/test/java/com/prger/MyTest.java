package com.prger;

import com.prger.cfg.BeanConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    private ApplicationContext ctx;

    @Before
    public void before() {
//        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
    }

    @Test
    public void test() {

        System.out.println(ctx.getBean("person"));

    }
}
