package com.prger.controller;

import com.prger.domain.Book;
import com.prger.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/xml")
public class XMLController {
    @RequestMapping(value = "/xml1", produces = "application/xml;charset=UTF-8")
    @ResponseBody
    public String xml1(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<person>" +
                "<age>18</age>" +
                "<name>潘小懒</name>" +
                "</person>";
    }

    @RequestMapping("xml2")
    @ResponseBody
    public Person xml2(){
        Person person = new Person("潘小懒",18);
        person.setBooks(List.of(new Book("Java"), new Book("iOS")));
        return person;
    }


}
