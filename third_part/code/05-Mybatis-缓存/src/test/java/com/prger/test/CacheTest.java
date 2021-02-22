package com.prger.test;

import com.prger.bean.Job;
import com.prger.utils.MyBatises;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CacheTest {

    @Test
    public void firstLevel() throws Exception {

        /**
         * 一级缓存是放在SqlSession中的
         * 当SqlSession关闭时, 缓存也就失效了
         * 执行insert, update, delete, commit时，会自动清理缓存
         */

        try(SqlSession session = MyBatises.openSession()) {

            Job job1 =  session.selectOne("job.get", 1);
            System.out.println(job1);

            session.update("job.update", null);

            Job job2 =  session.selectOne("job.get", 1);
            System.out.println(job2);
        }
    }

    @Test
    public void secondLevel() throws Exception {

        try(SqlSession session = MyBatises.openSession()) {
            Job job =  session.selectOne("job.get", 1);
//            job.setName("哈哈哈");
            System.out.println( job + "_" + job.getName());
        }

        try(SqlSession session = MyBatises.openSession()) {
            Job job =  session.selectOne("job.get", 1);
            System.out.println( job + "_" + job.getName());
        }

        try(SqlSession session = MyBatises.openSession()) {
            Job job =  session.selectOne("job.get", 1);
            System.out.println( job + "_" + job.getName());
        }

    }
}
