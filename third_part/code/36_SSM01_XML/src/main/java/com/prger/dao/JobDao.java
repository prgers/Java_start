package com.prger.dao;

import com.prger.domain.Job;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JobDao {

    boolean save(Job job);
    boolean update(Job job);
    boolean remove(Integer id);

    @Select("SELECT id, name, duty FROM job")
    List<Job> list();

    @Select("SELECT id, name, duty FROM job WHERE id = #{id}")
    Job get(Integer id);
}
