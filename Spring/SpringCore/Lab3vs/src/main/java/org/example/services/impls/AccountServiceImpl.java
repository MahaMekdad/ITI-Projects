package org.example.services.impls;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.daos.inters.AccountDao;
import org.example.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    // private AccountDao accountDao2;

    public AccountServiceImpl(){
        System.out.println("From the AccountServiceImpl() default constructor");
        System.out.println("****");
    }

    public AccountServiceImpl(AccountDao accDao){
        System.out.println("From the AccountServiceImpl(AccountDao accDao) constructor");
        accountDao = accDao;
        System.out.println("****");
    }

    @Resource
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
        System.out.println("From the setAccountDao(), " + this.accountDao);
        System.out.println("****");
    }

    // @Inject
    // public void setAccountDao2(@Named("accountDao2") AccountDao accountDao2) {
    //     this.accountDao2 = accountDao2;
    //     System.out.println("From the setAccountDao(), " + this.accountDao2);
    //     System.out.println("****");
    // }

    @Override
    public void accSerOpr() {
        System.out.println("From the accSerOpr() method in AccountServiceImpl class");
    }

    public void init(){
        System.out.println("init() in AccountServiceImpl");
    }

    public void destroy(){
        System.out.println("destroy() in AccountServiceImpl");
    }
    
}
