package com.prger.controller;

import com.prger.domain.Job;
import com.prger.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService service;

    @Autowired
    public void setService(JobService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Job> list() {
        return service.list();
    }

    @GetMapping("/get/{id}")
    public Job get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping("/save")
    public String save(Job job) {
        String[] msgs;
        Integer id = job.getId();
        if (id == null || id < 1) {
            msgs = new String[] {"添加成功", "添加失败"};
        }else {
            msgs = new String[] {"更新成功", "更新失败"};
        }
        return service.save(job) ? msgs[0] : msgs[1];
    }

    @PostMapping("/remove")
    public String remove(Integer id) {
        return service.remove(id) ? "删除成功" : "删除失败";
    }
}
