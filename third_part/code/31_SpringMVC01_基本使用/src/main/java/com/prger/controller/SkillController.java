package com.prger.controller;

import com.prger.domain.Skill;
import org.junit.runners.Parameterized;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/skill")
public class SkillController {

//    @PostMapping("/add")
//    @ResponseBody
//    public String add(Skill skill){
//        System.out.println(skill);
//        return "add success";
//    }

    @PostMapping("/add")
    @ResponseBody
    public String add(String name, String intro, @RequestParam("my_level") Integer level){
        System.out.println(name);
        System.out.println(intro);
        System.out.println(level);
        return "添加成功";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable("id") Integer id){
        System.out.println(id);
        return "get success";
    }
}
