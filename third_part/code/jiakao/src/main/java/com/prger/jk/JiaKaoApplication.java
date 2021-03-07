package com.prger.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.prger.jk.mapper")
public class JiaKaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiaKaoApplication.class, args);
    }
}
