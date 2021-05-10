package org.example.services.impls;

import org.example.services.Service3;

public class Service3Impl implements Service3{

    public Service3Impl(){
        System.out.println("hello from the Service3Impl's default constructor");
        System.out.println("****");
    }

    public Service3Impl(int num){
        System.out.println("1arg: inside the int constructor");
        System.out.println("****");
    }

    public Service3Impl(String st){
        System.out.println("1arg: inside the string constructor");
        System.out.println("****");
    }

    public Service3Impl(int num, String st){
        System.out.println("2args: inside the int & String constructor");
        System.out.println("****");
    }

    @Override
    public void lol() {
        System.out.print("inside the lol method of the service3Impl obj");
    }
    
}
