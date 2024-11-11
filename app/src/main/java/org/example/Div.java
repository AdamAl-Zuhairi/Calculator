package org.example;

public class Div implements MultipleOperand{
    public double execute(double operand1, Double operand2){
        if(operand2 == 0){
            throw Exceptions.divideByZero();
        }
        if (operand2 == null){
            throw Exceptions.twoInputsRequired();
        }
        return operand1/operand2;
    }
}
