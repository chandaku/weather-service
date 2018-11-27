package com.mercer.assignment.weatherservice.handler;

import com.mercer.assignment.weatherservice.client.WeatherClient;
import com.mercer.assignment.weatherservice.exception.LocationNoFoundException;
import com.mercer.assignment.weatherservice.model.Location;
import com.mercer.assignment.weatherservice.model.WeatherReport;
import com.mercer.assignment.weatherservice.repo.LocationRepo;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static java.util.Optional.ofNullable;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.error;
import static reactor.core.publisher.Mono.just;

@Component
public class WeatherApiHandler {

    private static final String COUNTRY = "country";

    private final ErrorHandler errorHandler;

    private final LocationRepo locationRepo;

    private final WeatherClient weatherClient;

    public WeatherApiHandler(ErrorHandler errorHandler, LocationRepo locationRepo, WeatherClient weatherClient) {
        this.errorHandler = errorHandler;
        this.locationRepo = locationRepo;
        this.weatherClient = weatherClient;
    }

    public Mono<ServerResponse> doPing(ServerRequest request) {
        return ok().body(just("Welcome to Weather Service!!" + request.uri().getPath()), String.class);
    }

    public Mono<ServerResponse> getWeatherOnZip(ServerRequest request) {
         return request.queryParam("zip")
         .map(zip->{
             return just(request.pathVariable(COUNTRY))
                     .transform(country-> this.buildResponse(country, zip))
                     .onErrorResume(errorHandler::throwableError);
         }).orElse(errorHandler.queryParamNotFound(request, "zip"));
    }


    public Mono<ServerResponse> getWeatherOnCity(ServerRequest request) {
        return ServerResponse.ok()
                .body(Mono.just(new WeatherReport()), WeatherReport.class);
    }

    private Mono<ServerResponse> buildResponse(final Mono<String> country, String zip) {
        Location location = locationRepo.getLocation(Integer.valueOf(zip));
        return ofNullable(location)
                .map(found ->serverResponse(weatherClient.getWeatherReport(found)))
                .orElse(error(new LocationNoFoundException("Location Not Found "+ zip)));
    }

    private Mono<ServerResponse> serverResponse(Mono<WeatherReport> weatherMono) {
        return weatherMono.flatMap(weatherReponse ->
                ok().body(just(weatherReponse), WeatherReport.class));
    }
}
