package com.prger.servlet;

import com.prger.bean.Award;
import com.prger.bean.Company;
import com.prger.bean.UploadParams;
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

@WebServlet("/company/*")
public class CompanyServlet extends BaseServlet<Company> {
    /**
     * 进入公司信息界面
     */
    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Company> companies = service.list();
        request.setAttribute("companies", companies);
        forward(request, response, "admin/company.jsp");
    }

    /**
     * 保存公司信息
     */
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UploadParams uploadParams = Uploads.parseRequest(request);
        Company company = new Company();
        BeanUtils.populate(company,uploadParams.getParams());

        FileItem item = uploadParams.getFileParam("logoFile");
        company.setLogo(Uploads.uploadImage(item, request, company.getLogo()));

        boolean save = service.save(company);
        if (save) {
            redirect(request, response, "company/admin");
        }else {
            forwardError(request, response, "公司信息保存失败");
        }
    }

    /**
     * 删除公司信息
     */
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("id");

        List<Integer> list = new ArrayList<>();
        for (String id : ids) {
            list.add(Integer.valueOf(id));
        }

        boolean remove = service.remove(list);
        if (remove) {
            redirect(request, response, "company/admin");
        }else {
            forwardError(request, response, "公司信息删除失败");
        }
    }
}
