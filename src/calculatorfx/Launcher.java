package calculatorfx;

import calculatorfx.view.ColorTheme;
import calculatorfx.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String [] args){ launch(args);}
    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showCalculatorWindow();
        viewFactory.updateStyles(ColorTheme.DEFAULT);
    }
}
