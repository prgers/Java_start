package com.prger;

import com.prger.service.PersonService;
import com.prger.service.impl.PersonServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonServiceTest {

    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService service = ctx.getBean("personService", PersonService.class);
        service.login("123", "456");
    }
}
