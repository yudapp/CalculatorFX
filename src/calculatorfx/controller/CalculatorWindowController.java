package calculatorfx.controller;

import calculatorfx.model.CalculatorModel;
import calculatorfx.view.ColorTheme;
import calculatorfx.view.ViewFactory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorWindowController extends BaseController implements Initializable {

    private String firstNumber = "";
    private String operator = "";
    private boolean start = true;
    private CalculatorModel calculatorModel = new CalculatorModel();

    public CalculatorWindowController(ViewFactory viewFactory, String fxmlFileName) {
        super(viewFactory, fxmlFileName);
    }

    @FXML
    private MenuItem clearScreen;

    @FXML
    private MenuItem menuClose;

    @FXML
    private MenuItem menuLightTheme;

    @FXML
    private MenuItem menuDefaultTheme;

    @FXML
    private MenuItem menuDarkTheme;

    @FXML
    private Label lblResults;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnNine;

    @FXML
    private Button divide;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnSix;

    @FXML
    private Button minus;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnThree;

    @FXML
    private Button plus;

    @FXML
    private Button period;

    @FXML
    private Button btnZero;

    @FXML
    private Button equals;

    @FXML
    private Button multiply;

    @FXML
    void exitApplication() {
        Platform.exit();
    }

    @FXML
    void clearScreen() {
        lblResults.setText("");
        smallLabel.setText("");
        operator = "";
        start = true;

    }

    @FXML
    private Label smallLabel;


    @FXML
    void numberPressed(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (start) {
            lblResults.setText("0");
            smallLabel.setText(""); //clear the label
            start = false;
        }

        switch (value) {
            case ".":

                if (lblResults.getText().matches("0")) {
                    lblResults.setText(lblResults.getText() + value);
                } else if (!lblResults.getText().contains(".")) {
                    if (lblResults.getText().isEmpty()) {
                        lblResults.setText("0" + value);
                    } else {
                        lblResults.setText(lblResults.getText() + value);
                    }
                }
                break;
            default:
                if (lblResults.getText().matches("0")) {
                    lblResults.setText(value);
                } else {
                    lblResults.setText(lblResults.getText() + value);
                }
        }

    }

    @FXML
    void numberPressedAction(ActionEvent event) {
        //signChange, equals, +, -, /, *
        String operatorPressed = ((Button) event.getSource()).getId();
        if (operatorPressed.matches("equals")) {
            if (operator.isEmpty()) return; //should have pressed on an operator first, else:
            String secondNumber = lblResults.getText();
            if (lblResults.getText().isEmpty()) {
                secondNumber = firstNumber;
            }
            lblResults.setText(calculatorModel.calculate(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber), operator));
            smallLabel.setText(firstNumber + " " + getSign(operator) + " " + secondNumber + " = " + lblResults.getText());
            operator = "";
            start = true;
        } else {
            firstNumber = lblResults.getText();
            smallLabel.setText(lblResults.getText() + " " + getSign(operatorPressed));
            lblResults.setText("");
            operator = operatorPressed;
        }
    }


    public String getSign(String value) {
        if (value.equals("equals")) return "=";
        if (value.equals("minus")) return "-";
        if (value.equals("plus")) return "+";
        if (value.equals("multiply")) return "x";
        if (value.equals("divide")) return "/";
        return "";
    }

    @FXML
    void selectDarkTheme() {
        viewFactory.updateStyles(ColorTheme.DARK);
    }

    @FXML
    void selectDefaultTheme() {
        viewFactory.updateStyles(ColorTheme.DEFAULT);
    }

    @FXML
    void selectLightTheme() {
        viewFactory.updateStyles(ColorTheme.LIGHT);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
