package com.mercer.assignment.weatherservice.service;

import com.mercer.assignment.weatherservice.domain.Weather;

import java.time.LocalDate;

public interface WeatherService {
    Weather getWeather(LocalDate date, String country);
}
