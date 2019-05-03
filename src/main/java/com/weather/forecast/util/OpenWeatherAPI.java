package com.weather.forecast.util;

import com.weather.forecast.model.Forecast;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "weatherClient")
public interface OpenWeatherAPI {

    @RequestLine("GET /data/2.5/forecast?q={city}&APPID={key}")
    Forecast getForecast(@Param(value = "city") String city, @Param(value = "key") String appKey);

}
