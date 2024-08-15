package main.weatherappprj;

import data.WeatherData;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import obj.CityWeather;

import java.util.Objects;

public class WeatherAppSceneController {

    public ImageView weatherImg;
    public Label temperatureLabel;
    public Label descLabel;
    public Label feelLikeLabel;
    public Label sunRiseSetLabel;
    public Label windSpeedLabel;
    public Label visibilityLabel;
    public Label humidityLabel;
    public Label tempLowHighLabel;
    public TextField nameLabel;
    public Button updateBtn;
    public Label ngayLabel;
    public Label demLabel;
    public Label sangLabel;
    public Label toiLabel;
    public Label coLabel;
    public Label nh3Label;
    public Label noLabel;
    public Label no2Label;
    public Label o3Label;
    public Label pm10Label;
    public Label pm25Label;
    public Label so2label;
    public Label airOveral;
    public Label airDesc;
    public Circle CircleShape;
    public Label airTitle;

    public void updateWeather(ActionEvent event) {
        String cityName = nameLabel.getText();
        CityWeather weather = WeatherData.getWeather(cityName);
        if (weather!=null) {
            weatherImg.setImage(new Image(weather.getWeatherIconUrl()));
            temperatureLabel.setText(weather.getTemperature());
            descLabel.setText(weather.getWeatherDescribing());
            feelLikeLabel.setText(weather.getFeelsLike());
            sunRiseSetLabel.setText(weather.getSunRiseSet());
            windSpeedLabel.setText(weather.getWindSpeed());
            visibilityLabel.setText(weather.getVisibility());
            humidityLabel.setText(weather.getHumidity());
            tempLowHighLabel.setText(weather.getLowHighTemp());
            ngayLabel.setText(WeatherData.getTemperatureAtTime(cityName, 1));
            demLabel.setText(WeatherData.getTemperatureAtTime(cityName, 2));
            sangLabel.setText(WeatherData.getTemperatureAtTime(cityName, 3));
            toiLabel.setText(WeatherData.getTemperatureAtTime(cityName, 4));

            CircleShape.setVisible(true);
            String airOveralText = WeatherData.getAirOveral();
            if (Objects.requireNonNull(airOveralText).toLowerCase().contains("rất kém"))
                CircleShape.setFill( new Color( 1.0, 0.62, 0.62, 0.69));
            else if (Objects.requireNonNull(airOveralText).toLowerCase().contains("kém"))
                CircleShape.setFill( new Color( 0.83, 0.66, 0.47, 0.69));
            else if (Objects.requireNonNull(airOveralText).toLowerCase().contains("tốt"))
                CircleShape.setFill( new Color( 0.71, 1.0, 0.61, 0.69));
            else if (Objects.requireNonNull(airOveralText).toLowerCase().contains("bình thường"))
                CircleShape.setFill( new Color( 0.61, 0.89, 1.0, 0.69));


            airOveral.setText(WeatherData.getAirOveral());
            airDesc.setText(WeatherData.getAirDesc());

            coLabel.setText(WeatherData.getAirQualityIndex(1));
            nh3Label.setText(WeatherData.getAirQualityIndex(2));
            noLabel.setText(WeatherData.getAirQualityIndex(3));
            no2Label.setText(WeatherData.getAirQualityIndex(4));
            o3Label.setText(WeatherData.getAirQualityIndex(5));
            pm10Label.setText(WeatherData.getAirQualityIndex(6));
            pm25Label.setText(WeatherData.getAirQualityIndex(7));
            so2label.setText(WeatherData.getAirQualityIndex(8));

        } else {
            System.out.println("City not found.");
        }
    }
}
