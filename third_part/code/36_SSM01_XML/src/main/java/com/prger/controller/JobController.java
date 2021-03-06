package com.prger.controller;

import com.prger.domain.Job;
import com.prger.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobController {


    private JobService service;

    @Autowired
    public void setService(JobService service) {
        this.service = service;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Job> list(){
        return service.list();
    }
}
