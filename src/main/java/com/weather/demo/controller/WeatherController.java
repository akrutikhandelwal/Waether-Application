package com.weather.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.demo.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/summary/{cityName}")
    public ResponseEntity<String> getWeatherForecastSummary(@PathVariable String cityName) {
        return weatherService.getWeatherForecastSummary(cityName);
    }

    @GetMapping("/hourly/{cityName}")
    public ResponseEntity<String> getHourlyWeatherForecast(@PathVariable String cityName) {
        return weatherService.getHourlyWeatherForecast(cityName);
    }
}