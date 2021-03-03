package com.prger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/encoding")
public class EncodingController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password){
        System.out.println(username);
        System.out.println(password);
        return "login success";
    }

    /**
     * 处理数据响应乱码问题
     * produces
     */
//    @RequestMapping(value = "/get", produces = "text/plain; charset=UTF-8")
//    @ResponseBody
//    public String get(){
//        return "潘小懒";
//    }

    @RequestMapping(value = "/get", produces = "text/plain")
    @ResponseBody
    public String get(){
        return "<h1>潘小懒</h1>";
    }

}
