package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WindowJavaFX extends Application{
    private Window calc;

    public WindowJavaFX() {
        this.calc = new Window();
    }
    @Override
    public void start(Stage stage) throws Exception {

        Button calculateButton = new Button("Calculate");

        // Använd EventHandler med calculatorBase-metoden
        calculateButton.setOnAction(e -> calc.calculate(1,"+",1));

        StackPane root = new StackPane(calculateButton);
        Scene scene = new Scene(root, 400, 400);
        
        stage.setScene(scene);
        stage.setTitle("JavaFX Calculator");
        stage.show();
    }
    
}
