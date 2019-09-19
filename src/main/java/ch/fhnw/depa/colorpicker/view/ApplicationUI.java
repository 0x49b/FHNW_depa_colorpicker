package ch.fhnw.depa.colorpicker.view;

import ch.fhnw.depa.colorpicker.model.PresentationModel;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class ApplicationUI extends BorderPane {

    private PresentationModel pm;

    private Menu fileMenu;
    private Menu attributeMenu;

    private MenuItem closeItem;

    private Alert alert;

    public ApplicationUI(PresentationModel presentationModel) {
        pm = presentationModel;

        initializeSelf();
        initializeMenuBar();
        initializeContent();
        setupEventHandlers();
        setupValueChangedListeners();
        setupBindings();
    }

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeMenuBar() {
        fileMenu = new Menu();
        attributeMenu = new Menu();

        closeItem = new MenuItem();

        fileMenu.getItems().addAll(closeItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, attributeMenu);

        menuBar.prefWidthProperty().bind(pm.getPrimaryStage().widthProperty());
        this.setTop(menuBar);
    }

    private void initializeContent() {
        ControlsView controlsView = new ControlsView(pm);
        setCenter(controlsView);
    }


    private void setupEventHandlers() {
    }

    private void setupValueChangedListeners() {

        // Menu Item to close application
        closeItem.setOnAction(event -> {
            alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.CANCEL);
            alert.setHeaderText(pm.getAlertHeaderText());
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                Platform.exit();
                System.exit(0);
            }
        });

    }

    private void setupBindings() {
        fileMenu.textProperty().bind(pm.fileMenuTitleProperty());
        attributeMenu.textProperty().bind(pm.attributesMenuTitleProperty());

        closeItem.textProperty().bind(pm.closeMenuItemTitleProperty());
    }
}
