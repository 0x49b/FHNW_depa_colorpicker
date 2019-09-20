package ch.fhnw.depa.colorpicker.model;

import ch.fhnw.depa.colorpicker.converter.NumberHexStringConverter;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class PresentationModel {

    private final Stage primaryStage;

    private final StringProperty applicationTitle = new SimpleStringProperty("FHNW depa color picker");
    private final StringProperty fileMenuTitle = new SimpleStringProperty("File");
    private final StringProperty attributesMenuTitle = new SimpleStringProperty("Attributes");

    private final StringProperty closeMenuItemTitle = new SimpleStringProperty("Close");
    private final StringProperty alertHeaderText = new SimpleStringProperty("Close Application?");

    private final StringProperty darkerButtonTitle = new SimpleStringProperty("Darker");
    private final StringProperty brighterButtonTitle = new SimpleStringProperty("Brighter");

    private final SimpleIntegerProperty rCI = new SimpleIntegerProperty(0);
    private final SimpleStringProperty rCS = new SimpleStringProperty("0");
    private final SimpleStringProperty rCH = new SimpleStringProperty("0");

    private final SimpleIntegerProperty gCI = new SimpleIntegerProperty(0);
    private final SimpleStringProperty gCS = new SimpleStringProperty("0");
    private final SimpleStringProperty gCH = new SimpleStringProperty("0");

    private final SimpleIntegerProperty bCI = new SimpleIntegerProperty(0);
    private final SimpleStringProperty bCS = new SimpleStringProperty("0");
    private final SimpleStringProperty bCH = new SimpleStringProperty("0");

    private final SimpleStringProperty hexColor = new SimpleStringProperty("");

    private final SimpleBooleanProperty redBool = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty greenBool = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty blueBool = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty yellowBool = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty cyanBool = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty orangeBool = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty whiteBool = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty blackBool = new SimpleBooleanProperty(false);

    public PresentationModel(Stage pStage) {
        primaryStage = pStage;
        setupListener();

        Bindings.bindBidirectional(rCS, rCI, new NumberStringConverter());
        Bindings.bindBidirectional(gCS, gCI, new NumberStringConverter());
        Bindings.bindBidirectional(bCS, bCI, new NumberStringConverter());

        Bindings.bindBidirectional(rCH, rCI, new NumberHexStringConverter());
        Bindings.bindBidirectional(gCH, gCI, new NumberHexStringConverter());
        Bindings.bindBidirectional(bCH, bCI, new NumberHexStringConverter());
    }

    private void setupListener() {

        rCI.addListener(event -> {
            setHexColor();
        });

        bCI.addListener(event -> {
            setHexColor();
        });

        gCI.addListener(event -> {
            setHexColor();
        });

    }

    public void setRGB(int r, int g, int b) {
        setrCI(r);
        setgCI(g);
        setbCI(b);
    }

    public void setRedBool(boolean redBool) {
        this.redBool.set(redBool);
    }

    public SimpleBooleanProperty redBoolProperty() {
        return redBool;
    }


    public void setGreenBool(boolean greenBool) {
        this.greenBool.set(greenBool);
    }

    public SimpleBooleanProperty greenBoolProperty() {
        return greenBool;
    }


    public void setBlueBool(boolean blueBool) {
        this.blueBool.set(blueBool);
    }

    public SimpleBooleanProperty blueBoolProperty() {
        return blueBool;
    }


    public void setYellowBool(boolean yellowBool) {
        this.yellowBool.set(yellowBool);
    }

    public SimpleBooleanProperty yellowBoolProperty() {
        return yellowBool;
    }


    public void setCyanBool(boolean cyanBool) {
        this.cyanBool.set(cyanBool);
    }

    public SimpleBooleanProperty cyanBoolProperty() {
        return cyanBool;
    }


    public void setOrangeBool(boolean orangeBool) {
        this.orangeBool.set(orangeBool);
    }

    public SimpleBooleanProperty orangeBoolProperty() {
        return orangeBool;
    }


    public void setWhiteBool(boolean whiteBool) {
        this.whiteBool.set(whiteBool);
    }

    public SimpleBooleanProperty whiteBoolProperty() {
        return whiteBool;
    }


    public void setBlackBool(boolean blackBool) {
        this.blackBool.set(blackBool);
    }

    public SimpleBooleanProperty blackBoolProperty() {
        return blackBool;
    }

    public String getHexColor() {
        return hexColor.get();
    }


    public SimpleStringProperty hexColorProperty() {
        return hexColor;
    }

    public void setHexColor() {
        String hex = String.format("#%02x%02x%02x", getrCI(), getgCI(), getbCI()).toUpperCase();
        this.hexColor.set(hex);
    }


    public SimpleStringProperty rCHProperty() {
        return rCH;
    }

    public SimpleStringProperty gCHProperty() {
        return gCH;
    }

    public SimpleStringProperty bCHProperty() {
        return bCH;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public StringProperty fileMenuTitleProperty() {
        return fileMenuTitle;
    }

    public StringProperty attributesMenuTitleProperty() {
        return attributesMenuTitle;
    }

    public StringProperty closeMenuItemTitleProperty() {
        return closeMenuItemTitle;
    }

    public String getAlertHeaderText() {
        return alertHeaderText.get();
    }

    public StringProperty darkerButtonTitleProperty() {
        return darkerButtonTitle;
    }

    public StringProperty brighterButtonTitleProperty() {
        return brighterButtonTitle;
    }

    public int getrCI() {
        return rCI.get();
    }

    public void setrCI(int rCI) {
        this.rCI.set(rCI);
    }

    public SimpleIntegerProperty rCIProperty() {
        return rCI;
    }

    public SimpleStringProperty rCSProperty() {
        return rCS;
    }

    public int getgCI() {
        return gCI.get();
    }

    public void setgCI(int gCI) {
        this.gCI.set(gCI);
    }

    public SimpleIntegerProperty gCIProperty() {
        return gCI;
    }

    public SimpleStringProperty gCSProperty() {
        return gCS;
    }

    public int getbCI() {
        return bCI.get();
    }

    public void setbCI(int bCI) {
        this.bCI.set(bCI);
    }

    public SimpleIntegerProperty bCIProperty() {
        return bCI;
    }

    public SimpleStringProperty bCSProperty() {
        return bCS;
    }
}