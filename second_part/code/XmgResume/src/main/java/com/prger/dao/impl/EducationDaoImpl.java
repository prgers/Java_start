package com.prger.dao.impl;

import com.prger.bean.Education;
import com.prger.dao.EducationDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class EducationDaoImpl extends BaseDaoImpl<Education> implements EducationDao {

    /**
     * 获取所有教育信息
     */
    public List<Education> list() {

        String sql = "SELECT id, created_time, name, type, intro, begin_day, end_day FROM education";
        return tpl.query(sql, new BeanPropertyRowMapper<>(Education.class));
    }

    /**
     * 根据id获取教育信息
     */
    @Override
    public Education get(Integer id) {
        String sql = "SELECT id, created_time, name, type, intro, begin_day, end_day FROM education WHERE id = ?";
        return tpl.queryForObject(sql, new BeanPropertyRowMapper<>(Education.class), id);
    }

    /**
     * 保存或者更新教育信息
     */
    public boolean save(Education bean) {

        List<Object> args = new ArrayList<>();
        args.add(bean.getName());
        args.add(bean.getType());
        args.add(bean.getIntro());
        args.add(bean.getBeginDay());
        args.add(bean.getEndDay());
        Integer id = bean.getId();
        String sql;
        if (id == null || id < 1) {
            sql = "INSERT INTO education(name, type, intro, begin_day, end_day) VALUES(?, ?, ?, ?, ?)";
        } else {
            sql = "UPDATE education SET name = ?, type = ?, intro = ?, begin_day = ?, end_day = ? WHERE id = ?";
            args.add(id);
        }

        return tpl.update(sql,args.toArray()) > 0;
    }
}
