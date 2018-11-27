package com.mercer.assignment.weatherservice.client;

import com.mercer.assignment.weatherservice.model.Location;
import com.mercer.assignment.weatherservice.model.WeatherReport;
import reactor.core.publisher.Mono;

public interface WeatherClient {
    Mono<WeatherReport> getWeatherReport(Location location);
}
