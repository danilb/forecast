package com.weather.forecast.model;

import lombok.Data;
import java.util.List;

@Data
public class Forecast {
    private City city;
    private List<Weather> list;
}
