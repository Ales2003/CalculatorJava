
package ru.mail.ales2003.calculatorJava;
import java.math.BigDecimal;
import java.util.Scanner;
/*
java console calculator supports one operation
*/
public class Calculator {

    //Displays the result
    protected void run(){
        while(true){
            try{
                System.out.println("================================================");
                BigDecimal operandOne = getOperand();
                String operator = getOperator();
                BigDecimal operandTwo = getOperand();
                BigDecimal result = calculate (operandOne, operandTwo, operator);
                System.out.println("You result is "+result);
                System.out.println("================================================");
            }
            catch (RuntimeException e) {
                System.out.println(e);
            }
        }
    }
    
    //Returns the result of calculation of the two numbers    
    private static BigDecimal calculate (BigDecimal one, BigDecimal two, String operator) {
        BigDecimal result = null;
        switch (operator){
            case "+": result = add(one, two);
                     break;
            case "-": result = dif(one, two);
                     break;
            case "*": result = multiply(one, two);
                     break;
            case "/": result = divide(one, two);
                     break;
            case "^": result = pow(one, two);
                     break;
        }
        return result;
    }
    
    //Returns the result of addition
    protected static BigDecimal add(BigDecimal one, BigDecimal two){
        return one.add(two);
    }
    
    //Returns the result of subtraction
    protected static BigDecimal dif(BigDecimal one, BigDecimal two){
        return one.subtract(two);
    }
    
    //Returns the result of multiplication
    protected static BigDecimal multiply(BigDecimal one, BigDecimal two){
        return one.multiply(two);
    }
    
    //Returns the result of division
    protected static BigDecimal divide(BigDecimal one, BigDecimal two){
        return one.divide(two, 15, BigDecimal.ROUND_HALF_EVEN);
    }
    
    //Returns the result of involution to power
    protected static BigDecimal pow(BigDecimal one, BigDecimal two){
        try {
            double tmpOne = one.doubleValue();
            double tmpTwo = two.doubleValue();
            double tmpResult = Math.pow(tmpOne, tmpTwo);
            return new BigDecimal(tmpResult);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("One of operands is to big for calculation. Try calculation again");
        }
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
                    }
            }
        return operator;
    }
}
