package com.prger;

import com.prger.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {

    @Test
    public void test() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);

        Person person2 = ctx.getBean("person2", Person.class);
        System.out.println(person2);

        Person person3 = ctx.getBean("person3", Person.class);
        System.out.println(person3);

        Person person4 = ctx.getBean("person4", Person.class);
        System.out.println(person4);

        Person person5 = ctx.getBean("person5", Person.class);
        System.out.println(person5);

        Person person6 = ctx.getBean("person6", Person.class);
        System.out.println(person6);

        Person person7 = ctx.getBean("person7", Person.class);
        System.out.println(person7);

        Person person8 = ctx.getBean("person8", Person.class);
        System.out.println(person8);

        Person person9 = ctx.getBean("person9", Person.class);
        System.out.println(person9);

        Person person10 = ctx.getBean("person10", Person.class);
        System.out.println(person10);

    }
}
