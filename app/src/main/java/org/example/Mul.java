package org.example;

public class Mul implements Operand {
    public double execute(double operand1, Double operand2){
        if (operand2 == null) throw new IllegalArgumentException("Multiplication requires two operands.");
        return operand1*operand2;
    }
}
