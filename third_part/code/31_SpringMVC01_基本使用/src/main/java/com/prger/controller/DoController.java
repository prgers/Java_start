package com.prger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/do")
public class DoController {

    @RequestMapping("/test.do")
    @ResponseBody
    public String test(){
        return "test.do";
    }
}
