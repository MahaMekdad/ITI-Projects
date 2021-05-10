package org.example.configs;

import org.example.services.Service1;
import org.example.services.impls.Service1Impl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(AppConfig.class)
public class AppConfig2 {
    
    @Bean
    public Service1 createS1(Service1 service1){
        System.out.println("inside the called s1() method that will create a bean of Service1Impl");
        return new Service1Impl(service1);
    }
}
