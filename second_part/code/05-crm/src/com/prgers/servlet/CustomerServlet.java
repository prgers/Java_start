package com.prgers.servlet;

import com.prgers.bean.Customer;
import com.prgers.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/customer/*")
public class CustomerServlet extends HttpServlet {

    private CustomerDao dao = new CustomerDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            //利用方法名调用方法
            String uri = request.getRequestURI();
            String[] split = uri.split("/");
            String methodName = split[split.length - 1];
            Method method = getClass()
                    .getMethod(methodName,
                            HttpServletRequest.class,
                            HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "访问路径有问题");
            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
        }
    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = dao.list();
        //将获得的数据存入request中
        request.setAttribute("customers", customers);
        //转发数据到jsp
        request.getRequestDispatcher("/page/list.jsp").forward(request, response);
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customer customer = new Customer(request.getParameter("name"), Integer.parseInt(request.getParameter("age")), Double.parseDouble(request.getParameter("height")));

        boolean save = dao.save(customer);
        if (save) {
            response.sendRedirect("/crm/customer/list");
        }else {
            request.setAttribute("error", "保存客户信息失败");
            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
        }
    }


}
