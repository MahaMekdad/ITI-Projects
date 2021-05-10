package org.example.configs;

import org.example.daos.impls.AccountDao1Impl;
import org.example.daos.inters.AccountDao;
import org.example.services.AccountService;
import org.example.services.impls.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
// @ComponentScan(basePackages = "org.example")
public class AppConfig {

    @Bean(name = "acccc")
    // @Bean({"acccc", "acccc2"})
    @Scope("prototype")
    public AccountDao acc(){
        System.out.println("inside the called acc() method <-----------");
        AccountDao1Impl a = new AccountDao1Impl();
        // init();
        return a;
    }

    public void init(){
        System.out.println("init()");
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AccountService acc2(AccountDao accountDao){
        return new AccountServiceImpl();
    }

    // @Bean
    // @Qualifier("lol")
    // public AccountDao account(){
    //     System.out.println("inside the called account() method <-----------");
    //     AccountDao1Impl a = new AccountDao1Impl();
    //     return a;
    // }

    @Bean
    public AccountService accSer1(){
        return new AccountServiceImpl(acc());
    }

    @Bean
    public AccountService accSer2(){
        return new AccountServiceImpl(acc());
    }
    
}
