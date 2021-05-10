package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestClass {

    private String st;

    // public TestClass(){
    // System.out.println("hello from the TestClass constructor");
    // System.out.println("***");
    // }

    public void setSt(String st) {
        this.st = st;
    }

    public String getSt() {
        System.out.println("String Property :"  + st);
        return this.st;
    }

    public void testMethod() {
        System.out.println("hey from the test method that does nothing and here's the props value");
    }
}
