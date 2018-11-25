package com.mercer.assignment.weatherservice.handler;

import com.mercer.assignment.weatherservice.domain.Weather;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

@Component
public class WeatherApiHandler {

    private static final String COUNTRY = "country";

    private final ErrorHandler errorHandler;

    public WeatherApiHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
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
        return buildResponse(Mono.empty(),"");
    }

    private Mono<ServerResponse> buildResponse(final Mono<String> country, String zip) {
        return this.serverResponse(just(new Weather()));
    }

    private Mono<ServerResponse> serverResponse(Mono<Weather> weatherMono) {
        return weatherMono.flatMap(weatherReponse ->
                ServerResponse.ok().body(Mono.just(weatherReponse), Weather.class));
    }
}
