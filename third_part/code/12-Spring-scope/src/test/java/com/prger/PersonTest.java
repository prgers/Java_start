package com.prger;

import com.prger.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(ctx.getBean("person", Person.class));
        System.out.println(ctx.getBean("person", Person.class));
        System.out.println(ctx.getBean("person", Person.class));
        System.out.println(ctx.getBean("person", Person.class));

//        Person person1 = ctx.getBean("person", Person.class);
//        Person person2 = ctx.getBean("person", Person.class);
//        Person person3 = ctx.getBean("person", Person.class);


    }

    /**
     * singleton: 单例
     * 通过同一个id值,在同一个IOC容器中获取的永远都是同一个对象
     *
     * prototype：非单例
     * 每次getBean时创建一次bean
     */
}
