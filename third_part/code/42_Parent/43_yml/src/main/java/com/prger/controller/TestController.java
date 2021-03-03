package com.prger.controller;

import com.prger.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Student student;

    @GetMapping("/test")
    public String test() {
        System.out.println(student);
        return "hello yml";
    }
}
