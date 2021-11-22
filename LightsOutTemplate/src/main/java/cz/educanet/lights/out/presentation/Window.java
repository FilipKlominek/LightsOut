package cz.educanet.lights.out.presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Window extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/game-window.fxml")));

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Lights Out!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
