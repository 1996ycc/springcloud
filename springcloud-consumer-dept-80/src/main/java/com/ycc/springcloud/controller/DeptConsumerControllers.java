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

    /**
     * 理解：消费者，不应该有service层
     * RestTemplate .... 供我们直接调用就可以了！注册到Spring中
     * (url，实体：Map，Class<T> responseType)
     */
    @Autowired
    private RestTemplate restTemplate;  // 提供多种便捷访问远程http服务的方法

    // Ribbon，我们这里的地址是一个变量，通过服务名来访问
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public Boolean addDept(@RequestBody Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> getAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }



}

