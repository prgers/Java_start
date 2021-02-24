package com.prger.test;

import com.prger.bean.Experience;
import com.prger.utils.MyBatises;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ExperienceTest {

    @Test
    public void select() throws Exception {
        try(SqlSession session = MyBatises.openSession()) {
            List<Experience> experiences = session.selectList("experience.list");

            for (Experience experience : experiences) {
                System.out.println(experience);
            }
        }
    }
}
