package org.example.configs;

import org.example.daos.impls.AccountDao1Impl;
import org.example.daos.inters.AccountDao;
import org.example.services.AccountService;
import org.example.services.Service1;
import org.example.services.impls.AccountServiceImpl;
import org.example.services.impls.Service1Impl;
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

    // public void init(){
    //     System.out.println("init()");
    // }

    // @Bean
    // public AccountService acc2(AccountDao accountDao){
    //     return new AccountServiceImpl();
    // }

    // -------Instantiations-------
    // inside the called acc() method <-----------
    // From the AccountDao1Impl() default constructor
    // ****
    // From the AccountServiceImpl() default constructor
    // ****
    // inside the called acc() method <-----------
    // From the AccountDao1Impl() default constructor
    // ****

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

    // @Bean
    // public Service1 s1(){
    //     System.out.println("inside the called s1() method in AppConfig");
    //     return new Service1Impl();
    // }
    
}
