package com.prger.utils;

import com.prger.bean.Company;
import com.prger.bean.Experience;
import com.prger.bean.Project;
import com.prger.bean.User;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TplTest {
    private static final Class[] CLSES = {
            Company.class,
            Project.class,
            Experience.class,
            User.class
    };
    private static final Map<String, String> TPL_DIRS = new HashMap<>();
    private static final String BASE_DIR = "D:\\Git_Repositories\\Java_start\\second_part\\code\\XmgResume\\src\\main\\java\\com\\prger";
    static {
        TPL_DIRS.put("Dao", "dao");
        TPL_DIRS.put("DaoImpl", "dao/impl");
        TPL_DIRS.put("Service", "service");
        TPL_DIRS.put("ServiceImpl", "service/impl");
        TPL_DIRS.put("Servlet", "servlet");
    }

    public static void main(String[] args) throws Exception {
        for (Map.Entry<String, String> entry : TPL_DIRS.entrySet()) {
            String suffix = entry.getKey(); // 后缀
            String dir = entry.getValue();
            // 获取tpl文件的路径
            String tpl = "tpl/" + suffix + ".tpl";
            String tplFilepath = TplTest.class.getClassLoader().getResource(tpl).getFile();
            // 模板文件的内容
            String text = FileUtils.readFileToString(new File(tplFilepath), "UTF-8");
            // 根据类名替换文件内容
            for (Class cls : CLSES) {
                String clsName = cls.getSimpleName();
                String newText = text.replace("#0#", clsName);
                String filename = clsName + suffix + ".java";
                String filepath = BASE_DIR + "/" + dir + "/" + filename;

                File file = new File(filepath);

                if (file.exists()) {
                    System.out.println("已经存在：" + file);
                    continue;
                }
                FileUtils.writeStringToFile(file, newText, "UTF-8");
                System.out.println("新生成：" + file);
            }
        }
    }
}
