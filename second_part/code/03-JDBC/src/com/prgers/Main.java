package com.prgers;

import java.sql.*;

public class Main {

    private static  final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static  final String URL = "jdbc:mysql://localhost:3306/xmg?useSSL=false&serverTimezone=UTC";
    private static  final String USERNAME = "root";
    private static  final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {

        login("123","456");

    }

    private static void login(String username, String password) {

        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            //连接数据库
            try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql)) {
                //4. 执行语句
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    System.out.println("登录成功");
                }else {
                    System.out.println("登录失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test4() {

        try {
            String sql = "UPDATE student SET age = 100 WHERE id = 1";
            //连接数据库
            try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql)) {
                //4. 执行语句
                int i = statement.executeUpdate();
                if (i > 0) {
                    System.out.println("更新成功");
                }else {
                    System.out.println("更新失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void test3() {

        try {
            String sql = "SELECT * FROM student";
            //连接数据库
            try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql)) {
                //4. 执行语句
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name"));
                    System.out.println(resultSet.getInt("age"));
                    System.out.println(resultSet.getString("phone"));
                    System.out.println("---------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        try {
            //连接数据库
            try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {
                //4. 执行语句
                String sql = "SELECT * FROM student";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name"));
                    System.out.println(resultSet.getInt("age"));
                    System.out.println(resultSet.getString("phone"));
                    System.out.println("---------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test1() throws Exception{
        //1.注册驱动
        Class.forName(DRIVER_CLASS_NAME);

        //2.连接数据库
        Connection connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);

        //3. 创建语句
        Statement statement = connection.createStatement();

        //4. 执行语句
        String sql = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getInt("age"));
            System.out.println(resultSet.getString("phone"));
            System.out.println("---------------------");
        }
        //5. 关闭资源
        statement.close();
        connection.close();
    }
}
