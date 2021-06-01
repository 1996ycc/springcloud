package com.ycc.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestMyRule {
    /**
     * 随机
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
