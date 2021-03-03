package com.prger.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Value("${name}")
    private String name;
    @Value("${nums}")
    private List<Integer> nums;
    @Value("#{${homes}}")
    private Map<String, String> homes;

    @GetMapping("/test")
    public String test(){
        System.out.println(name);
        System.out.println(nums.toString());
        System.out.println(homes.values());
        System.out.println(homes.keySet());
        return "111111!!!!";
    }
}
