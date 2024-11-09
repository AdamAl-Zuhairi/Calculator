package org.example;

public class Log implements SingleOperand{
    @Override
    public double execute(double operand) {
        return Math.log10(operand);
    }
}
