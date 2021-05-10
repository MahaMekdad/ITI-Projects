package org.example.impl;

import org.example.inter.Calculator;

public class CalculatorImpl implements Calculator{

    @Override
    public double add(double firstOperand, double secondOperand) throws ArithmeticException {
        double result = firstOperand + secondOperand;
        return result;
    }

    @Override
    public double sub(double firstOperand, double secondOperand) throws ArithmeticException {
        double result = firstOperand - secondOperand;
        return result;
    }

    @Override
    public double multi(double firstOperand, double secondOperand) throws ArithmeticException {
        double result = firstOperand * secondOperand;
        return result;
    }

    @Override
    public double div(double firstOperand, double secondOperand) throws ArithmeticException {
        double result = firstOperand / secondOperand;
        return result;
    }
    
}
