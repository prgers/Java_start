package com.prger;

import com.prger.bean.Job;
import com.prger.dao.JobDao;
import com.prger.dao.impl.JobDaoImpl;
import org.junit.Test;

import java.util.List;

public class JobTest {

    private JobDao dao = new JobDaoImpl();

    @Test
    public void list() {
        List<Job> jobs = dao.list();
        for (Job job : jobs) {
            System.err.println(job);
        }
    }

    @Test
    public void get() {
        System.err.println(dao.getById(1));
    }

    @Test
    public void update() {
        Job job = dao.getById(1);
        job.setName("中级程序员");
        dao.update(job);
    }
}
