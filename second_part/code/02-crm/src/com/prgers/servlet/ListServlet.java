package com.prgers.servlet;

import com.prgers.Data;
import com.prgers.bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取客户数据
        List<Customer> customers = Data.getCustomers();

        //将客户数据存储到request中
        request.setAttribute("customers", customers);

        //转发到list.jsp页面进行展示
        request.getRequestDispatcher("/page/list.jsp").forward(request, response);
    }
}
