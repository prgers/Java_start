package com.prger.servlet;

import com.prger.bean.Education;
import com.prger.bean.Skill;
import com.prger.service.EducationService;
import com.prger.service.SkillService;
import com.prger.service.impl.EducationServiceImpl;
import com.prger.service.impl.SkillServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/skill/*")
public class SkillServlet extends BaseServlet {

    private SkillService service = new SkillServiceImpl();
    /**
     * 进入教育信息界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Skill> skills = service.list();
        request.setAttribute("skills", skills);
        request.getRequestDispatcher("/WEB-INF/page/admin/skill.jsp").forward(request, response);
    }

    /**
     * 保存教育信息
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Skill skill = new Skill();
        BeanUtils.populate(skill, request.getParameterMap());

        boolean save = service.save(skill);
        if (save) {
            response.sendRedirect( request.getContextPath() + "/skill/admin");
        }else {
            request.setAttribute("error","教育信息保存失败");
            request.getRequestDispatcher("/WEB-INF/page/error/jsp").forward(request, response);
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
            response.sendRedirect( request.getContextPath() + "/skill/admin");
        }else {
            request.setAttribute("error","教育信息删除失败");
            request.getRequestDispatcher("/WEB-INF/page/error/jsp").forward(request, response);
        }
    }

}
