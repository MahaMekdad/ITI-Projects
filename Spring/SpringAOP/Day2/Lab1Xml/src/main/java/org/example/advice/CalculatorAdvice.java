package org.example.advice;

public class CalculatorAdvice {
    
    public void before(double fo, String op, double so){
        System.out.println(fo + op + so);
    }

    public void after(double result){
        System.out.println("result is: " + result);
    }

    public void afterThrowing(Exception exception){
        System.err.println(exception.getMessage());
    }
}
