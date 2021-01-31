package com.prgers.servlet;

import com.prgers.bean.Customer;
import com.prgers.dao.CustomerDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/customer/*")
public class CustomerServlet extends HttpServlet {

    private final CustomerDao dao = new CustomerDao();
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
            forwardError(request, response, "访问路径有问题");
        }
    }

    /**
     * 获取所有用户
     */
    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Customer> customers = dao.list();
        //将获得的数据存入request中
        request.setAttribute("customers", customers);
        //转发数据到jsp
        request.getRequestDispatcher("/page/list.jsp").forward(request, response);
    }

    /**
     * 保存用户
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //获取客户端发送的数据
        Customer customer = new Customer();
        BeanUtils.populate(customer, request.getParameterMap());

        boolean save = dao.save(customer);
        if (save) {
            response.sendRedirect("/crm/customer/list");
        }else {
            forwardError(request, response, "保存客户信息失败");
        }
    }

    /**
     * 删除用户
     */
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        if (dao.remove(id)) {
            response.sendRedirect("/crm/customer/list");
        }else {
            forwardError(request, response, "删除用户信息失败");
        }
    }

    /**
     * 根据id获取用户信息
     */
    public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Customer customer = dao.selectCustomerById(id);
        if (customer != null) {
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/page/save.jsp").forward(request, response);
        }else {
            forwardError(request, response, "查询用户失败");
        }
    }



    /**
     * error统一处理
     */
    private void forwardError(HttpServletRequest request, HttpServletResponse response, String error) throws ServletException, IOException {
        request.setAttribute("error", error);
        request.getRequestDispatcher("/page/error.jsp").forward(request, response);
    }


}
