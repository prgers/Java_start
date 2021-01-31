package com.prgers.dao;

import com.prgers.bean.Customer;
import com.prgers.utils.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    /**
     * 将customert添加\更新到数据库
     * @param customer
     * @return
     */
    public boolean save(Customer customer) {

        //构建参数
        List<Object> args = new ArrayList<>();
        args.add(customer.getName());
        args.add(customer.getAge());
        args.add(customer.getHeight());

        String sql;
        //根据id识别添加 or 更新
        Integer id = customer.getId();
        if (id == null || id < 1) { //添加
            sql = "INSERT INTO customer(name, age, height) VALUES (?, ?, ?)";
        }else { //更新
            sql = "UPDATE customer SET name = ?, age = ?, height = ? WHERE id = ?";
            args.add(id);
        }
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
}
