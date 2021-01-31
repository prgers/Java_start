package com.prgers.dao;

import com.prgers.Constants;
import com.prgers.bean.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    /**
     * 将customer保存到数据库
     * @param customer
     * @return
     */
    public boolean save(Customer customer) {
        try {
            //连接数据库
            String sql = "INSERT INTO customer(name, age, height) VALUES (?, ?, ?)";
            Class.forName(Constants.DRIVER_CLASS_NAME);
            try (Connection connection = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
                 PreparedStatement statement = connection.prepareStatement(sql)){

                statement.setString(1,customer.getName());
                statement.setInt(2,customer.getAge());
                statement.setDouble(3,customer.getHeight());

                //执行SQL语句
                int i = statement.executeUpdate();
                return i > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Customer> list() {

        List<Customer> customers = new ArrayList<>();
        try {
            //连接数据库
            String sql = "SELECT id, name, age, height FROM customer";
            Class.forName(Constants.DRIVER_CLASS_NAME);
            try (Connection connection = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
                 PreparedStatement statement = connection.prepareStatement(sql)){

                //执行SQL语句
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("name"));
                    customer.setAge(resultSet.getInt("age"));
                    customer.setHeight(resultSet.getDouble("height"));
                    customers.add(customer);
                }
                return customers;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return customers;
        }
    }


}
