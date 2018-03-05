package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

public class Main extends Application {

    Stage window;
    Scene scene1;
    Scene scene2;
    Scene clear;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //window settings
        window = primaryStage;
        window.setTitle("AKidemia");
        window.setFullScreen(!true);

        //--------------------------Opening scene-----------------------------//
        // go label
        Label label1 = new Label("Welcome to Akidemia");
        label1.setAlignment(Pos.CENTER);

        GridPane.setConstraints(label1, 0, 0);
        //Button to next scene
        Button goButton = new Button("Go");
        GridPane.setConstraints(goButton, 0, 1);
        goButton.setAlignment(Pos.CENTER);
        goButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
                window.setScene(scene2);
                window.show();

            }
        });

        Button FileButton = new Button("File");
        Button ChildLock = new Button("Child Lock");
        Button Sound = new Button("Sound");
        Button Setting = new Button("Settings");

        HBox bottomRight = new HBox();
        bottomRight.setSpacing(10);
        bottomRight.getChildren().addAll(ChildLock,Sound,Setting);
        bottomRight.setAlignment(Pos.BOTTOM_RIGHT);

        HBox Left = new HBox();
        Left.setSpacing(0);
        Left.getChildren().addAll(FileButton);
        Left.setAlignment(Pos.BOTTOM_LEFT);

        // Layout of opening scene
        GridPane CentreLayout = new GridPane();
        CentreLayout.setPadding(new Insets(10, 10, 10, 10));
        CentreLayout.setVgap(8);
        CentreLayout.setHgap(10);
        CentreLayout.getChildren().addAll(label1, goButton);
        CentreLayout.setAlignment(Pos.CENTER);

        BorderPane border = new BorderPane();
        border.setCenter(CentreLayout);
        border.setBottom(bottomRight);
        border.setLeft(Left);

        /*Image libImage = new Image("/Users/Aidensmac/Desktop/jp_logo_back_red_yellow.png", 300, 600, false, true);
        BackgroundSize size = new BackgroundSize(300, 600, false, false, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(libImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size);
        Background background = new Background(backgroundImage);
        layout1.setBackground(background);*/

        scene1 = new Scene(border, 800 ,1200);
        window.setScene(scene1);

        //--------------------------Login scene-----------------------------//
        Label userLabel = new Label("Username");
        userLabel.setAlignment(Pos.CENTER);
        GridPane.setConstraints(userLabel, 0, 0);
        Label passwordLabel = new Label("Password");
        passwordLabel.setAlignment(Pos.CENTER);
        GridPane.setConstraints(passwordLabel, 0, 1);

        TextField user = new TextField();
        user.setAlignment(Pos.CENTER);
        GridPane.setConstraints(user, 1, 0);
        TextField password = new TextField();
        password.setAlignment(Pos.CENTER);
        GridPane.setConstraints(password, 1, 1);

        Button loginButton = new Button("Login");
        loginButton.setAlignment(Pos.CENTER);
        GridPane.setConstraints(loginButton, 0, 2);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("User: " + user.getText());
                System.out.println("Password: " + password.getText());
            }
        });

        Button backButton = new Button("Back");
        backButton.setAlignment(Pos.TOP_RIGHT);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //window.close();
                window.setScene(scene1);
                //window.show();
            }
        });

        GridPane Center = new GridPane();
        Center.setPadding(new Insets(10, 10, 10, 10));
        Center.setVgap(8);
        Center.setHgap(10);
        Center.getChildren().addAll(user, userLabel, password, passwordLabel, loginButton);
        Center.setAlignment(Pos.CENTER);

        BorderPane border2 = new BorderPane();
        border2.setCenter(Center);
        border2.setRight(backButton);

        GridPane Right = new GridPane();
        Right.setPadding(new Insets(10, 10, 10, 10));
        Right.setVgap(8);
        Right.setHgap(10);
        Right.getChildren().addAll(backButton);
        Right.setAlignment(Pos.TOP_RIGHT);

        border2.setRight(Right);

        scene2 = new Scene(border2, border.getWidth(), border.getHeight());

        window.show();

    }
}