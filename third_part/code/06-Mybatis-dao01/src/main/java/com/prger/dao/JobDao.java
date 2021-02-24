package com.prger.dao;

import com.prger.bean.Job;

import java.util.List;

public interface JobDao {

    List<Job> list();
    Job getById(Integer id);
    boolean update(Job job);
}
