package org.example.models;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Child {
    
    private String name;
    private int age;
    private String email;
    private String phone;
    private List<String> addresses;
    private Map addressesMap;

    public Child(){
        System.out.println("inside the Child default constr");
    }

    public void init(){
        System.out.println("From the init() method in Child class as an initialization callback");
        System.out.println("****");
    }

    public String toString(){
        return "Child --> Name: " + this.name + " Age: " + this.age + " Email: " + email + " Phone: " + phone + " List: " + addresses + " Map: " + addressesMap;
    }
}
