package com.prger.dao;

import com.prger.bean.Job;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JobDao {

    @Select("SELECT * FROM job")
    List<Job> list();

    @Select("SELECT * FROM job WHERE id = #{id}")
    Job getById(Integer id);

    @Select("UPDATE job SET name = #{name}, duty = #{duty} WHERE id = #{id}")
    boolean update(Job job);
}
