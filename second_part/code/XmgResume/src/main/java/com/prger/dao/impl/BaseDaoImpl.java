package com.prger.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.prger.dao.BaseDao;
import com.prger.utils.Strings;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    protected static JdbcTemplate tpl;

    static {
        try (InputStream inputStream = BaseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties")){
            Properties properties = new Properties();
            properties.load(inputStream);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            tpl = new JdbcTemplate(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String table = table();
    protected String table() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class beanCls = (Class) type.getActualTypeArguments()[0];
        return Strings.underlineCase(beanCls.getSimpleName());
    };

    @Override
    public boolean remove(List<Integer> list) {
        List<Integer> args = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ").append(table).append(" WHERE id IN (");
        for (Integer id : list) {
            sql.append("?, ");
            args.add(id);
        }
        sql.replace(sql.length() - 2, sql.length(), ")");
        return tpl.update(sql.toString(), args.toArray()) > 0;
    }
}
