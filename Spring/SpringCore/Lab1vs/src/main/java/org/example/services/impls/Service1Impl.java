package org.example.services.impls;

import org.example.services.Service1;

public class Service1Impl implements Service1{

    public void init(){
        System.out.println("From the init() method in Service1Impl class as an initialization callback");
        System.out.println("****");
    }

    public void destroy(){
        System.out.println("From the destroy() method in Service1Impl class as an initialization callback");
        System.out.println("****");
    }

    public Service1Impl(){
        System.out.println("hello from the Service1Impl constructor");
        System.out.println("****");
    }

    @Override
    public void operation1() {
        System.out.println("Hi from operation1"); 
    }
    
}
