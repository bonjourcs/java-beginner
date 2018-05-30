package com.bonjourcs.java.gui.fx;
/**
 * @author Liang Chenghao
 * Description: JavaFX HelloWorld
 * Date: 2018/5/30
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Index extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button();
        button.setText("Say 'Hello, world!'");
        button.setOnAction(event ->
                System.out.println("Hello, world!")
        );

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello, world");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
