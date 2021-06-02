package com.ycc.springcloud.controller;

import com.ycc.springcloud.pojo.Dept;
import com.ycc.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerControllers {

    @Autowired
    private DeptClientService service;

    @RequestMapping("/consumer/dept/add")
    public Boolean addDept(@RequestBody Dept dept){
        return service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.queryById(id) ;
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> getAll(){
        return service.queryAll();
    }


}

