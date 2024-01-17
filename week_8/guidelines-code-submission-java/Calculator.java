import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Label firstNumberLbl;
    private TextField firstNumberTf;
    private Label secondNumberLbl;
    private TextField secondNumberTf;
    private Label operationLbl;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Label resultLbl;
    private TextField resultTf;

    @Override
    public void start(Stage stage) throws Exception {
        // 1. create the leaf nodes
        firstNumberLbl = new Label("First number:");
        firstNumberTf = new TextField("3");
        secondNumberLbl = new Label("Second number:");
        secondNumberTf = new TextField("7");
        operationLbl = new Label("Operation:");
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        resultLbl = new Label("Result:");
        resultTf = new TextField("10");

        // 2. create the branch nodes (VBoxes for each pair)
        VBox Box = new VBox(5, new HBox(24, firstNumberLbl, firstNumberTf), new HBox(5, secondNumberLbl, secondNumberTf), new HBox(38, operationLbl, new HBox(5, addBtn, subBtn, mulBtn, divBtn)), new HBox(58, resultLbl, resultTf));

        // Combine the VBoxes into an HBox
        HBox hbox = new HBox(10, Box);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10));

        // 3. set the scene, show the stage
        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();

        // Set button actions
        addBtn.setOnAction(new AddBtnHandler());
        subBtn.setOnAction(new SubBtnHandler());
        mulBtn.setOnAction(new MulBtnHandler());
        divBtn.setOnAction(new DivBtnHandler());
    }

    private int getFirstValue() {
        return Integer.parseInt(firstNumberTf.getText());
    }

    private int getSecondValue() {
        return Integer.parseInt(secondNumberTf.getText());
    }

    private void setValue(int newValue) {
        resultTf.setText("" + newValue);
    }

    private class AddBtnHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            int firstValue = getFirstValue();
            int secondValue = getSecondValue();
            int result = firstValue + secondValue;
            setValue(result);
        }
    }

    private class SubBtnHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            int firstValue = getFirstValue();
            int secondValue = getSecondValue();
            int result = firstValue - secondValue;
            setValue(result);
        }
    }

    private class MulBtnHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            int firstValue = getFirstValue();
            int secondValue = getSecondValue();
            int result = firstValue * secondValue;
            setValue(result);
        }
    }

    private class DivBtnHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            int firstValue = getFirstValue();
            int secondValue = getSecondValue();
            if (secondValue != 0) {
                int result = firstValue / secondValue;
                setValue(result);
            } else {
                resultTf.setText("Cannot divide by zero");
            }
        }
    }
}

