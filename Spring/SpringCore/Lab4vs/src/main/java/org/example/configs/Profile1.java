package org.example.configs;

import org.example.daos.impls.AccountDao1Impl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class Profile1 {
    
    @Bean
    public AccountDao1Impl p1() throws Exception {
        System.out.println("inside the method of the production profile");
        return new AccountDao1Impl();
    }
}
