package com.prger.dao.impl;

import com.prger.bean.Job;
import com.prger.dao.JobDao;
import com.prger.utils.MyBatises;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class JobDaoImpl implements JobDao {
    @Override
    public List<Job> list() {
        try(SqlSession session = MyBatises.openSession()) {
            return session.selectList("job.list");
        }
    }

    @Override
    public Job getById(Integer id) {

        try(SqlSession session = MyBatises.openSession()) {
            return session.selectOne("job.get", id);
        }
    }

    @Override
    public boolean update(Job job) {
        try(SqlSession session = MyBatises.openSession(true)) {
            return session.update("job.update", job) > 0;
        }
    }
}
