package com.prger.factory;

import java.io.InputStream;
import java.util.Properties;

public class GeneralFactory {

    private static Properties properties;

    static {
        try(InputStream is = GeneralFactory.class.getClassLoader().getResourceAsStream("factory.properties")) {
            properties = new Properties();
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T get(String name) {

        try {
            //获取类名
            String s = properties.getProperty(name);
            Class cls = Class.forName(s);
            //创建实例对象
            return (T)cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
