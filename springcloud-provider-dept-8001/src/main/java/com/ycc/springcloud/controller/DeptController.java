package com.ycc.springcloud.controller;

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

    @Autowired
    private DiscoveryClient client;

    /***
     * ccyu 2021/6/1
     * 新增方法
     * @param dept
     * @return
     */
    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @RequestMapping("/dept/discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println(services);

        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for ( ServiceInstance  instance: instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getInstanceId()
            );
        }
        return this.client;
    }

}
