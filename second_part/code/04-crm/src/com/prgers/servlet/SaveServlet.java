package com.prgers.servlet;

import com.prgers.Constants;
import com.prgers.bean.Customer;
import com.prgers.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {

    private CustomerDao dao = new CustomerDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置请求编码
        request.setCharacterEncoding("UTF-8");

        Customer customer = new Customer(request.getParameter("name"), Integer.parseInt(request.getParameter("age")), Double.parseDouble(request.getParameter("height")));

        boolean save = dao.save(customer);
        if (save) {
            response.sendRedirect("/crm/list");
        }else {
            System.out.println("添加失败");
        }
    }
}
