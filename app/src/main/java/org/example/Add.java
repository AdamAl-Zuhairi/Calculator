package org.example;

public class Add implements MultipleOperand{
    public double execute(double operand1, Double operand2){
        if (operand2 == null) throw new IllegalArgumentException("Addition requires two operands.");
        return operand1 + operand2;
    }
}
