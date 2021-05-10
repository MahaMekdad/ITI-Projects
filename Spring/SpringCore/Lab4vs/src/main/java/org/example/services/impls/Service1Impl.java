package org.example.services.impls;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.example.customUtils.customQualifiers.DaoQualifier;
import org.example.daos.Dao1;
import org.example.services.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Service1Impl implements Service1{

    // @Autowired
    // @Qualifier("daoQualifier")
    // @DaoQualifier(name = "daoCusQualifier", code = "15x")
    private Dao1 dao1;

    // @PostConstruct
    // public void init(){
    //     System.out.println("From the init() method in Service1Impl class as an initialization callback");
    //     System.out.println("****");
    // }

    // @PreDestroy
    // public void destroy(){
    //     System.out.println("From the destroy() method in Service1Impl class as an initialization callback");
    //     System.out.println("****");
    // }

    public Service1Impl(){
        System.out.println("From the Service1Impl() contr in Service1Impl class");
    }

    public Service1Impl(Service1 service1){
        System.out.println("From the Service1Impl(Service1 service1) contr in Service1Impl class");
    }

    // if im gonna do the autowiring using the constructor based then the @Qualifier goes before the arg in the brackets

    // having the default constructor and @Autowired on the field does the following
    // creating an obj of Service1Impl with field dao1 = null
    // then initializing the field doa1 and the obj is no longer with a null doa field
    // public Service1Impl(){
    //     System.out.println("hello from the Service1Impl constructor, " + this.dao1);
    //     System.out.println("****");
    // }

    // this autowire is made byType
    // @Autowired
    // @Autowired(required = false)
    // public Service1Impl(Dao1 dao1){
    //     this.dao1 = dao1;
    //     System.out.println("hello from the Service1Impl(Dao1 dao1) constructor, " + this.dao1);
    //     System.out.println("****");
    // }

    // @Autowired
    // @Required wala bt3ml ay 7aga
    // public void setDao1(Dao1 dao1){
    //     this.dao1 = dao1;
    //     System.out.println("hello from the setDao1(Dao1 dao1) setter, " + this.dao1);
    //     System.out.println("****");
    // }

    @Override
    public void service1Operation() {
        System.out.println("Hi from service1Operation(), " + this + ", " + this.dao1); 
    }

    // got a warning that Autowired annotation should only be used on methods with parameters.
    // @Autowired
    // @Qualifier("daoQualifier")
    public void setUpMethod(Dao1 dao1){
        System.out.println("this is just a method that is called with initializing the bean" + 
        "or after the Service1Impl obj is created to do whatever setup stuff needed for the obj maybe");
    }
    
}
