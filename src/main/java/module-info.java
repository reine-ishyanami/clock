module com.reine.clock {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.reine.clock to javafx.fxml;
    exports com.reine.clock;
}