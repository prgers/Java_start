package com.prger.dao.impl;

import com.prger.bean.Website;
import com.prger.dao.WebsiteDao;
import com.prger.utils.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class WebsiteDaoImpl extends BaseDaoImpl<Website> implements WebsiteDao {

    /**
     * 获取所有网站信息
     */
    public List<Website> list() {

        String sql = "SELECT id, created_time, footer FROM website";
        return Dbs.getTpl().query(sql, new BeanPropertyRowMapper<>(Website.class));
    }

    /**
     * 根据id获取网站信息
     */
    @Override
    public Website get(Integer id) {
        String sql = "SELECT id, created_time, footer FROM website WHERE id = ?";
        return Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(Website.class), id);
    }

    /**
     * 保存或者更新网站信息
     */
    public boolean save(Website bean) {

        //构建参数
        List<Object> args = new ArrayList<>();
        args.add(bean.getFooter());
        String sql;
        Integer id = bean.getId();
        if (id == null || id < 1) { //保存
            sql = "INSERT INTO website(footer) VALUES(?)";
        } else { //更新
            sql = "UPDATE website SET footer = ? WHERE id = ?";
            args.add(id);
        }
       return Dbs.getTpl().update(sql, args.toArray()) > 0;
    }


    @Override
    protected String table() {
        return "website";
    }
}
