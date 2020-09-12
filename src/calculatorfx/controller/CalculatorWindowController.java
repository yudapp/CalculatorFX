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

    private boolean signPositive = true;
    private double firstNumber = 0;
    private String operator = "";
    private boolean start = true;
    private CalculatorModel  calculatorModel = new CalculatorModel();

    public CalculatorWindowController(ViewFactory viewFactory, String fxmlFileName) {
        super(viewFactory, fxmlFileName);
    }

    @FXML
    private MenuItem menuClose;

    @FXML
    private MenuItem menuLightTheme;

    @FXML
    private MenuItem menuDefaultTheme;

    @FXML
    private MenuItem menuDarkTheme;

    @FXML
    private MenuItem clearScreen;

    @FXML
    private Label lblResults;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnSubtract;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnAddition;

    @FXML
    private Button btnSignChange;

    @FXML
    private Button btnZero;

    @FXML
    private Button btnPeriod;

    @FXML
    private Button btnEquals;

    @FXML
    void exitApplication() {
        Platform.exit();
    }

    @FXML
    void clearScreen() {
    lblResults.setText("");
    }


    @FXML
    void numberPressed(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if(start){
            lblResults.setText("");
            start =false;
        }

        switch (value) {
            case ".":
                if (lblResults.getText().matches("0")) {
                    lblResults.setText(lblResults.getText() + value);
                } else if (!lblResults.getText().contains(".")) {
                    lblResults.setText(lblResults.getText() + value);
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
         switch (operatorPressed) {
            case "sign":
                if (lblResults.getText().charAt(0) != '0') {
                    if (signPositive) {
                        signPositive = false;
                        lblResults.setText("-" + lblResults.getText());
                    } else {
                        signPositive = true;
                        //get first char and check for -
                        if (lblResults.getText().charAt(0) == '-') {
                            lblResults.setText(lblResults.getText().substring(1));
                        }
                    }
                }
                break;
            case "equals":
                if(operator.isEmpty()) return; //should have pressed on an operator first, else:
                String result = Double.toString(calculatorModel.calculate(firstNumber,Double.parseDouble(lblResults.getText()),operator));
                lblResults.setText(result);
                operator = "";
                start = true;
                break;
            default:
                firstNumber = Double.parseDouble(lblResults.getText());
                lblResults.setText("");
                operator = operatorPressed;
        }
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
