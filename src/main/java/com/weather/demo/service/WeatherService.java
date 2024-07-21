package com.weather.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.demo.Constants.CommonConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherService {

    @Value("${rapidapi.host}")
    private String rapidApiHost;

    @Value("${rapidapi.key}")
    private String rapidApiKey;

   @Autowired final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getWeatherForecastSummary(String cityName) {

        String url =getUrl(cityName, "/summary/");
        HttpHeaders headers = getHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        log.info("summary api");
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

 
    public ResponseEntity<String> getHourlyWeatherForecast(String cityName) {
        String url = getUrl(cityName, "/hourly/");
         HttpHeaders headers = getHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
         log.info("hourly api");
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

     private String getUrl(String cityName, String endPoint) { 
         return String.join("", CommonConstants.URL,cityName, endPoint);
    }

       private HttpHeaders getHeaders() {
         HttpHeaders headers = new HttpHeaders();
        headers.set(CommonConstants.HOST, rapidApiHost);
        headers.set(CommonConstants.KEY, rapidApiKey);
        return headers;
    }

}
