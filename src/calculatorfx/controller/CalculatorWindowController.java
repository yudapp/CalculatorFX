package calculatorfx.controller;

import calculatorfx.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorWindowController extends BaseController implements Initializable {

    public CalculatorWindowController(ViewFactory viewFactory, String fxmlFileName) {
        super(viewFactory, fxmlFileName);
    }

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
    void numberPressed() {
    }

    @FXML
    void numberPressedAction() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
