package ch.fhnw.depa.colorpicker.model;

import ch.fhnw.depa.colorpicker.helper.NumberHexStringConverter;
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

    public void setHexColor(String hexColor) {
        this.hexColor.set(hexColor);
    }

    public boolean isRedBool() {
        return redBool.get();
    }

    public SimpleBooleanProperty redBoolProperty() {
        return redBool;
    }

    public void setRedBool(boolean redBool) {
        this.redBool.set(redBool);
    }

    public boolean isGreenBool() {
        return greenBool.get();
    }

    public SimpleBooleanProperty greenBoolProperty() {
        return greenBool;
    }

    public void setGreenBool(boolean greenBool) {
        this.greenBool.set(greenBool);
    }

    public boolean isBlueBool() {
        return blueBool.get();
    }

    public SimpleBooleanProperty blueBoolProperty() {
        return blueBool;
    }

    public void setBlueBool(boolean blueBool) {
        this.blueBool.set(blueBool);
    }

    public boolean isYellowBool() {
        return yellowBool.get();
    }

    public SimpleBooleanProperty yellowBoolProperty() {
        return yellowBool;
    }

    public void setYellowBool(boolean yellowBool) {
        this.yellowBool.set(yellowBool);
    }

    public boolean isCyanBool() {
        return cyanBool.get();
    }

    public SimpleBooleanProperty cyanBoolProperty() {
        return cyanBool;
    }

    public void setCyanBool(boolean cyanBool) {
        this.cyanBool.set(cyanBool);
    }

    public boolean isOrangeBool() {
        return orangeBool.get();
    }

    public SimpleBooleanProperty orangeBoolProperty() {
        return orangeBool;
    }

    public void setOrangeBool(boolean orangeBool) {
        this.orangeBool.set(orangeBool);
    }

    public boolean isWhiteBool() {
        return whiteBool.get();
    }

    public SimpleBooleanProperty whiteBoolProperty() {
        return whiteBool;
    }

    public void setWhiteBool(boolean whiteBool) {
        this.whiteBool.set(whiteBool);
    }

    public boolean isBlackBool() {
        return blackBool.get();
    }

    public SimpleBooleanProperty blackBoolProperty() {
        return blackBool;
    }

    public void setBlackBool(boolean blackBool) {
        this.blackBool.set(blackBool);
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


    public String getrCH() {
        return rCH.get();
    }

    public SimpleStringProperty rCHProperty() {
        return rCH;
    }

    public void setrCH(String rCH) {
        this.rCH.set(rCH);
    }

    public String getgCH() {
        return gCH.get();
    }

    public SimpleStringProperty gCHProperty() {
        return gCH;
    }

    public void setgCH(String gCH) {
        this.gCH.set(gCH);
    }

    public String getbCH() {
        return bCH.get();
    }

    public SimpleStringProperty bCHProperty() {
        return bCH;
    }

    public void setbCH(String bCH) {
        this.bCH.set(bCH);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public String getFileMenuTitle() {
        return fileMenuTitle.get();
    }

    public StringProperty fileMenuTitleProperty() {
        return fileMenuTitle;
    }

    public void setFileMenuTitle(String fileMenuTitle) {
        this.fileMenuTitle.set(fileMenuTitle);
    }

    public String getAttributesMenuTitle() {
        return attributesMenuTitle.get();
    }

    public StringProperty attributesMenuTitleProperty() {
        return attributesMenuTitle;
    }

    public void setAttributesMenuTitle(String attributesMenuTitle) {
        this.attributesMenuTitle.set(attributesMenuTitle);
    }

    public String getCloseMenuItemTitle() {
        return closeMenuItemTitle.get();
    }

    public StringProperty closeMenuItemTitleProperty() {
        return closeMenuItemTitle;
    }

    public void setCloseMenuItemTitle(String closeMenuItemTitle) {
        this.closeMenuItemTitle.set(closeMenuItemTitle);
    }

    public String getAlertHeaderText() {
        return alertHeaderText.get();
    }

    public StringProperty alertHeaderTextProperty() {
        return alertHeaderText;
    }

    public void setAlertHeaderText(String alertHeaderText) {
        this.alertHeaderText.set(alertHeaderText);
    }

    public String getDarkerButtonTitle() {
        return darkerButtonTitle.get();
    }

    public StringProperty darkerButtonTitleProperty() {
        return darkerButtonTitle;
    }

    public void setDarkerButtonTitle(String darkerButtonTitle) {
        this.darkerButtonTitle.set(darkerButtonTitle);
    }

    public String getBrighterButtonTitle() {
        return brighterButtonTitle.get();
    }

    public StringProperty brighterButtonTitleProperty() {
        return brighterButtonTitle;
    }

    public void setBrighterButtonTitle(String brighterButtonTitle) {
        this.brighterButtonTitle.set(brighterButtonTitle);
    }

    public int getrCI() {
        return rCI.get();
    }

    public SimpleIntegerProperty rCIProperty() {
        return rCI;
    }

    public void setrCI(int rCI) {
        this.rCI.set(rCI);
    }

    public String getrCS() {
        return rCS.get();
    }

    public SimpleStringProperty rCSProperty() {
        return rCS;
    }

    public void setrCS(String rCS) {
        this.rCS.set(rCS);
    }

    public int getgCI() {
        return gCI.get();
    }

    public SimpleIntegerProperty gCIProperty() {
        return gCI;
    }

    public void setgCI(int gCI) {
        this.gCI.set(gCI);
    }

    public String getgCS() {
        return gCS.get();
    }

    public SimpleStringProperty gCSProperty() {
        return gCS;
    }

    public void setgCS(String gCS) {
        this.gCS.set(gCS);
    }

    public int getbCI() {
        return bCI.get();
    }

    public SimpleIntegerProperty bCIProperty() {
        return bCI;
    }

    public void setbCI(int bCI) {
        this.bCI.set(bCI);
    }

    public String getbCS() {
        return bCS.get();
    }

    public SimpleStringProperty bCSProperty() {
        return bCS;
    }

    public void setbCS(String bCS) {
        this.bCS.set(bCS);
    }
}