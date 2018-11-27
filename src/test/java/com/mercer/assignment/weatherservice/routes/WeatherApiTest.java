package com.mercer.assignment.weatherservice.routes;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class WeatherApiTest {

    public static final String API_WEATHER = "/api/weather";

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private WebClient webClient;

    @Test
    void shouldBeAbleToPingWeatherApi() {
        webTestClient
                .options().uri(API_WEATHER)
                .exchange()
                .expectStatus().isOk();
    }


    @Test
    void shouldBeBadRequestWhenOperatorIsMissing() {
        webTestClient
                .get().uri(API_WEATHER + "/usa")
                .exchange()
                .expectStatus().isBadRequest();
    }


    @Test
    void shouldBeBadRequestWhenZipCodeIsMissing() {
        webTestClient
                .get().uri(API_WEATHER + "/usa?operator=Zip")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void shouldRespondOkWhenOperatorIsCity() {
        webTestClient
                .get().uri(API_WEATHER + "/usa?operator=City")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void shouldReturnLocationNotFoundWhenInvalidZipIsGiven() {
        webTestClient
                .get().uri(API_WEATHER + "/usa?operator=Zip&zip=12345")
                .exchange()
                .expectStatus().isNotFound();
    }


}