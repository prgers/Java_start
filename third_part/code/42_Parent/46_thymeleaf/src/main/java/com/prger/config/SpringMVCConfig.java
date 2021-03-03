package com.prger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置首页
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/i18n").setViewName("05_i18n");
        registry.addViewController("/i18n/").setViewName("05_i18n");
    }
}
