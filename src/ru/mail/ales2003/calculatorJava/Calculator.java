
package ru.mail.ales2003.calculatorJava;
import java.math.BigDecimal;
import static java.math.MathContext.DECIMAL64;
import static java.math.MathContext.UNLIMITED;
import java.util.Scanner;
/*
java console calculator supports one operation
*/
public class Calculator {

    
    
    //Displays the result
    protected void run(){
        lable:
        while(true){
            try{
                BigDecimal operandOne = Calculator.getOperand();
                String operator = Calculator.getOperator();
                BigDecimal operandTwo = Calculator.getOperand();
                BigDecimal result = Calculator.calculate (operandOne, operandTwo, operator);
                System.out.println("You result is "+result);
                System.out.println("================================================");
            }
            catch (RuntimeException e) {
                System.out.println(e);
                continue;
            }
        }
    }
    
    //Returns the result of calculation of the two numbers    
    private static BigDecimal calculate (BigDecimal one, BigDecimal two, String operator) {
        BigDecimal result = null;
        try {
        switch (operator){
            case "+": result = one.add(two);
                     break;
            case "-": result = one.subtract(two);
                     break;
            case "*": result = one.multiply(two);
                     break;
            case "/": result = one.divide(two, 33, BigDecimal.ROUND_HALF_EVEN);
                     break;
            case "^": 
                     double tmpOne = one.doubleValue();
                     double tmpTwo = two.doubleValue();
                     String tmpResult = ""+Math.pow(tmpOne, tmpTwo);
                     result = new BigDecimal (tmpResult);
                     break;
        }
        
        } catch (NumberFormatException e) {
            throw new NumberFormatException("One of You operands is to big for calculation. Try calculation again");
        }
        return result;
    }
       
    //Returns an operand
    private static BigDecimal getOperand(){
        Scanner sc = new Scanner(System.in);
        BigDecimal operand = null;
        while (true) {
            try {
                System.out.println("Enter the operand and press enter. "
                        + "Please enter only numbers. "
                        + "For fractional numbers, use separator point '.'");
                operand = new BigDecimal(sc.nextLine());
                break;
            } 
            catch (NumberFormatException e) {
                System.out.println("Incorrect operand. Try again.");
                continue;
            }
        }
        return operand;
    }
    
    //Returns an operator
    private static String getOperator(){
        Scanner sc = new Scanner(System.in);
        String operator = null;
        while (true) {
                    System.out.println("Enter the operator and press enter. "
                            + "Only use one of the following: "
                            + "+   -   *   /   ^");
                    operator = sc.nextLine();
                    if ((operator.equals("*"))|
                        (operator.equals("/"))|
                        (operator.equals("+"))|
                        (operator.equals("-"))|
                        (operator.equals("^"))) {
                        break;
                    }
                    else { 
                        System.out.println("Incorrect operator. Try again.");
                        continue;
                    }
            }
        return operator;
    }
}
