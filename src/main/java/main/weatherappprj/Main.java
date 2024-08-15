package main.weatherappprj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WeatherApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Weather Application");
        stage.setScene(scene);

        String css = Objects.requireNonNull(this.getClass().getResource("DarkTheme.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}