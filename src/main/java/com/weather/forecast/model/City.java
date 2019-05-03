package com.weather.forecast.model;

import lombok.Data;

@Data
public class City {
	private String name;
	private Coordinates coord;
}