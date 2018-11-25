package com.mercer.assignment.weatherservice.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

@Component
public class WeatherApiHandler {

    public Mono<ServerResponse> doPing(ServerRequest request) {
        return ok().body(just("Welcome to Weather Service!!" + request.uri().getPath()), String.class);
    }

    public Mono<ServerResponse> getByZipCode(ServerRequest request) {
        return ok().body(just("Welcome to Weather Service!!" + request.uri().getPath()), String.class);
    }
}
