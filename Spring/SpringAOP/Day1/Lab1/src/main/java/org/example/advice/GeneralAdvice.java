package org.example.advice;

public class GeneralAdvice {
    public void before(Object [] args) {
        for(Object argument : args){
            System.out.println(argument);
        }
    }

    public void after(Object result){
        System.out.println("return is: " + result);
    }

    public void afterThrowing(Exception exception){
        System.err.println(exception.getMessage());
    }
}
