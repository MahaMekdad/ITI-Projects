package org.example.services;

import org.example.daos.Dao1;
import org.example.daos.Dao2;
import org.example.services.impls.Service4Impl;

public class BeanFactory {

    public BeanFactory(){
        System.out.println("hello from the BeanFactory constructor");
    }

    public Service3 nonStaticS4Creation(){
        System.out.println("no args: hello from the nonStaticS4Creation factory method");
        Service4Impl s4 = new Service4Impl();
        return s4;
    }

    public Service3 nonStaticS4Creation(String nothing){
        System.out.println("1arg: hello from the nonStaticS4Creation factory method");
        Service4Impl s4 = new Service4Impl();
        return s4;
    }

    public String method(Dao1 d1, String nothing, Dao2 d2){
        System.out.println("inside the factory method 'method' that takes 3 args");
        System.out.println("****");
        return "lol";
    }
}
