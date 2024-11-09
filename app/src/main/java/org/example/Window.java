package org.example;

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
        JPanel p = new JPanel();
        Window c = new Window();

        p.add(textField);
        for (int i = 0; i <= 9; i++){
            JButton buttonsNum = new JButton(String.valueOf(i));
            buttonsNum.addActionListener(c);
            p.add(buttonsNum);
        }
        for (String o : operations.keySet()){
            JButton buttonsOp = new JButton(o);
            buttonsOp.addActionListener(c);
            p.add(buttonsOp);
        }

        JButton e = new JButton("e");
        JButton beq1 = new JButton("=");
        JButton beq = new JButton("C");
        JButton be = new JButton(".");
        JButton exit = new JButton("Exit");
        e.addActionListener(c);
        beq1.addActionListener(c);
        beq.addActionListener(c);
        be.addActionListener(c);
        exit.addActionListener(c);
        p.add(e);
        p.add(beq1);
        p.add(beq);
        p.add(be);
        p.add(exit);
        p.setBackground(Color.DARK_GRAY);
        frame.add(p);
        frame.setSize(200, 280);
        frame.setVisible(true);

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
