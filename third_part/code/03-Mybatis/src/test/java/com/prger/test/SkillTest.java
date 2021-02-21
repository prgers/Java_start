package com.prger.test;

import com.prger.bean.Skill;
import com.prger.utils.MyBatises;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void dynamicSQL() throws Exception {

        try(SqlSession session = MyBatises.openSession()) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", 1);
            map.put("name", "%m%");
            map.put("level", 3);
            List<Skill> skills = session.selectList("skill.dynamicSQL2", map);
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

    /**
     * openSession默认是不提交事务的，要自己手动提交
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        try(SqlSession session = MyBatises.openSession(true)){
            Skill skill = new Skill("Android", 1);
            int insert = session.insert("skill.insert", skill);
        }
    }

    @Test
    public void insert2() throws Exception {
        try(SqlSession session = MyBatises.openSession(true)){
            Skill skill = new Skill("Android", 1);
            int insert = session.insert("skill.insert2", skill);
            System.out.println(skill.getId());
        }
    }

    @Test
    public void insert3() throws Exception {
        try(SqlSession session = MyBatises.openSession(true)){
            Skill skill = new Skill("PHP", 1);
            int insert = session.insert("skill.insert3", skill);
            System.out.println(skill.getId());
        }
    }

    @Test
    public void batchAdd() throws Exception {
        try(SqlSession session = MyBatises.openSession(true)) {
            List<Skill> list = new ArrayList<>();
            list.add(new Skill("卖艺1", 3));
            list.add(new Skill("卖唱2", 3));
            session.insert("skill.batchAdd", list);
            System.out.println(list.get(0).getId());
        }
    }

    @Test
    public void update() throws Exception {
        try(SqlSession session = MyBatises.openSession()) {
            Skill skill = new Skill("MySQL", 3);
            skill.setId(1);
            session.update("skill.update", skill);
            session.commit();
        }
    }

    @Test
    public void delete() throws Exception {
        try(SqlSession session = MyBatises.openSession()) {
            session.delete("skill.delete", 8);
            session.commit();
        }
    }

    @Test
    public void batchDelete() throws Exception {
        try(SqlSession session = MyBatises.openSession(true)) {
            List<Integer> list = new ArrayList<>();
            list.add(17);
            list.add(18);
            session.delete("skill.batchDelete", list);
        }
    }
}
