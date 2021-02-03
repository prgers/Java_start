package com.prger.servlet;

import com.prger.bean.Award;
import com.prger.bean.Education;
import com.prger.service.AwardService;
import com.prger.service.EducationService;
import com.prger.service.impl.AwardServiceImpl;
import com.prger.service.impl.EducationServiceImpl;
import com.prger.utils.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.*;

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

        //非文件参数map
        Map<String, Object> params = new HashMap<>();

        //文件参数map
        Map<String, FileItem> fileParams = new HashMap<>();

        //遍历请求参数
        for (FileItem item : items) {
            String fieldName = item.getFieldName();
            params.put(item.getFieldName(), item.getString("UTF-8"));
            if (item.isFormField()) { //非文件参数
            }else { //文件参数

                fileParams.put(fieldName, item);
            }
        }
        Award award = new Award();
        BeanUtils.populate(award,params);

        FileItem item = fileParams.get("imageFile");
        award.setImage(Uploads.uploadImage(item, request, award.getImage()));

//        if (award.getImage() != null && award.getImage().length() == 0) {
//            award.setImage(null);
//        }
//
//        FileItem item = fileParams.get("imageFile");
//        if (item != null) {
//
//            InputStream is = item.getInputStream();
//
//            if (is.available() > 0) { //判断上传的输入流有多大
//                //图片在硬盘上的路径
//                String fileName = UUID.randomUUID().toString().replace("-", "") + "." + FilenameUtils.getExtension(item.getName());
//                String image = "upload/image" + "/" + fileName;
//                String filepath = request.getServletContext().getRealPath(image);
//                System.out.println(filepath);
//                FileUtils.copyInputStreamToFile(item.getInputStream(), new File(filepath));
//            }
//        }

        boolean save = service.save(award);
        if (save) {
            response.sendRedirect( request.getContextPath() + "/award/admin");
        }else {
            request.setAttribute("error","教育信息保存失败");
            request.getRequestDispatcher("/WEB-INF/page/error/jsp").forward(request, response);
        }
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

        boolean remove = service.remove(list, request);
        if (remove) {
            response.sendRedirect( request.getContextPath() + "/award/admin");
        }else {
            request.setAttribute("error","获奖成就删除失败");
            request.getRequestDispatcher("/WEB-INF/page/error/jsp").forward(request, response);
        }
    }
}
