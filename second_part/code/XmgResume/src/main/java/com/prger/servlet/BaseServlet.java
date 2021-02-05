package com.prger.servlet;

import com.prger.service.BaseService;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;


public abstract class BaseServlet<T> extends HttpServlet {
    static {
        DateConverter dateConverter = new DateConverter(null);
        dateConverter.setPatterns(new String[]{"yyyy-MM-dd"});
        ConvertUtils.register(dateConverter, Date.class);
    }

    protected BaseService<T> service = newService();
    protected BaseService<T> newService(){
        // com.prger.servlet.WebsiteServlet
        // com.prger.service.impl.WebsiteServiceImpl

        try {
            String clsName = getClass().getName()
                    .replace(".servlet.", ".service.impl.")
                    .replace("Servlet", "ServiceImpl");
            return (BaseService<T>) Class.forName(clsName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置请求编码
        request.setCharacterEncoding("UTF-8");
        try {
            //根据请求名来调用方法
            String uri = request.getRequestURI();
            String[] split = uri.split("/");
            String methodName = split[split.length - 1];

            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            Throwable exception = e;
            exception.printStackTrace();
            while (exception.getCause() != null) {
                exception = exception.getCause();
            }

            forwardError(request, response, exception.getClass().getSimpleName() + ":" + exception.getMessage());
        }
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/page/" + path).forward(request, response);
    }

    protected void forwardError(HttpServletRequest request, HttpServletResponse response, String error) throws ServletException, IOException{
        request.setAttribute("error", error);
        forward(request,response, "error.jsp");
    }

    protected void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        response.sendRedirect( request.getContextPath() + "/" + path);
    }
}
