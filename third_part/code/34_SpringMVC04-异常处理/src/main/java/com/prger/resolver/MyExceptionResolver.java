package com.prger.resolver;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice(basePackages = "com.prger.controller")
public class MyExceptionResolver {

    @ExceptionHandler({IOException.class})
    public ModelAndView resolveException(Exception ex) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("ex", ex);
        mv.setViewName("/WEB-INF/page/error/default.jsp");
        return mv;
    }
}
