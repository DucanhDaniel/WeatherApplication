module main.weatherappprj {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires htmlunit;

    opens main.weatherappprj to javafx.fxml;
    exports main.weatherappprj;
}