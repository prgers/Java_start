package com.prger.servlet;

import com.prger.bean.Website;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/website/*")
public class WebsiteServlet extends BaseServlet{

    /**
     * 进入网站信息界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Website> websites = service.list();
        Website website = (websites != null && !websites.isEmpty()) ? websites.get(0) : null;

        //转发到website.jsp
        request.setAttribute("website", website);
        forward(request, response, "admin/website.jsp");
    }

    /**
     * 保存或者更新网站信息
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Website website = new Website();
        BeanUtils.populate(website, request.getParameterMap());
        boolean save = service.save(website);
        if (save) {
            redirect(request, response, "website/admin");
        }else {
            forwardError(request, response, "网站信息保存失败");
        }
    }
}
