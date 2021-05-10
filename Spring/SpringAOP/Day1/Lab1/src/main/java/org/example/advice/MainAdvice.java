package org.example.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class MainAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice, MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation arg0) throws Throwable {
        System.out.println("Around Advice, ");
        System.out.println("The Before Advice, ");
        System.out.println("The Method: " + arg0.getMethod().getName() + ",");
        System.out.println("The Arguments: " + Arrays.toString(arg0.getArguments()) + ".");
        Object result = null;
        try{
            result = arg0.proceed();
            System.out.println("After Proceeding with The Advice, ");
        } catch(IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    @Override
    public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
        System.out.println("After Returning Advice, ");
        System.out.println("The Method: " + arg1.getName() + ",");
        System.out.println("The Arguments: " + Arrays.toString(arg2) + ".");
        System.out.println("The Return: " + arg0 + ".");
    }

    @Override
    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
        System.out.println("Before Advice, ");
        System.out.println("The Method: " + arg0.getName() + ",");
        System.out.println("The Arguments: " + Arrays.toString(arg1) + ".");
    }

    public void afterThrowing(Exception exception){
        System.err.println(exception.getMessage());
    }
    
}
