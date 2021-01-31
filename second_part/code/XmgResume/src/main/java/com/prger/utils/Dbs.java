package com.prger.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class Dbs {

    private static JdbcTemplate tpl;

    static {
        try (InputStream inputStream = Dbs.class.getClassLoader().getResourceAsStream("druid.properties")){
            Properties properties = new Properties();
            properties.load(inputStream);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            tpl = new JdbcTemplate(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JdbcTemplate getTpl(){
        return tpl;
    }

}
