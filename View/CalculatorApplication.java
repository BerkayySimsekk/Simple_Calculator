package View;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {
    VBox root;
    HBox subroot1;
    HBox subroot2;
    HBox subroot3;
    HBox subroot4;
    HBox subroot5;
    Button buttonForZero;
    Button buttonForOne;
    Button buttonForTwo;
    Button buttonForThree;
    Button buttonForFour;
    Button buttonForFive;
    Button buttonForSix;
    Button buttonForSeven;
    Button buttonForEight;
    Button buttonForNine;
    Button buttonForLeftParanthesis;
    Button buttonForRightParanthesis;
    Button buttonForSquareRoot;
    Button buttonForAddition;
    Button buttonForSubtraction;
    Button buttonForDivision;
    Button buttonForMultiplication;
    Button buttonForAllClear;
    Button buttonForPoint;
    Button buttonForEquals;
    TextField fieldForDisplaying;

    @Override
    public void start(Stage stage) {
        buttonForZero = createButton("0");
        buttonForOne = createButton("1");
        buttonForTwo = createButton("2");
        buttonForThree = createButton("3");
        buttonForFour = createButton("4");
        buttonForFive = createButton("5");
        buttonForSix = createButton("6");
        buttonForSeven = createButton("7");
        buttonForEight = createButton("8");
        buttonForNine = createButton("9");
        buttonForLeftParanthesis = createButton("(");
        buttonForRightParanthesis = createButton(")");
        buttonForSquareRoot = createButton("√");
        buttonForAddition = createButton("+");
        buttonForSubtraction = createButton("-");
        buttonForDivision = createButton("÷");
        buttonForMultiplication = createButton("×");
        buttonForAllClear = createButton("AC");
        buttonForPoint = createButton(".");
        buttonForEquals = createButton("=");

        fieldForDisplaying = new TextField();
        fieldForDisplaying.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 25));
        fieldForDisplaying.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        fieldForDisplaying.setEditable(false);
        fieldForDisplaying.setStyle("-fx-text-fill: white");

        subroot1 = new HBox(10);
        subroot1.getChildren().addAll(buttonForLeftParanthesis, buttonForRightParanthesis, buttonForSquareRoot, buttonForAllClear);

        subroot2 = new HBox(10);
        subroot2.getChildren().addAll(buttonForSeven, buttonForEight, buttonForNine, buttonForDivision);

        subroot3 = new HBox(10);
        subroot3.getChildren().addAll(buttonForFour, buttonForFive, buttonForSix, buttonForMultiplication);

        subroot4 = new HBox(10);
        subroot4.getChildren().addAll(buttonForOne, buttonForTwo, buttonForThree, buttonForSubtraction);

        subroot5 = new HBox(10);
        subroot5.getChildren().addAll(buttonForZero, buttonForPoint, buttonForEquals, buttonForAddition);

        root = new VBox(10);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        root.getChildren().addAll(fieldForDisplaying, subroot1, subroot2, subroot3, subroot4, subroot5);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.getIcons().add(new Image("View/Images/Calculator.png"));
        stage.setResizable(false);
        stage.show();
    }

    public static Button createButton(String text) {
        Button button =  new Button(text);
        button.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 25));
        button.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(30), Insets.EMPTY)));
        button.setStyle("-fx-text-fill: white");
        button.setMinWidth(100);

        button.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button.setBackground(new Background(new BackgroundFill(Color.DIMGRAY, new CornerRadii(30), Insets.EMPTY)));
            }
            
        });

        button.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(30), Insets.EMPTY)));   
            }
            
        });

        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
