package org.example.impl;

import org.example.inter.MaxCalculator;

public class MaxCalculatorImpl implements MaxCalculator{

    @Override
    public double max(double firstOperand, double secondOperand) {
        double result = (firstOperand >= secondOperand) ? firstOperand : secondOperand;
        System.out.println("The Max is: " + result);
        return result;
    }
    
}
