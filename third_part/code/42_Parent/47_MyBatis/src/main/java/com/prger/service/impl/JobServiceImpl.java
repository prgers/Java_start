package com.prger.service.impl;

import com.prger.dao.JobDao;
import com.prger.domain.Job;
import com.prger.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobServiceImpl implements JobService {

    private JobDao dao;

    @Autowired
    public void setDao(JobDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean save(Job job) {
        Integer id = job.getId();
        if (id == null || id < 1) {
            return dao.save(job);
        }
        return dao.update(job);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.remove(id);
    }

    @Override
    public List<Job> list() {
        return dao.list();
    }

    @Override
    public Job get(Integer id) {
        return dao.get(id);
    }
}
