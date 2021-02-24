package com.prger.test;

import com.prger.bean.Skill;
import com.prger.utils.MyBatises;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class SkillTest {

    @Test
    public void select() throws Exception{
//        try(Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
//
//            //创建一个工厂构造器
//            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//
//            //创建一个工厂
//            SqlSessionFactory factory = builder.build(reader);
//
//            //创建一个session
//            try(SqlSession session = factory.openSession()) {
//
//                //执行SQL语句
//                List<Skill> skills = session.selectList("skill.list");
//                for (Skill skill : skills) {
//                    System.out.println(skill);
//                }
//            }
//        }

        try(SqlSession session = MyBatises.openSession()) {
            List<Skill> skills = session.selectList("skill.list");
            for (Skill skill : skills) {
                System.out.println(skill);
            }
        }
    }

    @Test
    public void select2() throws Exception{

        try(SqlSession session = MyBatises.openSession()) {
            List<Skill> skills = session.selectList("skill.list2", 1);
            for (Skill skill : skills) {
                System.out.println(skill);
            }
        }
    }

    @Test
    public void select3() throws Exception{

        try(SqlSession session = MyBatises.openSession()) {
            List<Skill> skills = session.selectList("skill.list3");
            for (Skill skill : skills) {
                System.out.println(skill);
            }
        }
    }

    @Test
    public void select4() throws Exception{

        try(SqlSession session = MyBatises.openSession()) {
            List<Skill> skills = session.selectList("skill.list4", new Skill("%m%", 1));
            for (Skill skill : skills) {
                System.out.println(skill);
            }
        }
    }


    @Test
    public void get() throws Exception{

        try(SqlSession session = MyBatises.openSession()) {
            Skill skill = session.selectOne("skill.get", 1);
            System.out.println(skill);
        }
    }
}
