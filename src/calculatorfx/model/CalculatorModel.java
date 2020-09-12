package calculatorfx.model;

import javafx.fxml.Initializable;

public class CalculatorModel {

    public CalculatorModel(){}

    public String calculate(double firstNumber, double secondNumber, String operator){
        double answer = 0;
        switch(operator){
            case "plus":
                 answer = firstNumber +secondNumber;
                 break;
            case "minus":
                answer = firstNumber - secondNumber;
                break;
            case"divide":
                if(secondNumber == 0) answer = 0;
                answer = firstNumber/secondNumber;
                break;
            case"multiply":
                answer = firstNumber * secondNumber;
                break;
            default:
                answer = 0;
        }
        //if an integer
        if(answer == (int) answer){
            return String.valueOf((int) answer);
        } else {
            return String.valueOf(answer);
        }
    }

}
