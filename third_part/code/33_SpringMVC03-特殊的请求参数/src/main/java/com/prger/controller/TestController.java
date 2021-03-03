package com.prger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestParam Map<String, Object> map,
                       String[] hobby
//                       @RequestParam List<String> hobby
    ){
        System.out.println(map);
        for (String s : hobby) {
            System.out.println(s);
        }
        return "test success!";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return "test2 success";
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String test3(String username, MultipartFile photo, HttpServletRequest request) throws Exception{
        System.out.println(username);

        System.out.println(photo.getOriginalFilename());
        return "test3 success";
    }

    @RequestMapping("/test4")
    @ResponseBody
    public String test4(Date birthday) {
        System.out.println(birthday);
        return "test4 success";
    }
}
