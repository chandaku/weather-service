package com.mercer.assignment.weatherservice.client;

import com.mercer.assignment.weatherservice.model.Location;
import com.mercer.assignment.weatherservice.model.WeatherReport;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
class DarkSkyWeatherClient implements WeatherClient {

    WebClient webClient;

    public DarkSkyWeatherClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.darksky.net/forecast/e9684ba415437948531cb7222ce5c011/").build();
    }

    @Override
    public Mono<WeatherReport> getWeatherReport(Location location) {
        return webClient.get().uri("{latitude},{longitude}", location.getLatitude(), location.getLongitude())
                .retrieve().bodyToMono(WeatherReport.class);
    }
}
