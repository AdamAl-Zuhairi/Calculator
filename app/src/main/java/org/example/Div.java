package org.example;

public class Div implements Operand{
    public double execute(double operand1, double operand2){
        if(operand2 == 0){
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return operand1/operand2;
    }
}
