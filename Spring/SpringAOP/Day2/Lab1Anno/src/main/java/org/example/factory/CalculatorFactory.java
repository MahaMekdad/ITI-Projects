package org.example.factory;

import java.lang.reflect.Proxy;

import org.example.advice.CalculatorAdvice;
import org.example.impl.CalculatorImpl;
import org.example.inter.Calculator;
import org.example.proxy.CalculatorProxy;

public class CalculatorFactory {
    
    private final Calculator target;
    private final Calculator targetWithAdvice;

    public CalculatorFactory(){
        target = new CalculatorImpl();
        CalculatorAdvice advice = new CalculatorAdvice();
        CalculatorProxy proxy = new CalculatorProxy(target, advice);

        Class [] interfaces = new Class [] {Calculator.class};
        // targetWithAdvice = (Calculator) Proxy.newProxyInstance(new ClassLoader() {}, interfaces, proxy);
        targetWithAdvice = (Calculator) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), interfaces, proxy);

    }

    public Calculator getTargetWithAdvice(){
        return this.targetWithAdvice;
    }
}
