package com.mercer.assignment.weatherservice.service;

import com.mercer.assignment.weatherservice.domain.Weather;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Qualifier("cityWeatherService")
public class CityWeatherService implements WeatherService{

    @Override
    public Weather getWeather(LocalDate date, String country) {
        return null;
    }
}
