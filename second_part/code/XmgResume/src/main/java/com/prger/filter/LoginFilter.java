package com.prger.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();

        //对request进行过滤
        if (uri.contains("/asset/") || uri.contains("/contact/save")) { //对加载web资源放行
            chain.doFilter(req, resp);
        } else if (uri.contains("/admin")
                || uri.contains("/save")
                || uri.contains("/remove")
                || uri.contains("/user/password")
                || uri.contains("/user/updatePassword")) {
            Object user = request.getSession().getAttribute("user");
            //判断session中是否存在用户信息
            if (user != null) {//存在，表示登录过
                chain.doFilter(req, resp);
            }else {//不存在，表示未登录
                response.sendRedirect(request.getContextPath() + "/page/login.jsp");
            }
        }else {
            chain.doFilter(req, resp);
        }


    }


    /**
     * 当项目部署到web容器时调用（当Filter被加载到Web容器中）
     */
    public void init(FilterConfig config) throws ServletException {
        //适合做一些资源的一次性加载，初始化
    }

    /**
     * 当项目从Web容器中取消部署时调用（当Filter从Web容器中移除时调用）
     */
    public void destroy() {
        //适合做一些资源的回收操作
    }
}
