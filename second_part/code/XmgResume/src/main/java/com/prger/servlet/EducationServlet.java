package com.prger.servlet;

import com.prger.bean.Education;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/education/*")
public class EducationServlet extends BaseServlet {
    /**
     * 进入教育信息界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Education> educations = service.list();
        request.setAttribute("educations", educations);
        forward(request, response, "admin/education.jsp");
    }

    /**
     * 保存教育信息
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Education education = new Education();
        BeanUtils.populate(education, request.getParameterMap());

        boolean save = service.save(education);
        if (save) {
            redirect(request, response, "education/admin");
        }else {
            forwardError(request, response, "教育信息保存失败");
        }
    }

    /**
     * 删除教育信息
     */
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");

        List<Integer> list = new ArrayList<>();
        for (String id : ids) {
            list.add(Integer.valueOf(id));
        }

        boolean remove = service.remove(list);
        if (remove) {
            redirect(request, response, "education/admin");
        }else {
            forwardError(request, response, "教育信息删除失败");
        }
    }

}
