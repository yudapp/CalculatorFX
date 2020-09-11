package calculatorfx.controller;

import calculatorfx.view.ViewFactory;

public class BaseController {

    protected ViewFactory viewFactory;
    private  String fxmlFileName;

    public BaseController(ViewFactory viewFactory, String fxmlFileName) {
        this.viewFactory = viewFactory;
        this.fxmlFileName = fxmlFileName;
    }

    public String getFxmlFileName(){
        return fxmlFileName;
    }
}
