package com.prger.service;

import com.prger.domain.Job;

import java.util.List;

public interface JobService {

    boolean save(Job job);
    boolean remove(Integer id);
    List<Job> list();
    Job get(Integer id);
}
