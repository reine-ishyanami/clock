package com.reine.clock.job;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.time.LocalTime;

/**
 * @author reine
 * 2022/6/10 7:35
 */
public class CustomService extends Service<LocalTime> {

    @Override
    protected Task<LocalTime> createTask() {
        return new Task<LocalTime>() {
            @Override
            protected LocalTime call() throws Exception {
                while (!isCancelled()) {
                    this.updateValue(LocalTime.now());
                }
                return LocalTime.now();
            }
        };
    }
}
