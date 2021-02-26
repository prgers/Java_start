package com.prger.service;

import com.prger.domain.Job;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JobService {

    List<Job> list();
    Job get(Integer id);
    boolean save(Job job);
    boolean update(Job job);
    void test();
}
