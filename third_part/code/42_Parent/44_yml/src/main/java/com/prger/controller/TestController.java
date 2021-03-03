package com.prger.controller;

import com.prger.domain.Jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Jdbc jdbc;

    @GetMapping("/test")
    public String test() {
        System.out.println(jdbc);
        return "hello yml";
    }
}
