package com.prgers;

import com.prgers.bean.Customer;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static final List<Customer> customers = new ArrayList<>();
    static {
        for (int i = 0; i < 10; i++) {
            customers.add(new Customer("张三" + i, 18 + 1, 1.2 + i));
        }
    }

    public static void add(Customer customer) {
        customers.add(customer);
    }

    public static List<Customer> getCustomers() {

        return customers;
    }
}
