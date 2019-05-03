package com.weather.forecast.util;

import com.weather.forecast.model.Forecast;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherClient {

    @Value("${weather.apiKey}")
    private String APP_KEY;

    @Value("${weather.url}")
    private String URL;

    public Forecast getForecast(String city) {

        OpenWeatherAPI client = Feign.builder()
                .decoder(new GsonDecoder())
                .target(OpenWeatherAPI.class, URL);

        Forecast forecast = client.getForecast(city, APP_KEY);
        return forecast;

    }
}
