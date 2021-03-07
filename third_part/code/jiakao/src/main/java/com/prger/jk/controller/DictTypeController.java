package com.prger.jk.controller;

import com.prger.jk.pojo.po.DictType;
import com.prger.jk.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dictTypes")
public class DictTypeController {

    private DictTypeService service;

    @Autowired
    public void setService(DictTypeService service) {
        this.service = service;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<DictType> list() {
        List<DictType> dictTypes = service.list();
        return dictTypes;
    }
}
