package com.prger.servlet;

import com.prger.bean.Award;
import com.prger.bean.UploadParams;
import com.prger.service.AwardService;
import com.prger.utils.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/award/*")
public class AwardServlet extends BaseServlet{
    /**
     * 进入获奖成就界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Award> awards = service.list();
        System.out.println(awards);
        request.setAttribute("awards", awards);
        forward(request, response, "admin/award.jsp");
    }

    /**
     * 保存获奖成就
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UploadParams uploadParams = Uploads.parseRequest(request);
        Award award = new Award();
        BeanUtils.populate(award,uploadParams.getParams());

        FileItem item = uploadParams.getFileParam("imageFile");
        award.setImage(Uploads.uploadImage(item, request, award.getImage()));

        boolean save = service.save(award);
        if (save) {
            redirect(request, response, "award/admin");
        }else {
            forwardError(request, response, "获奖成就保存失败");
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

        boolean remove = ((AwardService) service).remove(list, request);
        if (remove) {
            redirect(request, response, "award/admin");
        }else {
            forwardError(request, response, "获奖成就删除失败");
        }
    }
}
