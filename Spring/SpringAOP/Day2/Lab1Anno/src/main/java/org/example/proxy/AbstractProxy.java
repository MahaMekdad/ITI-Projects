package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.example.advice.GeneralAdvice;

public class AbstractProxy implements InvocationHandler {

    private final Object target;
    private final GeneralAdvice advice = new GeneralAdvice();

    private AbstractProxy(Object target){
        this.target = target;
    }

    public static Object newInstance(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new AbstractProxy(obj));
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try{
            advice.before(args);
            result = method.invoke(target, args);
        } catch(Exception exception){
            advice.afterThrowing(exception);
        }
        advice.after(result);
        return result;
    }
    
}
