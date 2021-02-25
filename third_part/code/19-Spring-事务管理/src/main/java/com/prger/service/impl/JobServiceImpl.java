package com.prger.service.impl;

import com.prger.dao.JobDao;
import com.prger.domain.Job;
import com.prger.service.JobService;

import java.util.List;

public class JobServiceImpl implements JobService {

    private JobDao dao;

    public void setDao(JobDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Job> list() {
        return dao.list();
    }

    @Override
    public Job get(Integer id) {
        return dao.get(id);
    }

    @Override
    public boolean save(Job job) {
        return dao.save(job);
    }

    @Override
    public boolean update(Job job) {
        return dao.update(job);
    }

    @Override
    public void test() {

        Job job = new Job("大佬", "全能型选手");
        job.setId(1);
        update(job);

        System.out.println(10 / 0);

        save(new Job("1111", "2222"));



    }
}
