package org.example;

public class Ln implements SingleOperand {
    @Override
    public double execute(double operand) {
        return Math.log(operand);
    }
}
