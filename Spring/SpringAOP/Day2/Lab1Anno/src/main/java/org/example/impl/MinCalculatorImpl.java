package org.example.impl;

import org.example.inter.MinCalculator;

public class MinCalculatorImpl implements MinCalculator{

    @Override
    public double min(double firstOperand, double secondOperand) {
        double result = (firstOperand <= secondOperand) ? firstOperand : secondOperand;
        System.out.println("The Max is: " + result);
        return result;
    }
    
}
