package com.prgers.dao;

import com.prgers.bean.Customer;
import com.prgers.utils.Dbs;

import java.sql.ResultSet;
import java.util.List;

public class CustomerDao {

    /**
     * 将customer保存到数据库
     * @param customer
     * @return
     */
    public boolean save(Customer customer) {
        String sql = "INSERT INTO customer(name, age, height) VALUES (?, ?, ?)";
        return Dbs.update(sql,customer.getName(), customer.getAge(), customer.getHeight()) > 0;
    }

    public List<Customer> list() {
        String sql = "SELECT id, name, age, height FROM customer";

//        List<Customer> customers = Dbs.query(sql, new Dbs.RowMapper<Customer>() {
//            @Override
//            public Customer map(ResultSet rs, int row) throws Exception {
//                Customer customer = new Customer();
//                customer.setId(rs.getInt("id"));
//                customer.setName(rs.getString("name"));
//                customer.setAge(rs.getInt("age"));
//                customer.setHeight(rs.getDouble("height"));
//                return customer;
//            }
//        });
        List<Customer> customers = Dbs.query(sql, (rs, row) -> {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setAge(rs.getInt("age"));
            customer.setHeight(rs.getDouble("height"));
            return customer;
        });
        return customers;
    }


}
