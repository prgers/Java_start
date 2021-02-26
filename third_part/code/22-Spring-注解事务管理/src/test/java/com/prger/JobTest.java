package com.prger;
import com.prger.domain.Job;
import com.prger.service.JobService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JobTest {

    private JobService jobService;
    private ApplicationContext ctx;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jobService = ctx.getBean("jobService", JobService.class);
    }

    @Test
    public void list() {
        List<Job> jobs = jobService.list();
        System.out.println(jobs);
    }

    @Test
    public void test() {
        jobService.test();
    }
}
