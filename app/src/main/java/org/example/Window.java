package org.example;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Window extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField textField;
    private Map<String, Operand> operations;
    String s0,s1,s2;

    Window() {
        s0 = s1 = s2 = "";
        operations = new HashMap<String, Operand>();
        operations.put("+", new Add());
        operations.put("-", new Sub());
        operations.put("*", new Mul());
        operations.put("/", new Div());
        operations.put("^", new Pow());
    }
    
    public double calculate (double operand1, String operator, double operand2){
        Operand currentOp = operations.get(operator);
        if(currentOp == null){
            throw new IllegalArgumentException("Invalid Operator");
        }
        return currentOp.execute(operand1, operand2);
    }

    public void CreateCalculator() {
        frame = new JFrame("Calculator");
        textField = new JTextField(16);
        textField.setEditable(false);
        Window c = new Window();
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1, exit, bp;
        //Siffrorna i miniäknaren
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        beq1 = new JButton("=");
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        bp = new JButton("^");
        beq = new JButton("C");
        be = new JButton(".");
        exit = new JButton("Exit");

        JPanel p = new JPanel();
        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        bp.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);
        exit.addActionListener(c);

        p.add(textField);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(bp);
        p.add(beq);
        p.add(beq1);
        p.add(exit);
        p.setBackground(Color.blue);
        frame.add(p);
        frame.setSize(200, 220);
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
        else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^")) {
            s1 = s;
            textField.setText(s0 + s1);
        }
        else if (s.equals("Exit")) {
            System.exit(0);
        }
        else if (s.charAt(0) == '=') {
            if (!s0.equals("") && !s2.equals("")) {
                double op1 = Double.parseDouble(s0);
                double op2 = Double.parseDouble(s2);
                double res = calculate(op1,s1,op2);
                textField.setText(Double.toString(res));

                s0 = Double.toString(res);
                s1 = s2 = "";
            }
        }

    }
}
