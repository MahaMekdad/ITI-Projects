package org.example.services.impls;

import org.example.daos.Dao1;
import org.example.daos.Dao2;
import org.example.services.Service2;
import org.example.services.Service3;

public class Service2Impl implements Service2{

    private Dao1 d1;
    private Dao2 d2;


    public void init(){
        System.out.println("From the init() method in Service2Impl class as an initialization callback");
        System.out.println("****");
    }

    public void destroy(){
        System.out.println("From the destroy() method in Service2Impl class as an initialization callback");
        System.out.println("****");
    }

    public Service2Impl(){
        System.out.println("Service2Impl default constructor");
        System.out.println("****");
    }
    public Service2Impl(Dao1 d1){
        System.out.println("Dao1 arg: hello from the Service2Impl constructor");
        System.out.println("****");
        this.d1 = d1;
    }

    public Service2Impl(Dao2 d2){
        System.out.println("Dao2 arg: hello from the Service2Impl constructor");
        System.out.println("****");
        this.d2 = d2;
    }

    public Service2Impl(Dao1 d1, Dao2 d2){
        System.out.println("2 daos args: hello from the Service2Impl constructor");
        System.out.println("****");
        this.d1 = d1;
        this.d2 = d2;
    }

    public Service2Impl(Service3 s3){
        System.out.println("1 arg s3: hi from the Service2Impl constructor that has an interface reference arg");
        System.out.println("****");
    }

    public Service2Impl(Service3Impl s3Impl){
        System.out.println("1 arg s3Impl: hi from the Service2Impl constructor that has an impl class reference arg");
        System.out.println("****");
    }

    @Override
    public void operation1() {
        System.out.println("lalalalala inside the operation1() of the Service2Impl class");
    }
}
