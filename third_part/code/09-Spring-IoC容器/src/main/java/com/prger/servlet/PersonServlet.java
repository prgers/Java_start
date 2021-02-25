package com.prger.servlet;
import com.prger.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonServlet {

//    private PersonService service = GeneralFactory.get("service");

    private PersonService service;

    public void setService(PersonService service) {
        this.service = service;
    }

    public void remove() {
        service.remove(1);
    }

    public static void main(String[] args) {

        //读取配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonServlet servlet = ctx.getBean("servlet", PersonServlet.class);
        servlet.remove();

//        PersonServlet servlet = new PersonServlet();
//        servlet.remove();
    }
}
