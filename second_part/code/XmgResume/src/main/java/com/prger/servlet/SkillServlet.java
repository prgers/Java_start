package com.prger.servlet;
import com.prger.bean.Skill;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/skill/*")
public class SkillServlet extends BaseServlet {
    /**
     * 进入专业技能界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Skill> skills = service.list();
        request.setAttribute("skills", skills);
        forward(request, response, "admin/skill.jsp");
    }

    /**
     * 保存专业技能
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Skill skill = new Skill();
        BeanUtils.populate(skill, request.getParameterMap());

        boolean save = service.save(skill);
        if (save) {
            redirect(request, response, "skill/admin");
        }else {
            forwardError(request, response, "专业技能保存失败");
        }
    }

    /**
     * 删除专业技能
     */
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");

        List<Integer> list = new ArrayList<>();
        for (String id : ids) {
            list.add(Integer.valueOf(id));
        }

        boolean remove = service.remove(list);
        if (remove) {
            redirect(request, response, "skill/admin");
        }else {
            forwardError(request, response, "专业技能删除失败");
        }
    }

}
