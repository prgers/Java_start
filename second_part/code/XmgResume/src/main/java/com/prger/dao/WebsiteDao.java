package com.prger.dao;

import com.prger.bean.Website;
import com.prger.utils.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class WebsiteDao {

    /**
     * 获取所有网站信息
     * @return
     */
    public List<Website> list() {

        String sql = "SELECT id, created_time, footer FROM website";
        return Dbs.getTpl().query(sql, new BeanPropertyRowMapper<>(Website.class));
    }

    /**
     * 保存或者更新网站信息
     * @param website
     * @return
     */
    public boolean save(Website website) {

        //构建参数
        List<Object> args = new ArrayList<>();
        args.add(website.getFooter());
        String sql;
        Integer id = website.getId();
        if (id == null || id < 1) { //保存
            sql = "INSERT INTO website(footer) VALUES(?)";
        } else { //更新
            sql = "UPDATE website SET footer = ? WHERE id = ?";
            args.add(id);
        }
       return Dbs.getTpl().update(sql, args.toArray()) > 0;
    }
}
