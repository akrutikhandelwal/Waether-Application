# Weather Forecast API

## Overview

This project is a Spring Boot application that integrates with the Weather API from RapidAPI. It provides endpoints to retrieve weather forecast summaries and hourly weather details for any city. The application uses header-based authentication to secure access to these endpoints.

## Features

- **Get Weather Forecast Summary**: Retrieve a summary of the weather forecast for a specified city.
- **Get Hourly Weather Forecast**: Get hourly weather forecast details for a specified city.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **RestTemplate**: For making HTTP requests to the Weather API.
- **RapidAPI**: API for weather data.

## Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/akrutikhandelwal/Weather-Application.git
 
2. **Configure Application Properties**:
Update the src/main/resources/application.properties file with your RapidAPI credentials:

3. **Build And Run the Appliartion**:
mvn clean install
mvn spring-boot:run

4. **Get Weather Forecast Summary**:

curl --location 'http://localhost:8080/api/weather/summary/{cityName}' \
--header 'clientid: 6779ef20e75817b79602' \
--header 'x-auth-secret-key: secret'

4. **Get Hourly Weather Forecast**:
curl --location 'http://localhost:8080/api/weather/hourly/{cityName}' \
--header 'clientid: 6779ef20e75817b79602' \
--header 'x-auth-secret-key: secret'

This template should give a comprehensive overview of your project and guide users on how to set it up, use it.