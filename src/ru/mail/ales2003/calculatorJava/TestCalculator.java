
package ru.mail.ales2003.calculatorJava;

import java.math.BigDecimal;

public class TestCalculator {
    
    public static void main(String[] args) {
        
        checkEquals(BigDecimal.valueOf(3.1), Calculator.add(BigDecimal.valueOf(2),
                     BigDecimal.valueOf(1.1)));
        
        checkEquals(BigDecimal.valueOf(0.9), Calculator.dif(BigDecimal.valueOf(2),
                     BigDecimal.valueOf(1.1)));
        
        checkEquals(BigDecimal.valueOf(2.2), Calculator.multiply(BigDecimal.valueOf(2),
                     BigDecimal.valueOf(1.1)));
        
        checkEquals(new BigDecimal("20.000000000000000"), Calculator.divide(BigDecimal.valueOf(2),
                     BigDecimal.valueOf(0.1)));
        
        checkEquals(BigDecimal.valueOf(8), Calculator.pow(BigDecimal.valueOf(2),
                     BigDecimal.valueOf(3)));
        
    }
    
    public static void checkEquals(BigDecimal expected, BigDecimal actual){
        if (!expected.equals(actual)){
            throw new AssertionError("expected = '"+expected+"' but actual = '"+actual+"'");
        }
    }
}
