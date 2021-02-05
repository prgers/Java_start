package com.prger.servlet;

import com.prger.bean.*;
import com.prger.service.CompanyService;
import com.prger.service.UserService;
import com.prger.service.WebsiteService;
import com.prger.service.impl.CompanyServiceImpl;
import com.prger.service.impl.UserServiceImpl;
import com.prger.service.impl.WebsiteServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/experience/*")
public class ExperienceServlet extends BaseServlet<Experience> {

    private CompanyService companyService = new CompanyServiceImpl();
    private UserService userService = new UserServiceImpl();
    private WebsiteService websiteService = new WebsiteServiceImpl();
    /**
     * 进入工作经验界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Experience> experiences = service.list();
        List<Company> companies = companyService.list();
        request.setAttribute("experiences", experiences);
        request.setAttribute("companies", companies);
        forward(request, response, "admin/experience.jsp");
    }

    /**
     * 保存工作经验
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Experience experience = new Experience();
        BeanUtils.populate(experience, request.getParameterMap());

        //对公司进行处理
        Company company = new Company();
        company.setId(Integer.valueOf(request.getParameter("companyId")));
        experience.setCompany(company);

        boolean save = service.save(experience);
        if (save) {
            redirect(request, response, "experience/admin");
        }else {
            forwardError(request, response, "工作经验保存失败");
        }
    }

    /**
     * 删除工作经验
     */
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");

        List<Integer> list = new ArrayList<>();
        for (String id : ids) {
            list.add(Integer.valueOf(id));
        }

        boolean remove = service.remove(list);
        if (remove) {
            redirect(request, response, "experience/admin");
        }else {
            forwardError(request, response, "工作经验删除失败");
        }
    }

    public void front(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Experience> experiences = service.list();
        request.setAttribute("experiences", experiences);

        // 用户信息
        User user = userService.list().get(0);
        request.setAttribute("user", user);
        // 网站的底部信息
        request.setAttribute("footer", websiteService.list().get(0).getFooter());

        forward(request, response, "front/experience.jsp");
    }
}
