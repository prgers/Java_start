package com.prgers.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class Dbs {
    private static JdbcTemplate tpl;

    /**
     * 静态代码块
     * 当一个类初始化的时候执行静态代码块
     * 当一个类第一次被主动使用时，JVM会对类进行初始化
     * 在整个程序运行中，只会执行一次
     */
    static {
        try (InputStream is = Dbs.class.getClassLoader().getResourceAsStream("druid.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            tpl = new JdbcTemplate(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JdbcTemplate getTpl(){
        return tpl;
    }
}
