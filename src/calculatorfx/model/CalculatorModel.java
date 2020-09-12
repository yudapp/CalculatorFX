package calculatorfx.model;

public class CalculatorModel {

    public CalculatorModel(){}

    public double calculate(double firstNumber, double secondNumber, String operator){
        switch(operator){
            case "plus":
                System.out.println("CASE PLUS "+operator);
                return firstNumber +secondNumber;
            case "minus":
                return firstNumber - secondNumber;
            case"divide":
                if(secondNumber == 0) return 0;
                return firstNumber/secondNumber;
            case"multiply":
                return firstNumber * secondNumber;
            default:
                return 0;
        }
    }

}
