package com.prger.servlet;

import com.prger.bean.Website;
import com.prger.service.WebsiteService;
import com.prger.service.impl.WebsiteServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/website/*")
public class WebsiteServlet extends BaseServlet{

    private WebsiteService service = new WebsiteServiceImpl();

    /**
     * 进入网站信息界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Website> websites = service.list();
        Website website = (websites != null && !websites.isEmpty()) ? websites.get(0) : null;

        //转发到website.jsp
        request.setAttribute("website", website);
        request.getRequestDispatcher("/WEB-INF/page/admin/website.jsp").forward(request, response);
    }

    /**
     * 保存或者更新网站信息
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Website website = new Website();
        BeanUtils.populate(website, request.getParameterMap());
        boolean save = service.save(website);
        if (save) {
            response.sendRedirect(request.getContextPath() + "/website/admin");
        }else {
            request.setAttribute("error","网站信息保存失败");
            request.getRequestDispatcher("/WEB-INF/page/error/jsp").forward(request, response);
        }
    }
}
