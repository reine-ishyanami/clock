package com.reine.clock;

import com.reine.clock.job.CustomService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label timeLabel;


    private CustomService customService;

    @FXML
    void refreshTime(ActionEvent event) {
        customService.restart();
        customService.valueProperty().addListener(((observable, oldValue, newValue) -> {
            Optional.ofNullable(newValue).ifPresent(value -> {
                timeLabel.setText(value.format(DateTimeFormatter.ofPattern("hh:mm:ss.SSS")));
            });
        }));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customService = new CustomService();
    }
}
