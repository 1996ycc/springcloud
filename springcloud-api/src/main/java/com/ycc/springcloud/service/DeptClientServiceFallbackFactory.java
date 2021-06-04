package com.ycc.springcloud.service;

import com.ycc.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//降级~
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            public Dept queryById(Long id) {
                return new Dept()
                        .setDNo(id)
                        .setDName("id=>"+id+"没有对应的信息,客户端提供了降级的信息，这个服务现在已经被关闭了~")
                        .setDb_source("没有数据~");
            }

            public List<Dept> queryAll() {
                return null;
            }

            public boolean addDept(Dept dept) {
                return false;
            }
        } ;
    }
}
