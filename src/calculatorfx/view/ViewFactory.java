package calculatorfx.view;

import calculatorfx.controller.BaseController;
import calculatorfx.controller.CalculatorWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private ArrayList<Stage> activeStages;
    private ColorTheme colorTheme = ColorTheme.LIGHT;

    public ViewFactory() {
        activeStages = new ArrayList<>();
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public void showCalculatorWindow() {
        BaseController baseController = new CalculatorWindowController(this, "CalculatorWindow.fxml");
        initialiseStage(baseController);
    }

    private void initialiseStage(BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlFileName()));
        Parent parent;
        try {
            fxmlLoader.setController(controller);
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        activeStages.add(stage);
        stage.show();
    }

    public void closeStage(Stage stageToClose){
        activeStages.remove(stageToClose);
    }

    public void updateStyles() {
        for (Stage stage : activeStages) {
            Scene scene = stage.getScene();
            //handle css here
            scene.getStylesheets().clear(); //clear style first before applying new ones
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());

        }

    }
}