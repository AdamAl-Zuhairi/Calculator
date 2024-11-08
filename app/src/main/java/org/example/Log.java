package org.example;

public class Log implements Operand{
    @Override
    public double execute(double operand1, Double operand2) {
        if (operand2!=null) throw new IllegalArgumentException("log requires two operands.");
        return Math.log10(operand1);
    }
}
