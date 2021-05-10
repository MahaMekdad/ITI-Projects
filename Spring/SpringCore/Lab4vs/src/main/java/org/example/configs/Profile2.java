package org.example.configs;

import org.example.services.impls.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class Profile2 {
    
    @Bean
    public AccountServiceImpl p2() throws Exception {
        System.out.println("inside the method of the development profile");
        return new AccountServiceImpl();
    }

}
