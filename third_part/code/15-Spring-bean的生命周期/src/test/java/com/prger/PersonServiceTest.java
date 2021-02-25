package com.prger;

import com.prger.service.impl.PersonServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonServiceTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonServiceImpl service = ctx.getBean("personService", PersonServiceImpl.class);
        service.login("123", "456");

        ctx.close();
    }
}
