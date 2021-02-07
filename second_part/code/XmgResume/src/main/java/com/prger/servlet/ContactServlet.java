package com.prger.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prger.bean.Contact;
import com.prger.bean.ContactListParam;
import com.prger.bean.ContactListResult;
import com.prger.bean.User;
import com.prger.service.ContactService;
import com.prger.service.UserService;
import com.prger.service.WebsiteService;
import com.prger.service.impl.UserServiceImpl;
import com.prger.service.impl.WebsiteServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/contact/*")
public class ContactServlet extends BaseServlet<Contact> {

    private UserService userService = new UserServiceImpl();
    private WebsiteService websiteService = new WebsiteServiceImpl();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ContactListParam param = new ContactListParam();
        BeanUtils.populate(param, request.getParameterMap());

        ContactListResult result = ((ContactService) service).list(param);
        request.setAttribute("result", result);
        forward(request, response, "admin/contact.jsp");
    }

    public void read(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Integer id = Integer.valueOf(request.getParameter("id"));
        Map<String, Object> result = new HashMap<>();
        if (((ContactService) service).read(id)) {
            result.put("success", true);
            result.put("msg", "查看成功");
        } else {
            result.put("success", false);
            result.put("msg", "查看失败");
        }

        response.setContentType("text/json; charset=UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }

    public void front(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 用户信息
        User user = userService.list().get(0);
        request.setAttribute("user", user);
        // 网站的底部信息
        request.setAttribute("footer", websiteService.list().get(0).getFooter());

        forward(request, response, "front/contact.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取验证码
        String captcha = request.getParameter("captcha").toLowerCase();

        //从Session中取出验证码
        String code = (String) request.getSession().getAttribute("code");

        //判断验证码是否正确
        if (!captcha.equals(code)) {
            forwardError(request, response, "验证码不正确");
        } else {

            Contact contact = new Contact();
            BeanUtils.populate(contact, request.getParameterMap());

            boolean save = service.save(contact);
            if (save) {
                redirect(request, response, "contact/front");
            }else {
                forwardError(request, response, "保存留言失败");
            }
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }
}
