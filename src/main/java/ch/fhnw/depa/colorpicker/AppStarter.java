package ch.fhnw.depa.colorpicker;

import ch.fhnw.depa.colorpicker.model.PresentationModel;
import ch.fhnw.depa.colorpicker.view.ApplicationUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PresentationModel pm = new PresentationModel(primaryStage);
        Parent rootPanel = new ApplicationUI(pm);

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(pm.applicationTitleProperty());
        primaryStage.setMinWidth(500);
		primaryStage.setMinHeight(250);
		primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
