package org.example;

import javax.swing.JOptionPane;

public class Exceptions extends RuntimeException  {
    public Exceptions(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message);
    }

    public static Exceptions divideByZero(){
        return new Exceptions("Cannot divide by zero.");
    }

    public static Exceptions twoInputsRequired(){
        return new Exceptions("The operation requires two inputs");
    }
    public static Exceptions invalidOperator(){
        return new Exceptions("The operator does not exist");
    }

    public static Exceptions invalidOperation(){
        return new Exceptions("The operation does not exist");
    }
}
