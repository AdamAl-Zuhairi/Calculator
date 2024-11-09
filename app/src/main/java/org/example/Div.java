package org.example;

public class Div implements MultipleOperand{
    public double execute(double operand1, Double operand2){
        if(operand2 == 0){
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        if (operand2 == null) throw new IllegalArgumentException("Division requires two operands.");
        return operand1/operand2;
    }
}
