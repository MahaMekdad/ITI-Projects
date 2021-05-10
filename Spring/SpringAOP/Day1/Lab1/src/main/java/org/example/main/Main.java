package org.example.main;

import org.example.factory.CalculatorFactory;
import org.example.impl.CalculatorImpl;
import org.example.inter.Calculator;
import org.example.proxy.AbstractProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String [] args){
        CalculatorFactory calculatorFactory = new CalculatorFactory();

        // System.out.println(calculatorFactory.getTargetWithAdvice().add(5, 5));
        // System.out.println(calculatorFactory.getTargetWithAdvice().sub(5, 5));
        // System.out.println(calculatorFactory.getTargetWithAdvice().multi(5, 5));
        // System.out.println(calculatorFactory.getTargetWithAdvice().div(5, 5));

        // System.out.println("-----------------------");

        // Calculator calc = new CalculatorImpl();
        // Calculator calc2 = (Calculator) AbstractProxy.newInstance(calc);
        // System.out.println(calc2.add(5, 5));
        // System.out.println(calc2.sub(5, 5));
        // System.out.println(calc2.multi(5, 5));
        // System.out.println(calc2.div(5, 0));

        // System.out.println("-----------------------");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // Calculator springCalc = context.getBean("calcProxy", Calculator.class);
        // springCalc.add(50, 50);

        Calculator springCalc2 = context.getBean("calcProxy2", Calculator.class);
        springCalc2.add(50, 50);
        springCalc2.sub(50, 3);

    }
}
