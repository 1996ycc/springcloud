package com.ycc.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { // @Configuration  -- spring applicationContext.xml
    // 配置负载均衡  实现RestTemplate
    // IRule
    // RandomRule     随机
    // RoundRobinRule 轮询
    // RetryRule  会先按照轮询获取服务，如果失败，在指定时间内进行重试
    // AvailabilityFilteringRule : 会过滤掉跳闸访问故障的服务，对剩下的服务进行轮询

    @Bean
    @LoadBalanced  //Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
