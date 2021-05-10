package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.example.advice.CalculatorAdvice;
import org.example.inter.Calculator;

public class CalculatorProxy implements InvocationHandler{
    
    Calculator target;
    CalculatorAdvice advice;

    public CalculatorProxy(Calculator target, CalculatorAdvice advice){
        this.target = target;
        this.advice = advice;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        double result = 0.0;
        double firstOperand = (Double) args[0];
        double secondOperand = (Double) args[1];
        switch(method.getName()){
            case "add":
                try{
                    advice.before(firstOperand, "+", secondOperand);
                    //result = (double) method.invoke(target, args);
                    result = target.add(firstOperand, secondOperand);
                    advice.after(result);
                } catch (Exception exception){
                    advice.afterThrowing(exception);
                }
                break;
            case "sub":
                try{
                    advice.before(firstOperand, "-", secondOperand);
                    //result = (double) method.invoke(target, args);
                    result = target.sub(firstOperand, secondOperand);
                    advice.after(result);
                } catch (Exception exception){
                    advice.afterThrowing(exception);
                }
                break;
            case "multi":
                try{
                    advice.before(firstOperand, "*", secondOperand);
                    //result = (double) method.invoke(target, args);
                    result = target.multi(firstOperand, secondOperand);
                    advice.after(result);
                } catch (Exception exception){
                    advice.afterThrowing(exception);
                }
                break;
            case "div":
                try{
                    advice.before(firstOperand, "/", secondOperand);
                    //result = (double) method.invoke(target, args);
                    result = target.div(firstOperand, secondOperand);
                    advice.after(result);
                } catch (Exception exception){
                    advice.afterThrowing(exception);
                }
                break;
        }
        return result;
    }
}
