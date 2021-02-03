package com.prger.dao.impl;

import com.prger.bean.Award;
import com.prger.dao.AwardDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class AwardDaoImpl extends BaseDaoImpl<Award> implements AwardDao {
    @Override
    public List<Award> list() {
        String sql = "SELECT id, created_time, name, image, intro FROM award";
        return tpl.query(sql, new BeanPropertyRowMapper<>(Award.class));
    }

    @Override
    public Award get(Integer id) {
        String sql = "SELECT id, created_time, name, image, intro FROM award WHERE id = ?";
        return tpl.queryForObject(sql, new BeanPropertyRowMapper<>(Award.class), id);
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
            sql = "UPDATE award SET name = ?, image = ?, intro = ? WHERE id = ?";
            args.add(id);
        }

        return tpl.update(sql,args.toArray()) > 0;
    }

    @Override
    public List<String> getImageList(List<Integer> list) {
        //根据id获取所有的图片路径
        List<Integer> args = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT image FROM award").append(" WHERE id IN (");
        for (Integer id : list) {
            sql.append("?, ");
            args.add(id);
        }
        sql.replace(sql.length() - 2, sql.length(), ")");
        return tpl.queryForList(sql.toString(), String.class, args.toArray());
    }
}
