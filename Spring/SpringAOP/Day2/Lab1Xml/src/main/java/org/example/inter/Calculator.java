package org.example.inter;

public interface Calculator {

    double add(double firstOperand, double secondOperand) throws ArithmeticException;

    double sub(double firstOperand, double secondOperand) throws ArithmeticException;

    double multi(double firstOperand, double secondOperand) throws ArithmeticException;

    double div(double firstOperand, double secondOperand) throws ArithmeticException;
    
}
