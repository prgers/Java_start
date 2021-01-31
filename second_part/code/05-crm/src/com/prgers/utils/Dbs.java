package com.prgers.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Dbs {
    private static DataSource ds;
    static {
        try (InputStream is = Dbs.class.getClassLoader().getResourceAsStream("druid.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行DDL，DML语句
     */
    public static int update(String sql, Object... args) {
        try {
            //连接数据库
            Connection connection = ds.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                //设置参数
                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }
                //执行SQL语句
                return statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 执行DQL语句
     */
    public static <T> List<T> query(String sql, RowMapper<T> mapper, Object... args) {
        if (mapper == null) return  null;
        try {
            //连接数据库
            Connection connection = ds.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                //设置参数
                for (int i = 0; i < args.length; i++) {
                    statement.setObject(i + 1, args[i]);
                }
                //执行SQL语句
                ResultSet resultSet = statement.executeQuery();
                List<T> list = new ArrayList<>();

                int row = 0;
                while (resultSet.next()) {
                    list.add(mapper.map(resultSet, row++));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用来执行每一行数据的映射(rs -> bean)
     * @param <T>
     */
    public interface RowMapper<T> {
        T map(ResultSet rs, int row) throws Exception;
    }
}
