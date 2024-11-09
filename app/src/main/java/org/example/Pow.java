package org.example;

public class Pow implements MultipleOperand {
    public double execute(double operand1, Double operand2){
        if (operand2 == null) throw new IllegalArgumentException("To the power of requires two operands.");
        return Math.pow(operand1, operand2);
    }
}
