package org.example.main;

import org.example.factory.CalculatorFactory;
import org.example.impl.CalculatorImpl;
import org.example.inter.Calculator;
import org.example.inter.MaxCalculator;
import org.example.inter.MinCalculator;
import org.example.proxy.AbstractProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String [] args){
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Calculator calculator = context.getBean("calcBeanId", Calculator.class);
        calculator.sub(58, 2);
        calculator.div(10, 5);

        // System.out.println("--------------------------------------------------------");

        // MaxCalculator maxCalc = (MaxCalculator) calculator;
        // maxCalc.max(5,6);
        // MinCalculator minCalc = (MinCalculator) calculator;
        // minCalc.min(80, 5);
    }
}
