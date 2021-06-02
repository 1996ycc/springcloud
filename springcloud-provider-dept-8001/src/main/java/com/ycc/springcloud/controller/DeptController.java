package com.ycc.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ycc.springcloud.pojo.Dept;
import com.ycc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 提供Restful服务！
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService ;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if(dept == null){
            throw new RuntimeException("id=>"+id+"，不存在该用户，或者信息无法找到！");
        }
        return dept;
    }

    // 备选方法
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept().setDNo(id).setDName("id=>"+id+"没有对应的信息,null---");
    }


}
