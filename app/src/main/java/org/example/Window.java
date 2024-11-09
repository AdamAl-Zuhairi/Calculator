package org.example;

//TODO: Fixa färger och mer på design, ksk ta bort det tomma hörnet
//TODO: Fixa felmeddelanden, gör en egen klass bara för felmeddelanden (som XL projektet)
//TODO: Börja nytt projekt lol, den här var inte så svår

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Window extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField textField;
    private Map<String, Op> operations;
    String s0,s1,s2;

    Window() {
        s0 = s1 = s2 = "";
        operations = new HashMap<String, Op>();
        operations.put("+", new Add());
        operations.put("-", new Sub());
        operations.put("*", new Mul());
        operations.put("/", new Div());
        operations.put("^", new Pow());
        operations.put("log", new Log());
        operations.put("ln", new Ln());
        operations.put("sqrt", new Sqrt());
        operations.put("cos", new Cos());
        operations.put("sin", new Sin());
        operations.put("tan", new Tan());
    }
    
    public double calculate (double operand1, String operator, double operand2){
        Op currentOp = operations.get(operator);
        if(currentOp == null){
            throw new IllegalArgumentException("Invalid Operator");
        }
        if (currentOp instanceof SingleOperand) {
            return ((SingleOperand)currentOp).execute(operand1);
        }
        if(currentOp instanceof MultipleOperand) {
            return ((MultipleOperand)currentOp).execute(operand1, operand2);
        }
        else{
            throw new IllegalArgumentException("Invalid Operand");
        }
    }

    public void CreateCalculator() {
        frame = new JFrame("Calculator");
        textField = new JTextField(16);
        textField.setEditable(false);
        Window c = new Window();

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(textField, BorderLayout.CENTER);
        frame.add(p, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5)); // Layout for numeric and operator buttons
        JPanel extraPanel = new JPanel(new GridLayout(4, 2, 5, 5));  // Layout for additional functions
        JPanel controlPanel = new JPanel(new GridLayout(1, 3, 5, 5));

        JButton[] numButtons = new JButton[10];
        for (int i = 0; i <= 9; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(c);
            numButtons[i].setBackground(Color.magenta);
        }

        JButton[] opButtons = new JButton[operations.size()];
        int index = 0;
        for (String o : operations.keySet()) {
            opButtons[index] = new JButton(o);
            opButtons[index].addActionListener(c);
            opButtons[index].setBackground(Color.PINK);
            index++;
        }

        JButton e = new JButton("e");
        JButton pi = new JButton("PI");
        JButton beq1 = new JButton("=");
        JButton beq = new JButton("C");
        JButton be = new JButton(".");
        JButton exit = new JButton("Exit");

        e.addActionListener(c);
        pi.addActionListener(c);
        beq1.addActionListener(c);
        beq.addActionListener(c);
        be.addActionListener(c);
        exit.addActionListener(c);

        be.setBackground(Color.pink);
        pi.setBackground(Color.pink);
        e.setBackground(Color.pink);
        beq1.setBackground(Color.green);

        buttonPanel.add(numButtons[7]);
        buttonPanel.add(numButtons[8]);
        buttonPanel.add(numButtons[9]);
        buttonPanel.add(opButtons[6]); //div

        buttonPanel.add(numButtons[4]);
        buttonPanel.add(numButtons[5]);
        buttonPanel.add(numButtons[6]);
        buttonPanel.add(opButtons[10]); //multiplication

        buttonPanel.add(numButtons[1]);
        buttonPanel.add(numButtons[2]);
        buttonPanel.add(numButtons[3]);
        buttonPanel.add(opButtons[7]); //plus

        buttonPanel.add(be); //komma
        buttonPanel.add(numButtons[0]);
        buttonPanel.add(opButtons[8]); //minus
        buttonPanel.add(beq1); //lika med
        

        extraPanel.add(pi);
        extraPanel.add(e); // Division button
        extraPanel.add(opButtons[4]);
        extraPanel.add(opButtons[5]);
        extraPanel.add(opButtons[0]);
        extraPanel.add(opButtons[9]);
        extraPanel.add(opButtons[1]);
        extraPanel.add(opButtons[3]);
        extraPanel.add(opButtons[2]);

        

        controlPanel.add(beq); // Clear button
        controlPanel.add(exit);


        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(extraPanel, BorderLayout.EAST);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setSize(500, 400); // Adjust size as needed
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBackground(Color.lightGray);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String s = e.getActionCommand();
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;
 
            textField.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";
            textField.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'e') {
            if(s0.equals("")){
                s0 = Double.toString(Math.E);
            }
            else{
                s2 = Double.toString(Math.E);
            }
            textField.setText(s0 + s1 + s2);
        }
        else if (s.equals("PI")) {
            if(s0.equals("")){
                s0 = Double.toString(Math.PI);
            }
            else{
                s2 = Double.toString(Math.PI);
            }
            textField.setText(s0 + s1 + s2);
        }
        else if (operations.containsKey(s)) {
            s1 = s;
            textField.setText(s0 + s1);
            Op currentOpe = operations.get(s);

            //funkar nu men man måste skriva in siffra sen operation, finslipa sen
            //gör mer på design så man lär sig också
            if (currentOpe instanceof SingleOperand) {
                if (!s0.equals("")) {
                    double op1 = Double.parseDouble(s0);
                    double res = ((SingleOperand) currentOpe).execute(op1);
                    textField.setText(Double.toString(res));
                    s0 = Double.toString(res);
                    s1 = s2 = "";  // Reset after calculation
                }
        }
    }
        else if (s.equals("Exit")) {
            System.exit(0);
        }
        else if (s.charAt(0) == '=') {
            if (!s0.equals("")) {
                double op1 = Double.parseDouble(s0);
                Double op2 = s2.isEmpty() ? null : Double.parseDouble(s2);
                double res;
                Op current = operations.get(s1);
                if(current instanceof SingleOperand){
                    res = ((SingleOperand)current).execute(op1);
                }
                else if (current instanceof MultipleOperand && op2 != null){
                    res = ((MultipleOperand)current).execute(op1, op2);
                }
                else{
                    throw new IllegalArgumentException("Operation not supported");
                }

                textField.setText(Double.toString(res));
                s0 = Double.toString(res);
                s1 = s2 = "";
            }
        }
    }
}
