package com.reine.clock.controller;

import com.reine.clock.job.CustomService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClockController implements Initializable {

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
                // 使用24小时制，输出格式 时:分:秒.毫秒
                timeLabel.setText(value.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
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

    @FXML
    public void top(ActionEvent actionEvent) {
        Button setTop = (Button) actionEvent.getSource();
        Stage window = (Stage) setTop.getParent().getScene().getWindow();
        if (setTop.getUserData() == null) {
            setTop.setUserData(false);
        }
        boolean isTop = (boolean) setTop.getUserData();
        window.setAlwaysOnTop(!isTop);
        setTop.setUserData(!isTop);

    }

}
