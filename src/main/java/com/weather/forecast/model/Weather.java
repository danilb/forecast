package com.weather.forecast.model;

import lombok.Data;

@Data
public class Weather {
    private long dt;
    private String dt_txt;
    private Main main;
}
