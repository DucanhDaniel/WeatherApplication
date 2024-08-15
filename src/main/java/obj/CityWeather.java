package obj;

public class CityWeather {
    private String cityName;
    private String temperature;
    private String weatherDescribing;
    private String feelsLike;
    private String lowHighTemp;
    private String humidity;
    private String visibility;
    private String windSpeed;
    private String sunRiseSet;
    private String weatherIconUrl;

    public String getCityName() {
        return cityName;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWeatherDescribing() {
        return weatherDescribing;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public String getLowHighTemp() {
        return lowHighTemp;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getSunRiseSet() {
        return sunRiseSet;
    }

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public CityWeather(String cityName, String temperature, String weatherDescribing, String feelsLike, String logHighTemp, String humidity, String visibility,
                String windSpeed, String sunRiseSet, String weatherIconUrl) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.weatherDescribing = weatherDescribing;
        this.feelsLike = feelsLike;
        this.lowHighTemp = logHighTemp;
        this.humidity = humidity;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.sunRiseSet = sunRiseSet;
        this.weatherIconUrl = weatherIconUrl;
    }

    @Override
    public String toString() {
        return "City: " + cityName + "\n" +
               "Temperature: " + temperature + "\n" +
               "Weather Describing: " + weatherDescribing + "\n" +
               "Feels Like: " + feelsLike + "\n" +
               "Low-High Temperature: " + lowHighTemp + "\n" +
               "Humidity: " + humidity + "\n" +
               "Visibility: " + visibility + "\n" +
               "Wind Speed: " + windSpeed + "\n" +
               "Sunrise-Set: " + sunRiseSet + "\n" +
                "Weather Icon URL: " + weatherIconUrl;
    }

}
