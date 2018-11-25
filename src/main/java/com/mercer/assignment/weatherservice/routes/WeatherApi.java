package com.mercer.assignment.weatherservice.routes;

import com.mercer.assignment.weatherservice.handler.WeatherApiHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class WeatherApi {
        private static final String API = "/api/weather";
        private static final String NA = "";


        @Bean
        public RouterFunction<ServerResponse> routes(WeatherApiHandler weatherApiHandler) {
            return nest(path(API),
                    route(OPTIONS(NA), weatherApiHandler::doPing)
                            .andRoute(GET("/{country}"), weatherApiHandler::getByZipCode)
            );
        }
    }
