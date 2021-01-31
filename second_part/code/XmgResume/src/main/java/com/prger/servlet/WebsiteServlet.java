package com.prger.servlet;

import com.prger.bean.Website;
import com.prger.dao.WebsiteDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/website/*")
public class WebsiteServlet extends BaseServlet{

    private WebsiteDao dao = new WebsiteDao();

    /**
     * 进入网站信息界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Website> websites = dao.list();
        Website website = (websites != null && !websites.isEmpty()) ? websites.get(0) : null;

        //转发到website.jsp
        request.setAttribute("website", website);
        request.getRequestDispatcher("/page/admin/website.jsp").forward(request, response);
    }

    /**
     * 保存或者更新网站信息
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Website website = new Website();
        BeanUtils.populate(website, request.getParameterMap());
        boolean save = dao.save(website);
        if (save) {
            response.sendRedirect(request.getContextPath() + "/website/admin");
        }else {
            request.setAttribute("error","网站信息保存失败");
            request.getRequestDispatcher("/page/error/jsp").forward(request, response);
        }
    }
}
