package com.prger.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/void")
public class VoidController {

    @RequestMapping("/test")
    public void test(HttpServletResponse response) throws Exception{
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write("<h1>潘小懒</h1>");
    }
}
