package org.example.daos.impls;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.example.daos.inters.AccountDao;
import org.springframework.stereotype.Repository;

// @Repository("accDao")
public class AccountDao1Impl implements AccountDao{

    public AccountDao1Impl(){
        System.out.println("From the AccountDao1Impl() default constructor");
        System.out.println("****");
    }

    @PostConstruct
    public void init(){
        System.out.println("From the init() method in AccountDao1Impl class as an initialization callback");
        System.out.println("****");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("From the destroy() method in AccountDao1Impl class as an pre destroy callback");
        System.out.println("****");
    }

    @Override
    public void op1() {
        System.out.println("From the op1() method in AccountDao1Impl class");
    }
    
}
