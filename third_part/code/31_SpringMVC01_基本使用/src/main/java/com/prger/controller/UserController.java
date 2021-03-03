package com.prger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/add")
    @ResponseBody
    public String add(String username, String password){
        System.out.println(username);
        System.out.println(password);
        return "11111111";
    }
}
