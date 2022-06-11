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

    /**
     * 开启计时器
     *
     * @param event 鼠标点击事件
     */
    @FXML
    void refreshTime(ActionEvent event) {
        customService.restart();
        customService.valueProperty().addListener(((observable, oldValue, newValue) -> {
            Optional.ofNullable(newValue).ifPresent(value -> {
                timeLabel.setText(value.format(DateTimeFormatter.ofPattern("hh:mm:ss.SSS")));
            });
        }));
    }

    /**
     * 暂停计时器
     *
     * @param event 鼠标点击事件
     */
    @FXML
    void stopTime(ActionEvent event) {
        customService.cancel();
    }

    /**
     * 初始化
     *
     * @param location  fxml资源文件路径
     * @param resources 国际化语言设置
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customService = new CustomService();
    }
}
