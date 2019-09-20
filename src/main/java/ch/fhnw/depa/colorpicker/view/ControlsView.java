package ch.fhnw.depa.colorpicker.view;

import ch.fhnw.depa.colorpicker.model.PresentationModel;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class ControlsView extends GridPane {

    private PresentationModel pm;

    private Slider rSlider;
    private Slider gSlider;
    private Slider bSlider;
    private Rectangle cRect;
    private TextField rValue;
    private TextField gValue;
    private TextField bValue;
    private TextField rHex;
    private TextField gHex;
    private TextField bHex;
    private Button darkerButton;
    private Button brighterButton;

    private ToggleGroup radioGroup;
    private RadioButton redRadio;
    private RadioButton greenRadio;
    private RadioButton blueRadio;
    private RadioButton yellowRadio;
    private RadioButton cyanRadio;
    private RadioButton orangeRadio;
    private RadioButton whiteRadio;
    private RadioButton blackRadio;

    private Label hexLabel;

    public ControlsView(PresentationModel presentationModel) {

        pm = presentationModel;

        initializeSelf();
        initializeControls();
        layoutControls();
        setupEventHandlers();
        setupValueChangedListeners();
        setupBindings();
    }

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);

        setVgap(5);
        setHgap(8);
        setPadding(new Insets(10));
        setGridLinesVisible(false);
    }

    private void initializeControls() {

        rSlider = new Slider(0, 255, 0);
        gSlider = new Slider(0, 255, 0);
        bSlider = new Slider(0, 255, 0);

        cRect = new Rectangle(200, 100);
        cRect.setStrokeType(StrokeType.OUTSIDE);
        cRect.setStroke(Color.BLACK);

        rValue = new TextField();
        gValue = new TextField();
        bValue = new TextField();

        rHex = new TextField();
        rHex.textProperty().setValue(pm.rCSProperty().getValue());
        rHex.setEditable(false);

        gHex = new TextField();
        gHex.textProperty().setValue(pm.gCSProperty().getValue());
        gHex.setEditable(false);

        bHex = new TextField();
        bHex.textProperty().setValue(pm.bCSProperty().getValue());
        bHex.setEditable(false);

        darkerButton = new Button();
        brighterButton = new Button();

        radioGroup = new ToggleGroup();
        redRadio = new RadioButton("red");
        redRadio.setUserData("RED");
        redRadio.setToggleGroup(radioGroup);

        greenRadio = new RadioButton("green");
        greenRadio.setUserData("GREEN");
        greenRadio.setToggleGroup(radioGroup);

        blueRadio = new RadioButton("blue");
        blueRadio.setUserData("BLUE");
        blueRadio.setToggleGroup(radioGroup);

        yellowRadio = new RadioButton("yellow");
        yellowRadio.setUserData("YELLOW");
        yellowRadio.setToggleGroup(radioGroup);

        cyanRadio = new RadioButton("Cyan");
        cyanRadio.setUserData("CYAN");
        cyanRadio.setToggleGroup(radioGroup);

        orangeRadio = new RadioButton("orange");
        orangeRadio.setUserData("ORANGE");
        orangeRadio.setToggleGroup(radioGroup);

        whiteRadio = new RadioButton("white");
        whiteRadio.setUserData("WHITE");
        whiteRadio.setToggleGroup(radioGroup);

        blackRadio = new RadioButton("black");
        blackRadio.setUserData("BLACK");
        blackRadio.setToggleGroup(radioGroup);
        blackRadio.setSelected(true);

        hexLabel = new Label("yep");
    }

    private void layoutControls() {
        add(rSlider, 0, 0);
        add(gSlider, 0, 1);
        add(bSlider, 0, 2);

        add(rValue, 1, 0);
        add(gValue, 1, 1);
        add(bValue, 1, 2);

        add(rHex, 2, 0);
        add(gHex, 2, 1);
        add(bHex, 2, 2);

        // Here must be the rectangle
        add(cRect, 0, 3, 1, 5);
        add(hexLabel, 0, 10);

        // Here is the space for the RadioButton
        add(redRadio, 1, 3);
        add(greenRadio, 1, 4);
        add(blueRadio, 1, 5);
        add(yellowRadio, 1, 6);
        add(cyanRadio, 1, 7);
        add(orangeRadio, 1, 8);
        add(whiteRadio, 1, 9);
        add(blackRadio, 1, 10);

        add(darkerButton, 2, 3);
        add(brighterButton, 2, 4);
    }

    private void setupEventHandlers() {

        darkerButton.setOnAction(event -> {
            if (pm.getrCI() > 1) {
                pm.setrCI(pm.getrCI() - 2);
            } else {
                pm.setrCI(0);
            }
            if (pm.getgCI() > 1) {
                pm.setgCI(pm.getgCI() - 2);
            } else {
                pm.setgCI(0);
            }
            if (pm.getbCI() > 1) {
                pm.setbCI(pm.getbCI() - 2);
            } else {
                pm.setbCI(0);
            }
        });

        brighterButton.setOnAction(event -> {
            if (pm.getrCI() < 254) {
                pm.setrCI(pm.getrCI() + 2);
            } else {
                pm.setrCI(255);
            }
            if (pm.getgCI() < 254) {
                pm.setgCI(pm.getgCI() + 2);
            } else {
                pm.setgCI(255);
            }
            if (pm.getbCI() < 254) {
                pm.setbCI(pm.getbCI() + 2);
            } else {
                pm.setbCI(255);
            }
        });

    }

    private void setupValueChangedListeners() {

        pm.hexColorProperty().addListener(event -> {
            updateRectColor();
            setRadioButton();

        });

        radioGroup.selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
                    if (radioGroup.getSelectedToggle() != null) {
                        setColor(radioGroup.getSelectedToggle().getUserData().toString());

                        if (redRadio == new_toggle) {
                            pm.setRedBool(true);
                        } else if (greenRadio == new_toggle) {
                            pm.setGreenBool(true);
                        } else if (blueRadio == new_toggle) {
                            pm.setBlueBool(true);
                        } else if (yellowRadio == new_toggle) {
                            pm.setYellowBool(true);
                        } else if (cyanRadio == new_toggle) {
                            pm.setCyanBool(true);
                        } else if (orangeRadio == new_toggle) {
                            pm.setOrangeBool(true);
                        } else if (whiteRadio == new_toggle) {
                            pm.setWhiteBool(true);
                        } else if (blackRadio == new_toggle) {
                            pm.setBlackBool(true);
                        }

                        //old_toggle.setSelected(false);

                    }

                }
        );
    }


    private void setRadioButton() {
        switch (pm.getHexColor()) {
            case "#FF0000":
                redRadio.fire();
                break;
            case "#00FF00":
                greenRadio.fire();
                break;
            case "#0000FF":
                blueRadio.fire();
                break;
            case "#FFFF00":
                yellowRadio.fire();
                break;
            case "#00FFFF":
                cyanRadio.fire();
                break;
            case "#FFA000":
                orangeRadio.fire();
                break;
            case "#FFFFFF":
                whiteRadio.fire();
                break;
            case "#000000":
                blackRadio.fire();
                break;
            default:
                radioGroup.selectToggle(null);

        }

    }

    private void setupBindings() {

        darkerButton.textProperty().bind(pm.darkerButtonTitleProperty());
        brighterButton.textProperty().bind(pm.brighterButtonTitleProperty());

        rSlider.valueProperty().bindBidirectional(pm.rCIProperty());
        rValue.textProperty().bindBidirectional(pm.rCSProperty());
        rHex.textProperty().bind(pm.rCHProperty());

        gSlider.valueProperty().bindBidirectional(pm.gCIProperty());
        gValue.textProperty().bindBidirectional(pm.gCSProperty());
        gHex.textProperty().bind(pm.gCHProperty());

        bSlider.valueProperty().bindBidirectional(pm.bCIProperty());
        bValue.textProperty().bindBidirectional(pm.bCSProperty());
        bHex.textProperty().bind(pm.bCHProperty());

        hexLabel.textProperty().bind(pm.hexColorProperty());

        redRadio.selectedProperty().bindBidirectional(pm.redBoolProperty());
        greenRadio.selectedProperty().bindBidirectional(pm.greenBoolProperty());
        blueRadio.selectedProperty().bindBidirectional(pm.blueBoolProperty());
        yellowRadio.selectedProperty().bindBidirectional(pm.yellowBoolProperty());
        cyanRadio.selectedProperty().bindBidirectional(pm.cyanBoolProperty());
        orangeRadio.selectedProperty().bindBidirectional(pm.orangeBoolProperty());
        whiteRadio.selectedProperty().bindBidirectional(pm.whiteBoolProperty());
        blackRadio.selectedProperty().bindBidirectional(pm.blackBoolProperty());
    }

    private void updateRectColor() {
        Color c = Color.rgb(pm.rCIProperty().getValue(), pm.gCIProperty().getValue(), pm.bCIProperty().getValue());
        cRect.setFill(c);
    }

    public void setColor(String color) {
        switch (color) {
            case "RED":
                pm.setRGB(255, 0, 0);
                break;
            case "GREEN":
                pm.setRGB(0, 255, 0);
                break;
            case "BLUE":
                pm.setRGB(0, 0, 255);
                break;
            case "YELLOW":
                pm.setRGB(255, 255, 0);
                break;
            case "CYAN":
                pm.setRGB(0, 255, 255);
                break;
            case "ORANGE":
                pm.setRGB(255, 160, 0);
                break;
            case "WHITE":
                pm.setRGB(255, 255, 255);
                break;
            default:
                pm.setRGB(0, 0, 0);

        }
    }

}
