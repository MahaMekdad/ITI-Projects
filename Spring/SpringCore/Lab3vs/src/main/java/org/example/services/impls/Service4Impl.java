package org.example.services.impls;

import org.example.services.Service3;

public class Service4Impl implements Service3{

    public Service4Impl(){
        System.out.println("hello from the Service4Impl constructor");
        System.out.println("****");
    }

    @Override
    public void lol() {
        System.out.println("inside lol method from Service4Impl obj");
    }
    
}
