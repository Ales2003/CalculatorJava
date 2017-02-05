package ru.mail.ales2003.calculatorJava;
import java.math.BigDecimal;
import static java.math.MathContext.UNLIMITED;
import java.util.Scanner;
/*
java console calculator supports one operation
*/
public class Calculator {

    public static void main(String[] args) {
    Calculator twoNumberCalculatorBD = new Calculator();
    twoNumberCalculatorBD.run();
    }
    
    //Displays the result
    private void run(){
    BigDecimal operandOne = Calculator.getOperand();
    String operator = Calculator.getOperator();
    BigDecimal operandTwo = Calculator.getOperand();
    BigDecimal result = Calculator.twoNubersCalculate (operandOne, operandTwo, operator);
    System.out.println("You result is "+result);
    }
    
    //Returns the result of calculation of the two numbers    
    private static BigDecimal twoNubersCalculate (BigDecimal operandOne, BigDecimal operandTwo, String operator){
        BigDecimal result = null;
        switch (operator){
            case "+": result = operandOne.add(operandTwo);
                     break;
            case "-": result = operandOne.subtract(operandTwo);
                     break;
            case "*": result = operandOne.multiply(operandTwo);
                     break;
            case "/": result = operandOne.divide(operandTwo, 33, BigDecimal.ROUND_HALF_EVEN);
                     break;
            case "^": 
                     double one = operandOne.doubleValue();
                     double two = operandTwo.doubleValue();
                     String tempResult = ""+Math.pow(one, two);
                     result = new BigDecimal (tempResult, UNLIMITED);
                     break;
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
 