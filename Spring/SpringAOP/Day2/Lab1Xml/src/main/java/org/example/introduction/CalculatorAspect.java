package org.example.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.example.impl.MaxCalculatorImpl;
import org.example.impl.MinCalculatorImpl;
import org.example.inter.MaxCalculator;
import org.example.inter.MinCalculator;

@Aspect
public class CalculatorAspect {
    
    @DeclareParents(defaultImpl = MaxCalculatorImpl.class, value="org.example.impl.CalculatorImpl")
    public MaxCalculator maxCalculator;

    @DeclareParents(defaultImpl = MinCalculatorImpl.class, value="org.example.impl.CalculatorImpl")
    public MinCalculator minCalculator;
}
