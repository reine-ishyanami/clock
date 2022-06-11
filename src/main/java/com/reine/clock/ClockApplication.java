package com.reine.clock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClockApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(this.getClass().getClassLoader().getResource("fxml/clock-view.fxml"));
        BorderPane root = fxmlLoader.load();
        root.getStylesheets().add(this.getClass().getClassLoader().getResource("css/clock.css").toExternalForm());
        Scene scene = new Scene(root);
        stage.setTitle("LocalTime");
        stage.setScene(scene);
        stage.getIcons().add(new Image("static/images/logo.png"));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}