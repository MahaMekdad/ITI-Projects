package org.example.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MainAdviceAnno{

    @Pointcut("execution(* *.*..*(..))")
    private void common(){}

    // @Around("execution(* *.*..*(..))")
    @Around("common()")
    public Object aroundAdviceM(ProceedingJoinPoint pjo) throws Throwable {
        System.out.println("Around Advice, ");
        System.out.println("The Before Advice, ");
        System.out.println("The Method: " + pjo.getSignature().getName() + ",");
        System.out.println("The Arguments: " + Arrays.toString(pjo.getArgs()) + ".");
        System.out.println("");
        Object result = null;
        try{
            result = pjo.proceed();
            System.out.println("After Proceeding with The Advice, ");
            System.out.println("");
        } catch(IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    // @Before("execution(* *.*..*(..))")
    @Before("common()")
    public void beforeM(JoinPoint joinPoint) throws Throwable {
        System.out.println("Before Advice, ");
        System.out.println("The Method: " + joinPoint.getSignature().getName() + ",");
        System.out.println("The Arguments: " + Arrays.toString(joinPoint.getArgs()) + ".");
        System.out.println("");
    }

    @After("execution(* org.example.impl..add(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("After Advice, ");
        System.out.println("The Method: " + joinPoint.getSignature().getName() + ",");
        System.out.println("The Arguments: " + Arrays.toString(joinPoint.getArgs()) + ".");
        System.out.println("");
    }

    @AfterReturning(returning = "result", pointcut ="execution(* *.*..*(..))")
    public void afterReturningM(JoinPoint joinPoint, Object result) throws Throwable {
        System.out.println("After Returning Advice, ");
        System.out.println("The Method: " + joinPoint.getSignature().getName() + ",");
        System.out.println("The Arguments: " + Arrays.toString(joinPoint.getArgs()) + ".");
        System.out.println("The Return: " + result + ".");
        System.out.println("");
    }

    @AfterThrowing(pointcut ="execution(* *.*..*(..))", throwing ="exception")
    public void afterThrowingM(JoinPoint joinPoint, Exception exception) throws Throwable{
        System.out.println("After Throwing Advice, ");
        System.out.println("The Method: " + joinPoint.getSignature().getName() + ",");
        System.out.println("The Arguments: " + Arrays.toString(joinPoint.getArgs()) + ".");
        System.err.println(exception.getMessage());
        System.out.println("");
    }
    
}
