package com.prger.test;

import com.prger.bean.IdCard;
import com.prger.bean.Job;
import com.prger.bean.Person;
import com.prger.utils.MyBatises;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ManyToMany {

    @Test
    public void personList() throws Exception {
        try(SqlSession session = MyBatises.openSession()) {
            List<Person> persons = session.selectList("person.list");
            System.out.println(persons);
        }
    }

    @Test
    public void personGet() throws Exception {
        try(SqlSession session = MyBatises.openSession()) {
            Person person = session.selectOne("person.get", 1);
            System.out.println(person);
        }
    }

    @Test
    public void jobList() throws Exception {
        try(SqlSession session = MyBatises.openSession()) {
            List<Job> jobs = session.selectList("job.list");
            System.out.println(jobs);
        }
    }

    @Test
    public void jobGet() throws Exception {
        try(SqlSession session = MyBatises.openSession()) {
            Job job = session.selectOne("job.get", 1);
            System.out.println(job);
        }
    }
}
