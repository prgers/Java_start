package com.prger;

import com.prger.dao.JobDao;
import com.prger.domain.Job;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JobTest {

    @Test
    public void list() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JobDao dao = ctx.getBean("jobDao", JobDao.class);
        for (Job job : dao.list()) {
            System.out.println(job);
        }
    }
}
