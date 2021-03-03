package com.prger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test() throws IOException {
        throw new IOException();
    }

//    @ExceptionHandler({IOException.class})
//    public ModelAndView resolveException(Exception ex) {
//
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("ex", ex);
//        mv.setViewName("/WEB-INF/page/error/default.jsp");
//        return mv;
//    }
}
