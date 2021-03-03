package com.prger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/stringHtml")
public class StringHtmlController {

    @RequestMapping(value = "/plainText", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String plainText(){
        return "my name is 潘小懒";
    }

    @RequestMapping(value = "/html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String html(){
        return "<h1>my name is 潘小懒</h1>";
    }
}
