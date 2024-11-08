package org.example;

public class Pow implements Operand {
    public double execute(double operand1, double operand2){
        return Math.pow(operand1, operand2);
    }
}
