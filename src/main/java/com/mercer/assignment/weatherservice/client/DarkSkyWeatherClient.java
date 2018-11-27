package com.mercer.assignment.weatherservice.client;

import com.mercer.assignment.weatherservice.model.Location;
import com.mercer.assignment.weatherservice.model.WeatherReport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
class DarkSkyWeatherClient implements WeatherClient {

    @Value("${weather.service}")
    private String weatherServiceUrl;

    WebClient.Builder webClientBuilder;

    public DarkSkyWeatherClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<WeatherReport> getWeatherReport(Location location) {
        WebClient webClient = webClientBuilder.baseUrl(weatherServiceUrl + "/forecast/e9684ba415437948531cb7222ce5c011/").build();
        return webClient.get().uri("{latitude},{longitude}", location.getLatitude(), location.getLongitude())
                .retrieve().bodyToMono(WeatherReport.class);
    }
}
