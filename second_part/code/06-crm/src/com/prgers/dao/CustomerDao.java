package com.prgers.dao;

import com.prgers.bean.Customer;
import com.prgers.utils.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    /**
     * 将customer保存到数据库
     * @param customer
     * @return
     */
    public boolean save(Customer customer) {
        String sql = "INSERT INTO customer(name, age, height) VALUES (?, ?, ?)";
        List<Object> args = buildArgs(customer);
        return Dbs.getTpl().update(sql,args.toArray()) > 0;
    }

    /**
     * 获取所有用户
     * @return
     */
    public List<Customer> list() {
        String sql = "SELECT id, name, age, height FROM customer";
        return Dbs.getTpl().query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }


    /**
     * 根据ID删除用户信息
     * @param id
     * @return
     */
    public boolean remove(Integer id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        return Dbs.getTpl().update(sql, id) > 0;
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public Customer selectCustomerById(Integer id) {
        String sql = "SELECT id, name, age, height FROM customer WHERE id = ?";
        Customer customer = Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), id);
        return customer;
    }

    /**
     * 更新用户信息
     * @param customer
     * @return
     */
    public boolean update(Customer customer) {
        String sql = "UPDATE customer SET name = ?, age = ?, height = ? WHERE id = ?";
        List<Object> args = buildArgs(customer);
        args.add(customer.getId());
        return Dbs.getTpl().update(sql, args.toArray()) > 0;
    }

    private List<Object> buildArgs(Customer customer) {
        List<Object> args = new ArrayList<>();
        args.add(customer.getName());
        args.add(customer.getAge());
        args.add(customer.getHeight());
        return args;
    }
}
