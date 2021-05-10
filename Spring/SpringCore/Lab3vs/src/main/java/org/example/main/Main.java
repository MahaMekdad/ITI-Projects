package org.example.main;

import org.example.configs.AppConfig;
import org.example.daos.inters.AccountDao;
import org.example.services.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String [] args){
        System.out.println("-------Instantiations-------");
        // ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("components.xml");
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.print("");
        System.out.println("-------Methods' Prints-------");

        // AccountDao accountDao = context2.getBean("accDao", AccountDao.class);
        // accountDao.op1();

        // AccountService accountService = context2.getBean("accountServiceImpl", AccountService.class);
        // accountService.accSerOpr();

        //------------------------------------

        // AccountDao accDao = context2.getBean(AccountDao.class);
        // AccountDao accDao = context2.getBean("acccc", AccountDao.class);
        // accDao.op1();
        // AccountDao accDao2 = context2.getBean("acccc2", AccountDao.class);
        // System.out.println((accDao == accDao2) + " <----");

        // context.registerShutdownHook();
        // context.close();
    }
}
