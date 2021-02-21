package com.prger.test;

import com.prger.bean.IdCard;
import com.prger.bean.Person;
import com.prger.utils.MyBatises;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class OneToOne {

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
    public void idCardList() throws Exception {
        try(SqlSession session = MyBatises.openSession()) {
            List<IdCard> idCards = session.selectList("idCard.list");
            System.out.println(idCards);
        }
    }

    @Test
    public void idCardGet() throws Exception {
        try(SqlSession session = MyBatises.openSession()) {
            IdCard idCard = session.selectOne("idCard.get", 1);
            System.out.println(idCard);
        }
    }
}
