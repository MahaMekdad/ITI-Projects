package org.example.models;

public class Circular2 {

    private Circular1 c1;

    // public Circular2(){
    //     System.out.println("hello from the Circular2 default constructor");
    //     System.out.println("****");
    // }

    public Circular2(Circular1 c1){
        System.out.println("hello from the Circular2 constructor that need as arg an obj of Circular1 class");
        System.out.println("****");
        this.c1 = c1;
    }

    public void setC1(Circular1 c1){
        this.c1 = c1;
    }
}
