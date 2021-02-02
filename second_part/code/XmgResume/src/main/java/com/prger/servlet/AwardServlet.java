package com.prger.servlet;

import com.prger.bean.Award;
import com.prger.bean.Education;
import com.prger.service.AwardService;
import com.prger.service.EducationService;
import com.prger.service.impl.AwardServiceImpl;
import com.prger.service.impl.EducationServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/award/*")
public class AwardServlet extends BaseServlet{
    private AwardService service = new AwardServiceImpl();
    /**
     * 进入获奖成就界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Award> awards = service.list();
        request.setAttribute("awards", awards);
        request.getRequestDispatcher("/WEB-INF/page/admin/award.jsp").forward(request, response);
    }

    /**
     * 保存获奖成就
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        upload.setHeaderEncoding("UTF-8");
        //一个FileItem就代表一个请求参数(文件参数，非文件参数)
        List<FileItem> items = upload.parseRequest(request);

        Map<String, Object> params = new HashMap<>();
        //遍历请求参数
        for (FileItem item : items) {
            String fieldName = item.getFieldName();
            if (item.isFormField()) { //非文件参数
            }else { //文件参数
                String filepath = "G:/1.jpg";
                FileUtils.copyInputStreamToFile(item.getInputStream(), new File(filepath));
            }
        }
//        Award award = new Award();
//        BeanUtils.populate(award, request.getParameterMap());
//
//        boolean save = service.save(award);
//        if (save) {
//            response.sendRedirect( request.getContextPath() + "/award/admin");
//        }else {
//            request.setAttribute("error","教育信息保存失败");
//            request.getRequestDispatcher("/WEB-INF/page/error/jsp").forward(request, response);
//        }
    }

    /**
     * 删除获奖成就
     */
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");

        List<Integer> list = new ArrayList<>();
        for (String id : ids) {
            list.add(Integer.valueOf(id));
        }

        boolean remove = service.remove(list);
        if (remove) {
            response.sendRedirect( request.getContextPath() + "/award/admin");
        }else {
            request.setAttribute("error","获奖成就删除失败");
            request.getRequestDispatcher("/WEB-INF/page/error/jsp").forward(request, response);
        }
    }
}
