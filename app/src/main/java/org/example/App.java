package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.layout.StackPane;
// import javafx.stage.Stage;

public class App{

    /*@Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }*/

    /*@Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();

        launch(); //i main
    }*/

    public static void main(String[] args) {

        JButton swing = new JButton("Calculator Swing");
        JButton javaFX = new JButton("Calculator JavaFX");
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        swing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowSwing swing = new WindowSwing();
                swing.CreateCalculatorSwing();
                frame.dispose();
            }
        });
        javaFX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowJavaFX javaFX = new WindowJavaFX();
                javaFX.launch(); //BOMBACLAT FUNKAR EJ, VARFÖR VALDE JAG SWING
                
                //frame.dispose();
            }
        });
        panel.add(swing);
        panel.add(javaFX);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);

    }
}
