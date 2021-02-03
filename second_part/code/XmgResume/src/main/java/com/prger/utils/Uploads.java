package com.prger.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

public class Uploads {

    private static final String BASE_DIR = "upload";
    private static final String IMG_DIR = "image";

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
}
