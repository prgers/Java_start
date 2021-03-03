package com.prger.controller;

import com.prger.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonController {

    @RequestMapping(value = "/json1", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String json1(){
        return "{\"age\":20,\"name\":\"潘小懒\"}";
    }

    @RequestMapping("json2")
    @ResponseBody
    public Student json2(){
        Student student = new Student("潘小懒",20);
        return student;
    }
}
