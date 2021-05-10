package org.example.models;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Parent {

    private String name;
    private int age;
    private String email;
    private String phone;
    private List<String> addresses;
    private Map addressesMap;

    public Parent(){
        System.out.println("inside the Parent default constr");
    }

    public void init(){
        System.out.println("From the init() method in Parent class as an initialization callback");
        System.out.println("****");
    }

    public void destroy(){
        System.out.println("From the destroy() method in Parent class as an initialization callback");
        System.out.println("****");
    }
    
    public String toString(){
        return "Parent --> Name: " + this.name + " Age: " + this.age + " Email: " + email + " Phone: " + phone + " List: " + addresses + " Map: " + addressesMap;
    }
}
