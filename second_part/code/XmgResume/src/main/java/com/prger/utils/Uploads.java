package com.prger.utils;

import com.prger.bean.UploadParams;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Uploads {

    private static final String BASE_DIR = "upload";
    private static final String IMG_DIR = "image";

    /**
     * 图片上传
     * @param item 文件参数
     * @param request 请求
     * @param oldImage 以前的图片路径
     * @return 存储到数据库的图片路径
     * @throws Exception
     */
    public static String uploadImage(FileItem item, HttpServletRequest request, String oldImage) throws Exception {

        //如果oldImage是空字符串，就设置为null
        if (oldImage != null && oldImage.length() == 0) {
            oldImage = null;
        }

        if (item == null) return null;
        InputStream is = item.getInputStream();
        //判断输入流有多大
        if (is.available() == 0) return oldImage;
        ServletContext context = request.getServletContext();

        String fileName = UUID.randomUUID().toString().replace("-", "") + "." + FilenameUtils.getExtension(item.getName());
        String image = BASE_DIR + "/" + IMG_DIR + "/" + fileName;
        String filepath = context.getRealPath(image);
        System.out.println(filepath);
        FileUtils.copyInputStreamToFile(item.getInputStream(), new File(filepath));

        //删除旧文件
        if (oldImage != null) {
            //如果oldImage是空串，那么就会把整个web项目的文件夹给删除
            FileUtils.deleteQuietly(new File(context.getRealPath(oldImage)));
        }

        return image;
    }

    public static UploadParams parseRequest(HttpServletRequest request) throws Exception {

        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        upload.setHeaderEncoding("UTF-8");
        // 一个FileItem就代表一个请求参数（文件参数、非文件参数）
        List<FileItem> items = upload.parseRequest(request);
        // 非文件参数
        Map<String, Object> params = new HashMap<>();
        // 文件参数
        Map<String, FileItem> fileParams = new HashMap<>();
        // 遍历请求参数
        for (FileItem item : items) {
            String fieldName = item.getFieldName();
            if (item.isFormField()) { // 非文件参数
                params.put(fieldName, item.getString("UTF-8"));
            } else { // 文件参数
                fileParams.put(fieldName, item);
            }
        }
        UploadParams uploadParams = new UploadParams();
        uploadParams.setParams(params);
        uploadParams.setFileParams(fileParams);
        return uploadParams;
    }
}
