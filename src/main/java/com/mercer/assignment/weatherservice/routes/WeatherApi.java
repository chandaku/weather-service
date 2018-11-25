package com.mercer.assignment.weatherservice.routes;

import com.mercer.assignment.weatherservice.handler.WeatherApiHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.util.ReflectionUtils.findMethod;
import static org.springframework.util.ReflectionUtils.invokeMethod;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;
import static reactor.core.publisher.Mono.justOrEmpty;

@Component
public class WeatherApi {
        private static final String API = "/api/weather";

        @Bean
        public RouterFunction<ServerResponse> routes(WeatherApiHandler weatherApiHandler) {
            return nest(path(API),
                    route(OPTIONS(""), weatherApiHandler::doPing)
                            .andRoute(GET("/{country}"), request ->
                                    request.queryParam("operator")
                                            .map(
                                                    operator -> justOrEmpty(findMethod(WeatherApiHandler.class, "getWeatherOn" + operator, ServerRequest.class))
                                                            .flatMap(method -> (Mono<ServerResponse>) invokeMethod(method, weatherApiHandler, request))
                                            )
                                            .orElse(badRequest().build()))
            );
        }

}
