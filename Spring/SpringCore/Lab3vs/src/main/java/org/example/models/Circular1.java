package org.example.models;

public class Circular1 {

    private Circular2 c2;

    // public Circular1(){
    //     System.out.println("hello from the Circular1 default constructor");
    //     System.out.println("****");
    // }

    public Circular1(Circular2 c2){
        System.out.println("hello from the Circular1 constructor that need as arg an obj of Circular2 class");
        System.out.println("****");
        this.c2 = c2;
    }

    public void setC2(Circular2 lol){
        this.c2 = lol;
    }
}
