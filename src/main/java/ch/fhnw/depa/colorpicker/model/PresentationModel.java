package ch.fhnw.depa.colorpicker.model;

import javafx.beans.binding.Bindings;
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

    private final SimpleIntegerProperty gCI = new SimpleIntegerProperty(0);
    private final SimpleStringProperty gCS = new SimpleStringProperty("0");

    private final SimpleIntegerProperty bCI = new SimpleIntegerProperty(0);
    private final SimpleStringProperty bCS = new SimpleStringProperty("0");


    public PresentationModel(Stage pStage) {
        primaryStage = pStage;

        Bindings.bindBidirectional(rCS, rCI, new NumberStringConverter());
        Bindings.bindBidirectional(gCS, gCI, new NumberStringConverter());
        Bindings.bindBidirectional(bCS, bCI, new NumberStringConverter());

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