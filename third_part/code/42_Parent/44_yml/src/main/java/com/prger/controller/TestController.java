package com.prger.controller;

import com.prger.domain.Jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(Jdbc.class)
public class TestController {

    @Autowired
    private Jdbc jdbc;

    @GetMapping("/test")
    public String test() {
        System.out.println(jdbc);
        return "hello yml";
    }
}
