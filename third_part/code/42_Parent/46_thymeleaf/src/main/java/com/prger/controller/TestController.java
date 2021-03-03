package com.prger.controller;

import com.prger.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {
    @GetMapping("/helloWorld")
    public String helloWorld(Model model) {
        model.addAttribute("name", "prger");
        model.addAttribute("age", 20);
        return "01_helloWorld";
    }

    @GetMapping("/comment")
    public String comment() {
        return "02_comment";
    }

    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("name", "prger");
        model.addAttribute("age", 20);
        return "03_literal";
    }

    @GetMapping("/selection")
    public String selection(Model model) {
        model.addAttribute("person", new Person(1, "prger"));
        return "04_selection";
    }

//    @GetMapping("/i18n")
//    public String i18n() {
//        return "05_i18n";
//    }

    @GetMapping("/url")
    public String url(Model model) {
        model.addAttribute("name", "prger");
        model.addAttribute("age", 20);
        return "06_url";
    }

    @GetMapping("/test")
    public String test(String name, Integer age) {
        System.out.println(name);
        System.out.println(age);
        return "05_i18n";
    }

    @GetMapping("/for")
    public String _for(Model model) {
        model.addAttribute("persons", List.of(new Person(1, "111"), new Person(2, "222")));
        return "07_for";
    }

    @GetMapping("/attr")
    public String attr(Model model) {
        model.addAttribute("name", "prger");
        model.addAttribute("id", 20);
        return "08_attr";
    }

}
