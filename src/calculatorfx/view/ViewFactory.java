package calculatorfx.view;

public class ViewFactory {

    public ViewFactory(){}

    //color theme
    private ColorTheme colorTheme = ColorTheme.DEFAULT;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }



}
