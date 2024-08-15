package data;

import obj.CityWeather;
import org.htmlunit.WebClient;
import org.htmlunit.html.DomNode;
import org.htmlunit.html.HtmlPage;

import java.io.IOException;

public class WeatherData {
    static private String cityName;
    static private String url;
    public static void setCityName(String cityName) {
        WeatherData.cityName = cityName;
        url = "https://thoitiet.app/" + cityName.replace(" ", "-");
    }

    private static WebClient webClient;
    private static HtmlPage page;

    public static void init(String cityName) {
        setCityName(cityName);
        webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        try {
            page = webClient.getPage(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static CityWeather getWeather(String cityName) {
        init(cityName);
        CityWeather weather = null;
        try {
            DomNode tempNode = page.querySelector("div.weather-main-hero > p");
            DomNode weatherDescNode = page.querySelector("div.weather-main-hero > div > p");
            DomNode feelLikeNode = page.querySelector("div.weather-main-hero > div > span");
            DomNode lowHighTempNode = page.querySelector("div.weather-main-desc > div:nth-child(1) > div.temp");
            DomNode humidityNode = page.querySelector("div.weather-main-desc > div:nth-child(2) > div.temp > p");
            DomNode visibilityNode = page.querySelector("div.weather-main-desc > div:nth-child(3) > div.temp > p");
            DomNode winSpeedNode = page.querySelector("div.weather-main-desc > div:nth-child(4) > div.temp > p");
            DomNode windDirNode = page.querySelector("div.weather-main-desc > div:nth-child(5) > div.temp > p");
            DomNode sunRiseSetNode = page.querySelector("div.weather-main-desc > div:nth-child(5) > div.temp > p");
            DomNode weatherIconNode = page.querySelector("div.weather-main-hero > img");
            String weatherIconUrl = weatherIconNode.asXml();


            weather = new CityWeather(cityName,
                    tempNode.asNormalizedText().trim(),
                    weatherDescNode.getTextContent().trim().toUpperCase(),
                    feelLikeNode.asNormalizedText().trim(),
                    lowHighTempNode.asNormalizedText().trim().replace("\n", ""),
                    humidityNode.asNormalizedText().trim(),
                    visibilityNode.asNormalizedText().trim(),
                    winSpeedNode.asNormalizedText().trim(),
                    sunRiseSetNode.asNormalizedText().trim(),
                    weatherIconUrl.substring(10, 62)
            );
            System.out.println(weather.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return weather;
    }

    public static String getTemperatureAtTime(String cityName, int time) {
        try {
                if (time == 1) {
                    DomNode tempNode = page.querySelector("div.weather-day-temp > div:nth-child(1) > div:nth-child(3)");
                    return tempNode.asNormalizedText().trim();
                } else if (time == 2) {
                    DomNode tempNode = page.querySelector("div.weather-day-temp > div:nth-child(2) > div:nth-child(3)");
                    return tempNode.asNormalizedText().trim();
                } else if (time == 3) {
                    DomNode tempNode = page.querySelector("div.weather-day-temp > div:nth-child(3) > div:nth-child(3)");
                    return tempNode.asNormalizedText().trim();
                } else if (time == 4) {
                    DomNode tempNode = page.querySelector("div.weather-day-temp > div:nth-child(4) > div:nth-child(3)");
                    return tempNode.asNormalizedText().trim();
                }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String getAirOveral() {
        DomNode airOveralNode = null;
        for (char x = '1'; x <= '9'; x++) {
            String num = Character.toString(x);
            airOveralNode = page.querySelector("div.air-quality-content.air-" + num + " > p.title");
            if (airOveralNode != null) break;
        }
        if (airOveralNode == null) return null;
        return airOveralNode.asNormalizedText().trim();
    }
    public static String getAirDesc() {
        DomNode airDescNode = null;
        for (char x = '1'; x <= '9'; x++) {
            String num = Character.toString(x);
            airDescNode = page.querySelector("div.air-quality-content.air-" + num + " > p.desc");
            if (airDescNode != null) break;
        }
        if (airDescNode == null) return null;
        return airDescNode.asNormalizedText().trim();
    }
    public static String getAirQualityIndex(int airType) {
        DomNode airQualityIndexNode;
        if (airType == 1) {
            airQualityIndexNode = page.querySelector("div.col-xl-4.weather-highlight-live > div:nth-child(2) > div > div:nth-child(3) > div:nth-child(1) > p");
        }
        else if (airType == 2) {
            airQualityIndexNode = page.querySelector("div.col-xl-4.weather-highlight-live > div:nth-child(2) > div > div:nth-child(3) > div:nth-child(2) > p");
        }
        else if (airType == 3) {
            airQualityIndexNode = page.querySelector("div.col-xl-4.weather-highlight-live > div:nth-child(2) > div > div:nth-child(3) > div:nth-child(3) > p");
        }
        else if (airType == 4) {
            airQualityIndexNode = page.querySelector("div.col-xl-4.weather-highlight-live > div:nth-child(2) > div > div:nth-child(3) > div:nth-child(4) > p");
        }
        else if (airType == 5) {
            airQualityIndexNode = page.querySelector("div.col-xl-4.weather-highlight-live > div:nth-child(2) > div > div:nth-child(4) > div:nth-child(1) > p");
        }
        else if (airType == 6) {
            airQualityIndexNode = page.querySelector("div.col-xl-4.weather-highlight-live > div:nth-child(2) > div > div:nth-child(4) > div:nth-child(2) > p");
        }
        else if (airType == 7) {
            airQualityIndexNode = page.querySelector("div.col-xl-4.weather-highlight-live > div:nth-child(2) > div > div:nth-child(4) > div:nth-child(3) > p");
        }
        else if (airType == 8) {
            airQualityIndexNode = page.querySelector("div.col-xl-4.weather-highlight-live > div:nth-child(2) > div > div:nth-child(4) > div:nth-child(4) > p");
        }
        else {
            return null;
        }
        return airQualityIndexNode.asNormalizedText().trim();
    }
    public static void main(String[] args) {
//        setCityName("ha-noi");
        System.out.println(getWeather("ha-noi"));
    }
}
