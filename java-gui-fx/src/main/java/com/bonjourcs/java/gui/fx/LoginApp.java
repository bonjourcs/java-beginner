package com.bonjourcs.java.gui.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Liang Chenghao
 * Description: work with JavaFX layout
 * Date: 2018/5/31
 */
public class LoginApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Welcome");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("Username:");
        gridPane.add(userName, 0, 1);

        TextField textField = new TextField();
        gridPane.add(textField, 1, 1);

        Label password = new Label("Password:");
        gridPane.add(password, 0, 2);

        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 2);

        Button button = new Button("Sign in");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(button);
        gridPane.add(hBox, 1, 4);

        final Text actionTarget = new Text();
        gridPane.add(actionTarget, 1, 6);

        button.setOnAction(e -> {
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("Sign in button pressed.");
        });

        Scene scene = new Scene(gridPane, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();

    }
}
