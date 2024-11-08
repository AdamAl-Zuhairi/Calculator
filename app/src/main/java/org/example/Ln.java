package org.example;

public class Ln implements Operand {
    @Override
    public double execute(double operand1, Double operand2) {
        if (operand2!=null) throw new IllegalArgumentException("ln requires one operands.");
        return Math.log(operand1);
    }
}
