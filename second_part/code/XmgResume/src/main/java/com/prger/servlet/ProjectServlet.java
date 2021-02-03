package com.prger.servlet;

import com.prger.bean.Company;
import com.prger.bean.Project;
import com.prger.bean.UploadParams;
import com.prger.service.CompanyService;
import com.prger.service.impl.CompanyServiceImpl;
import com.prger.utils.Uploads;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/project/*")
public class ProjectServlet extends BaseServlet<Project> {

    private CompanyService companyService = new CompanyServiceImpl();
    /**
     * 进入项目经验界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("projects", service.list());
        request.setAttribute("companies", companyService.list());
        forward(request, response, "admin/project.jsp");
    }

    /**
     * 保存项目经验
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UploadParams uploadParams = Uploads.parseRequest(request);

        Project project = new Project();
        BeanUtils.populate(project,uploadParams.getParams());

        FileItem item = uploadParams.getFileParam("imageFile");
        project.setImage(Uploads.uploadImage(item, request, project.getImage()));

        //对公司进行处理
        Company company = new Company();
        company.setId(Integer.valueOf(String.valueOf(uploadParams.getParam("companyId"))));
        project.setCompany(company);

        boolean save = service.save(project);
        if (save) {
            redirect(request, response, "project/admin");
        }else {
            forwardError(request, response, "项目经验保存失败");
        }
    }

    /**
     * 删除项目经验
     */
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");

        List<Integer> list = new ArrayList<>();
        for (String id : ids) {
            list.add(Integer.valueOf(id));
        }

        boolean remove = service.remove(list);
        if (remove) {
            redirect(request, response, "project/admin");
        }else {
            forwardError(request, response, "项目经验删除失败");
        }
    }
}
