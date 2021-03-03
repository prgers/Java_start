package com.prger.controller;

import com.prger.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JspController {

    @RequestMapping("/jsp/mv1")
    public ModelAndView mv1(){
        ModelAndView mv = new ModelAndView("/person.jsp");
        Person person = new Person("潘小懒", 18);
        mv.addObject("person",person);
        return mv;
    }

    @RequestMapping("/jsp/mv2")
    public String mv2(HttpServletRequest request){
        Person person = new Person("潘小懒", 18);
        request.setAttribute("person",person);
        return "redirect:/person.jsp";
    }

    @RequestMapping("/mv3")
    public String mv3(){
        return "jsp1";
    }

    /**
     * /mvc02/WEB-INF/page//person.jsp.jsp
     */
    @RequestMapping("/mv4")
    public String mv4(HttpServletRequest request){
        Person person = new Person("潘小懒", 18);
        request.setAttribute("person",person);
        return "/person.jsp";
    }
}
