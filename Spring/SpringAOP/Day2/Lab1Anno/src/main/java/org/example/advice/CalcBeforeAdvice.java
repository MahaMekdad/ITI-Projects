package org.example.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(0)
public class CalcBeforeAdvice {
    
    @Before("execution(* *.*..*(..))")
    public void beforeM(JoinPoint joinPoint) throws Throwable {
        System.out.println("Before Advice From the CalcBeforeAdvice class, trying the @Order Anno");
    }
}
