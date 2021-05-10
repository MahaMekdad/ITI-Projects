package org.example.services;

public class Trial {
    Service1 service1;

    public Trial(Service1 service1){
        System.out.println("inside the constructor of the Trial class Trial(Service1 service1)");
        this.service1 = service1;
    }

    public void setService1(Service1 service1){
        System.out.println("inside the setter of the setService1(Service1 dao1) of Trial");
        this.service1 = service1;
    }

    public Service1 getService1(){
        System.out.println("inside the getter of the getService1() of Trial");
        return this.service1;
    }
}
