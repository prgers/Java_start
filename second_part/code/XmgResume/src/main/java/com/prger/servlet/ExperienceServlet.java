package com.prger.servlet;

import com.prger.bean.Company;
import com.prger.bean.Experience;
import com.prger.bean.Skill;
import com.prger.service.CompanyService;
import com.prger.service.impl.CompanyServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/experience/*")
public class ExperienceServlet extends BaseServlet<Experience> {

    private CompanyService companyService = new CompanyServiceImpl();
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
}
