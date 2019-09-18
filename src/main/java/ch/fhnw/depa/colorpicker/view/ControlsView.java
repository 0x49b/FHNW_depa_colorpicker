package ch.fhnw.depa.colorpicker.view;

import ch.fhnw.depa.colorpicker.PresentationModel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
        add(cRect, 0, 3, 1, 2);

        // Here is the space for the RadioButton

        add(darkerButton, 2, 3);
        add(brighterButton, 2, 4);
    }

    private void setupEventHandlers() {

        darkerButton.setOnAction(event -> {
            if (pm.getrCI() >=1 ) {
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
            if (pm.getrCI() <254 ) {
                pm.setrCI(pm.getrCI() + 2);
            } else {
                pm.setrCI(255);
            }
            if (pm.getgCI() <254) {
                pm.setgCI(pm.getgCI() + 2);
            } else {
                pm.setgCI(255);
            }
            if (pm.getbCI() <254) {
                pm.setbCI(pm.getbCI() + 2);
            } else {
                pm.setbCI(255);
            }
        });

    }

    private void setupValueChangedListeners() {

        rValue.textProperty().addListener((observable) -> {
            rHex.setText(Integer.toHexString(pm.rCIProperty().get()).toUpperCase());
            updateRectColor();
        });

        gValue.textProperty().addListener((observable -> {
            gHex.setText(Integer.toHexString(pm.gCIProperty().get()).toUpperCase());
            updateRectColor();
        }));

        bValue.textProperty().addListener((observable -> {
            bHex.setText(Integer.toHexString(pm.bCIProperty().get()).toUpperCase());
            updateRectColor();
        }));
    }

    private void setupBindings() {

        darkerButton.textProperty().bind(pm.darkerButtonTitleProperty());
        brighterButton.textProperty().bind(pm.brighterButtonTitleProperty());

        rSlider.valueProperty().bindBidirectional(pm.rCIProperty());
        rValue.textProperty().bindBidirectional(pm.rCSProperty());

        gSlider.valueProperty().bindBidirectional(pm.gCIProperty());
        gValue.textProperty().bindBidirectional(pm.gCSProperty());

        bSlider.valueProperty().bindBidirectional(pm.bCIProperty());
        bValue.textProperty().bindBidirectional(pm.bCSProperty());
    }

    private void updateRectColor() {
        Color c = Color.rgb(pm.rCIProperty().getValue(), pm.gCIProperty().getValue(), pm.bCIProperty().getValue());
        cRect.setFill(c);
    }

    private void checkBrighterButton() {

        if (pm.rCIProperty().get() == 0 && pm.gCIProperty().get() != 0 && pm.bCIProperty().get() != 0) {
            darkerButton.setDisable(false);
        } else {
            darkerButton.setDisable(true);
        }

    }

}