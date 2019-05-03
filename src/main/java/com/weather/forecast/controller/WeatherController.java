package com.weather.forecast.controller;

import com.weather.forecast.model.Forecast;
import com.weather.forecast.util.OpenWeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    private final String validationPattern = "^[a-zA-Z\\s]*$";

    @Autowired
    OpenWeatherClient client;

    @RequestMapping(value = "/data/{city}", method = RequestMethod.GET)
    public ResponseEntity<Forecast> getAverageWeather(@PathVariable("city") String city) {

        if (!city.matches(validationPattern)) return ResponseEntity.noContent().build();

        return new ResponseEntity<>(client.getForecast(city), HttpStatus.OK);
    }
}
