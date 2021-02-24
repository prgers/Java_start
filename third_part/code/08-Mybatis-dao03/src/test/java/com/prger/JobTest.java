package com.prger;

import com.prger.bean.Job;
import com.prger.dao.JobDao;
import com.prger.utils.MyBatises;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class JobTest {

    @Test
    public void list() {
        try(SqlSession session = MyBatises.openSession()) {
            JobDao dao = session.getMapper(JobDao.class);
            System.out.println(dao.list());
        }
    }

    @Test
    public void get() {
        try(SqlSession session = MyBatises.openSession()) {
            JobDao dao = session.getMapper(JobDao.class);
            System.out.println(dao.getById(1));
        }
    }

    @Test
    public void update() {
        try(SqlSession session = MyBatises.openSession(true)) {
            JobDao dao = session.getMapper(JobDao.class);
            Job job = dao.getById(1);
            job.setName("高级程序员");
            dao.update(job);
        }
    }
}
