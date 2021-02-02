package com.prger.dao.impl;

import com.prger.bean.Award;
import com.prger.bean.Education;
import com.prger.dao.AwardDao;
import com.prger.utils.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class AwardDaoImpl extends BaseDaoImpl<Award> implements AwardDao {
    @Override
    public List<Award> list() {
        String sql = "SELECT id, created_time, name, image, intro FROM award";
        return Dbs.getTpl().query(sql, new BeanPropertyRowMapper<>(Award.class));
    }

    @Override
    public Award get(Integer id) {
        String sql = "SELECT id, created_time, name, image, intro FROM award WHERE id = ?";
        return Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(Award.class), id);
    }

    @Override
    public boolean save(Award bean) {
        List<Object> args = new ArrayList<>();
        args.add(bean.getName());
        args.add(bean.getImage());
        args.add(bean.getIntro());
        Integer id = bean.getId();
        String sql;
        if (id == null || id < 1) {
            sql = "INSERT INTO award(name, image, intro) VALUES(?, ?, ?)";
        } else {
            sql = "UPDATE education SET name = ?, image = ?, intro = ? WHERE id = ?";
            args.add(id);
        }

        return Dbs.getTpl().update(sql,args.toArray()) > 0;
    }

    @Override
    protected String table() {
        return "award";
    }
}
