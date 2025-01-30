package View;

import java.util.Timer;
import java.util.TimerTask;

import Model.Calculator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private VBox root;
    private HBox subroot1;
    private HBox subroot2;
    private HBox subroot3;
    private HBox subroot4;
    private HBox subroot5;
    private Button buttonForZero;
    private Button buttonForOne;
    private Button buttonForTwo;
    private Button buttonForThree;
    private Button buttonForFour;
    private Button buttonForFive;
    private Button buttonForSix;
    private Button buttonForSeven;
    private Button buttonForEight;
    private Button buttonForNine;
    private Button buttonForLeftParanthesis;
    private Button buttonForRightParanthesis;
    private Button buttonForClearEntry;
    private Button buttonForAddition;
    private Button buttonForSubtraction;
    private Button buttonForDivision;
    private Button buttonForMultiplication;
    private Button buttonForAllClear;
    private Button buttonForPoint;
    private Button buttonForEquals;
    private TextField fieldForDisplaying;
    private String displayInfo;

    @Override
    public void start(Stage stage) {
        displayInfo = "";

        buttonForZero = createButtonForNumbers("0");
        buttonForOne = createButtonForNumbers("1");
        buttonForTwo = createButtonForNumbers("2");
        buttonForThree = createButtonForNumbers("3");
        buttonForFour = createButtonForNumbers("4");
        buttonForFive = createButtonForNumbers("5");
        buttonForSix = createButtonForNumbers("6");
        buttonForSeven = createButtonForNumbers("7");
        buttonForEight = createButtonForNumbers("8");
        buttonForNine = createButtonForNumbers("9");

        buttonForAddition = createButtonForOperationSigns("+");
        buttonForSubtraction = createButtonForOperationSigns("-");
        buttonForDivision = createButtonForOperationSigns("÷");
        buttonForMultiplication = createButtonForOperationSigns("×");

        buttonForLeftParanthesis = createButtonForOthers("(");
        buttonForRightParanthesis = createButtonForOthers(")");
        buttonForClearEntry = createButtonForOthers("CE");
        buttonForAllClear = createButtonForOthers("AC");
        buttonForPoint = createButtonForOthers(".");
        buttonForEquals = createButtonForOthers("=");

        buttonForLeftParanthesis.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(displayInfo.length() == 0) {
                    displayInfo += "(";
                    fieldForDisplaying.setText(displayInfo);
                }
                
                if(displayInfo.charAt(displayInfo.length() - 1) == '+' || displayInfo.charAt(displayInfo.length() - 1) == '-' || displayInfo.charAt(displayInfo.length() - 1) == '÷' || displayInfo.charAt(displayInfo.length() - 1) == '×' || displayInfo.charAt(displayInfo.length() - 1) == '√') {
                    displayInfo += "(";
                    fieldForDisplaying.setText(displayInfo);
                }
            }
            
        });

        buttonForRightParanthesis.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(LeftParanthesisCounter() != RightParanthesisCounter() && displayInfo.length() != 0 && (displayInfo.charAt(displayInfo.length() - 1) == '0' || displayInfo.charAt(displayInfo.length() - 1) == '1' || displayInfo.charAt(displayInfo.length() - 1) == '2' || displayInfo.charAt(displayInfo.length() - 1) == '3' || displayInfo.charAt(displayInfo.length() - 1) == '4' || displayInfo.charAt(displayInfo.length() - 1) == '5' || displayInfo.charAt(displayInfo.length() - 1) == '6' || displayInfo.charAt(displayInfo.length() - 1) == '7' || displayInfo.charAt(displayInfo.length() - 1) == '8' || displayInfo.charAt(displayInfo.length() - 1) == '9')) {
                    displayInfo += ")";
                    fieldForDisplaying.setText(displayInfo);
                }
            }
            
        });

        buttonForClearEntry.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(displayInfo.length() != 0) {
                    displayInfo = displayInfo.substring(0, displayInfo.length() - 1);
                    fieldForDisplaying.setText(displayInfo);  
                }
            }
            
        });

        buttonForAllClear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                displayInfo = "";
                fieldForDisplaying.setText(displayInfo);
            }
            
        });

        buttonForPoint.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(displayInfo.length() != 0 && (displayInfo.charAt(displayInfo.length() - 1) == '0' || displayInfo.charAt(displayInfo.length() - 1) == '1' || displayInfo.charAt(displayInfo.length() - 1) == '2' || displayInfo.charAt(displayInfo.length() - 1) == '3' || displayInfo.charAt(displayInfo.length() - 1) == '4' || displayInfo.charAt(displayInfo.length() - 1) == '5' || displayInfo.charAt(displayInfo.length() - 1) == '6' || displayInfo.charAt(displayInfo.length() - 1) == '7' || displayInfo.charAt(displayInfo.length() - 1) == '8' || displayInfo.charAt(displayInfo.length() - 1) == '9')) {
                    displayInfo += ".";
                    fieldForDisplaying.setText(displayInfo);
                }
            }
            
        });

        buttonForEquals.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Calculator calculator = new Calculator(displayInfo);
                displayInfo = calculator.getResult() + "";
                fieldForDisplaying.setText(displayInfo);
            }
            
        });

        fieldForDisplaying = new TextField();
        fieldForDisplaying.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 25));
        fieldForDisplaying.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        fieldForDisplaying.setEditable(false);
        fieldForDisplaying.setStyle("-fx-text-fill: white");

        subroot1 = new HBox(10);
        subroot1.getChildren().addAll(buttonForLeftParanthesis, buttonForRightParanthesis, buttonForClearEntry, buttonForAllClear);

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

    private int LeftParanthesisCounter() {
        int counter = 0;

        for(int n = 0; n < displayInfo.length(); n++) {
            if(displayInfo.charAt(n) == '(') {
                counter++;
            }
        }

        return counter;
    }

    private int RightParanthesisCounter() {
        int counter = 0;

        for(int n = 0; n < displayInfo.length(); n++) {
            if(displayInfo.charAt(n) == ')') {
                counter++;
            }
        }

        return counter;
    }

    private Button createButtonForOthers(String text) {
        Button button =  new Button(text);
        button.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 25));
        button.setBackground(new Background(new BackgroundFill(Color.DIMGREY, new CornerRadii(30), Insets.EMPTY)));
        button.setStyle("-fx-text-fill: white");
        button.setMinWidth(100);

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(30), Insets.EMPTY)));
                
                Timer myTimer = new Timer();
                myTimer.schedule(new TimerTask(){

                    @Override
                    public void run() {
                        button.setBackground(new Background(new BackgroundFill(Color.DIMGREY, new CornerRadii(30), Insets.EMPTY)));
                    }

                }, 100);
            }
            
        });

        return button;
    }

    private Button createButtonForNumbers(String text) {
        Button button =  new Button(text);
        button.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 25));
        button.setBackground(new Background(new BackgroundFill(Color.DIMGREY, new CornerRadii(30), Insets.EMPTY)));
        button.setStyle("-fx-text-fill: white");
        button.setMinWidth(100);

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(30), Insets.EMPTY)));

                if(displayInfo.length() == 0) {
                    displayInfo += text;
                    fieldForDisplaying.setText(displayInfo);
                }
                else if(displayInfo.charAt(displayInfo.length() - 1) != ')') {
                    displayInfo += text;
                    fieldForDisplaying.setText(displayInfo);
                }
                
                Timer myTimer = new Timer();
                myTimer.schedule(new TimerTask(){

                    @Override
                    public void run() {
                        button.setBackground(new Background(new BackgroundFill(Color.DIMGREY, new CornerRadii(30), Insets.EMPTY)));
                    }

                }, 100);
            }
            
        });

        return button;
    }

    private Button createButtonForOperationSigns(String text) {
        Button button =  new Button(text);
        button.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 25));
        button.setBackground(new Background(new BackgroundFill(Color.DIMGREY, new CornerRadii(30), Insets.EMPTY)));
        button.setStyle("-fx-text-fill: white");
        button.setMinWidth(100);

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                button.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(30), Insets.EMPTY)));

                if(displayInfo.length() != 0 && (displayInfo.charAt(displayInfo.length() - 1) == ')' || displayInfo.charAt(displayInfo.length() - 1) == '0' || displayInfo.charAt(displayInfo.length() - 1) == '1' || displayInfo.charAt(displayInfo.length() - 1) == '2' || displayInfo.charAt(displayInfo.length() - 1) == '3' || displayInfo.charAt(displayInfo.length() - 1) == '4' || displayInfo.charAt(displayInfo.length() - 1) == '5' || displayInfo.charAt(displayInfo.length() - 1) == '6' || displayInfo.charAt(displayInfo.length() - 1) == '7' || displayInfo.charAt(displayInfo.length() - 1) == '8' || displayInfo.charAt(displayInfo.length() - 1) == '9')) {
                    displayInfo += text;
                    fieldForDisplaying.setText(displayInfo);
                }
                
                Timer myTimer = new Timer();
                myTimer.schedule(new TimerTask(){

                    @Override
                    public void run() {
                        button.setBackground(new Background(new BackgroundFill(Color.DIMGREY, new CornerRadii(30), Insets.EMPTY)));
                    }

                }, 100);
            }
            
        });

        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
