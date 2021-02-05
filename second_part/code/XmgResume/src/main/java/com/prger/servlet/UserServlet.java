package com.prger.servlet;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.prger.bean.Company;
import com.prger.bean.UploadParams;
import com.prger.bean.User;
import com.prger.service.AwardService;
import com.prger.service.SkillService;
import com.prger.service.UserService;
import com.prger.service.WebsiteService;
import com.prger.service.impl.AwardServiceImpl;
import com.prger.service.impl.SkillServiceImpl;
import com.prger.service.impl.WebsiteServiceImpl;
import com.prger.utils.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet<User> {

    private SkillService skillService = new SkillServiceImpl();
    private AwardService awardService = new AwardServiceImpl();
    private WebsiteService websiteService = new WebsiteServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        String[] cmps = uri.split("/");
        String methodName = "/" + cmps[cmps.length - 1];
        if (methodName.equals(request.getContextPath())) {
            try {
                front(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            super.doGet(request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("user", service.list().get(0));
        forward(request, response, "admin/user.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //请求参数转成User
        UploadParams uploadParams = Uploads.parseRequest(request);
        User user = new User();
        BeanUtils.populate(user,uploadParams.getParams());

        //从session中拿到邮箱和密码
        User loginUser = (User) request.getSession().getAttribute("user");
        user.setEmail(loginUser.getEmail());
        user.setPassword(loginUser.getPassword());

        FileItem item = uploadParams.getFileParam("photoFile");
        user.setPhoto(Uploads.uploadImage(item, request, user.getPhoto()));

        boolean save = service.save(user);
        if (save) {
            redirect(request, response, "user/admin");
            //更新session中的用户信息
            request.getSession().setAttribute("user", user);
        }else {
            forwardError(request, response, "公司信息保存失败");
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        //获取验证码
//        String captcha = request.getParameter("captcha").toLowerCase();
//
//        //从Session中取出验证码
//        String code = (String) request.getSession().getAttribute("code");
//
//        //判断验证码是否正确
//        if (!captcha.equals(code)) {
//            forwardError(request, response, "验证码不正确");
//        } else {

            //获取用户名和密码
            User user = new User();
            BeanUtils.populate(user, request.getParameterMap());

            //根据请求信息去数据库查询用户信息
            user = ((UserService) service).get(user);
            if (user != null) { //用户名，密码正确
                redirect(request, response, "user/admin");
                //将用户信息保存至session中
                request.getSession().setAttribute("user", user);
            } else {
                forwardError(request, response, "邮箱或密码不正确");
            }
//        }
    }

    public void password(HttpServletRequest request, HttpServletResponse response) throws Exception {
        forward(request, response, "admin/password.jsp");
    }

    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String oldPassword = request.getParameter("oldPassword");

        //对比session中的用户密码
        User user = (User) request.getSession().getAttribute("user");

        if (!user.getPassword().equals(oldPassword)) {
            forwardError(request, response, "旧密码不正确");
            return;
        }

        //保存新密码
        String newPassword = request.getParameter("newPassword");
        user.setPassword(newPassword);
        boolean save = service.save(user);
        if (save) {
            redirect(request, response, "page/login.jsp");
        }else {
            forwardError(request, response, "修改密码失败");
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //清除session中的用户信息
        request.getSession().removeAttribute("user");
        redirect(request, response, "page/login.jsp");
    }

    public void front(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 用户信息
        User user = service.list().get(0);
        request.setAttribute("user", user);

        // 个人特质
        request.setAttribute("trait", user.getTrait().split(","));

        // 兴趣爱好
        request.setAttribute("interests", user.getInterests().split(","));

        // 专业技能
        request.setAttribute("skills", skillService.list());
        // 获奖成就
        request.setAttribute("awards", awardService.list());
        // 网站的底部信息
        request.setAttribute("footer", websiteService.list().get(0).getFooter());

        forward(request, response, "front/user.jsp");
    }

    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 创建Katpcha对象
        DefaultKaptcha dk = new DefaultKaptcha();

        // 验证码的配置
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("kaptcha.properties")) {
            Properties properties = new Properties();
            properties.load(is);

            Config config = new Config(properties);
            dk.setConfig(config);
        }

        // 生成验证码字符串
        String code = dk.createText();

        //将验证码存储到session中去
        HttpSession session = request.getSession();
        session.setAttribute("code", code.toLowerCase());

        // 生成验证码图片
        BufferedImage image = dk.createImage(code);

        // 设置返回数据的格式
        response.setContentType("image/jpeg");

        // 将图片数据写会到客户端
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
