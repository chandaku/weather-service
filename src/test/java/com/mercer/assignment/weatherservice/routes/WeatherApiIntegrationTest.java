package com.mercer.assignment.weatherservice.routes;

import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.mercer.assignment.weatherservice.model.WeatherReport;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;



public class WeatherApiIntegrationTest extends AbstractTestCase{

    public static final String API_WEATHER = "/api/weather";

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(8090).notifier(new ConsoleNotifier(true)));

    @Autowired
    private WebTestClient webTestClient;

    @Before
    public void init() {
        stubFor(get(urlPathMatching("/forecast/.*"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(testBody())));
    }


    @Test
    public void shouldReturnOkWhenValidZipCodeisGiven() {
        webTestClient
                .get().uri(API_WEATHER + "/usa?operator=Zip&zip=110001")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void shouldMapToExpectedPayload() {
        webTestClient
                .get().uri(API_WEATHER + "/usa?operator=Zip&zip=110001")
                .exchange()
                .expectStatus().isOk()
                .expectBody(WeatherReport.class)
                .returnResult().getResponseBody();
    }

    private String testBody(){
        return "{\"timezone\":\"Asia/Kolkata\",\"longitude\":\"77.2196\",\"latitude\":\"28.6327\",\"offset\":\"5.5\",\"hourly\":{\"summary\":\"Mostly cloudy until tomorrow afternoon.\",\"icon\":\"partly-cloudy-night\",\"data\":[{\"summary\":\"Partly Cloudy\",\"icon\":\"partly-cloudy-day\",\"windGust\":\"4.83\",\"pressure\":\"1016.27\",\"visibility\":\"6.26\",\"cloudCover\":\"0.57\",\"apparentTemperature\":\"79.95\",\"precipIntensity\":\"0\",\"temperature\":\"79.95\",\"dewPoint\":\"51.48\",\"ozone\":\"242.09\",\"time\":\"1543318200\",\"windSpeed\":\"3.19\",\"humidity\":\"0.37\",\"windBearing\":\"141\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Mostly Cloudy\",\"icon\":\"partly-cloudy-night\",\"windGust\":\"4.43\",\"pressure\":\"1016.65\",\"visibility\":\"10\",\"cloudCover\":\"0.7\",\"apparentTemperature\":\"78.54\",\"precipIntensity\":\"0\",\"temperature\":\"78.54\",\"dewPoint\":\"50.57\",\"ozone\":\"241.75\",\"time\":\"1543321800\",\"windSpeed\":\"2.9\",\"humidity\":\"0.38\",\"windBearing\":\"131\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Mostly Cloudy\",\"icon\":\"partly-cloudy-night\",\"windGust\":\"4.01\",\"pressure\":\"1017.16\",\"visibility\":\"10\",\"cloudCover\":\"0.84\",\"apparentTemperature\":\"77.03\",\"precipIntensity\":\"0\",\"temperature\":\"77.03\",\"dewPoint\":\"50.28\",\"ozone\":\"241.54\",\"time\":\"1543325400\",\"windSpeed\":\"2.95\",\"humidity\":\"0.39\",\"windBearing\":\"121\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"3.74\",\"pressure\":\"1017.65\",\"visibility\":\"10\",\"cloudCover\":\"0.95\",\"apparentTemperature\":\"75.45\",\"precipIntensity\":\"0\",\"temperature\":\"75.45\",\"dewPoint\":\"50.68\",\"ozone\":\"241.36\",\"time\":\"1543329000\",\"windSpeed\":\"3.13\",\"humidity\":\"0.42\",\"windBearing\":\"114\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"3.8\",\"pressure\":\"1017.99\",\"visibility\":\"10\",\"cloudCover\":\"1\",\"apparentTemperature\":\"73.96\",\"precipIntensity\":\"0\",\"temperature\":\"73.96\",\"dewPoint\":\"51.3\",\"ozone\":\"241.05\",\"time\":\"1543332600\",\"windSpeed\":\"3.3\",\"humidity\":\"0.45\",\"windBearing\":\"111\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"4.18\",\"pressure\":\"1018.16\",\"visibility\":\"10\",\"cloudCover\":\"1\",\"apparentTemperature\":\"72.54\",\"precipIntensity\":\"0\",\"temperature\":\"72.54\",\"dewPoint\":\"51.84\",\"ozone\":\"240.64\",\"time\":\"1543336200\",\"windSpeed\":\"3.44\",\"humidity\":\"0.48\",\"windBearing\":\"110\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"4.62\",\"pressure\":\"1018.2\",\"visibility\":\"10\",\"cloudCover\":\"1\",\"apparentTemperature\":\"71.03\",\"precipIntensity\":\"0\",\"temperature\":\"71.03\",\"dewPoint\":\"52.34\",\"ozone\":\"240.27\",\"time\":\"1543339800\",\"windSpeed\":\"3.51\",\"humidity\":\"0.52\",\"windBearing\":\"110\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"4.95\",\"pressure\":\"1018.06\",\"visibility\":\"10\",\"cloudCover\":\"1\",\"apparentTemperature\":\"69.52\",\"precipIntensity\":\"0\",\"temperature\":\"69.52\",\"dewPoint\":\"52.79\",\"ozone\":\"240.07\",\"time\":\"1543343400\",\"windSpeed\":\"3.5\",\"humidity\":\"0.55\",\"windBearing\":\"111\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"5.18\",\"pressure\":\"1017.72\",\"visibility\":\"10\",\"cloudCover\":\"0.99\",\"apparentTemperature\":\"68.35\",\"precipIntensity\":\"0\",\"temperature\":\"68.35\",\"dewPoint\":\"53.16\",\"ozone\":\"240.09\",\"time\":\"1543347000\",\"windSpeed\":\"3.4\",\"humidity\":\"0.58\",\"windBearing\":\"110\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"5.21\",\"pressure\":\"1017.36\",\"visibility\":\"10\",\"cloudCover\":\"0.98\",\"apparentTemperature\":\"67.49\",\"precipIntensity\":\"0\",\"temperature\":\"67.49\",\"dewPoint\":\"53.43\",\"ozone\":\"240.19\",\"time\":\"1543350600\",\"windSpeed\":\"3.22\",\"humidity\":\"0.61\",\"windBearing\":\"109\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"4.7\",\"pressure\":\"1017.16\",\"visibility\":\"10\",\"cloudCover\":\"0.98\",\"apparentTemperature\":\"66.76\",\"precipIntensity\":\"0\",\"temperature\":\"66.76\",\"dewPoint\":\"53.59\",\"ozone\":\"240.23\",\"time\":\"1543354200\",\"windSpeed\":\"2.97\",\"humidity\":\"0.63\",\"windBearing\":\"105\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"3.66\",\"pressure\":\"1017.13\",\"visibility\":\"10\",\"cloudCover\":\"0.98\",\"apparentTemperature\":\"66.24\",\"precipIntensity\":\"0\",\"temperature\":\"66.24\",\"dewPoint\":\"53.69\",\"ozone\":\"240.31\",\"time\":\"1543357800\",\"windSpeed\":\"2.7\",\"humidity\":\"0.64\",\"windBearing\":\"99\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"2.79\",\"pressure\":\"1017.26\",\"visibility\":\"10\",\"cloudCover\":\"0.98\",\"apparentTemperature\":\"66.04\",\"precipIntensity\":\"0\",\"temperature\":\"66.04\",\"dewPoint\":\"53.85\",\"ozone\":\"240.45\",\"time\":\"1543361400\",\"windSpeed\":\"2.49\",\"humidity\":\"0.65\",\"windBearing\":\"93\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"2.82\",\"pressure\":\"1017.62\",\"visibility\":\"10\",\"cloudCover\":\"0.99\",\"apparentTemperature\":\"65.77\",\"precipIntensity\":\"0\",\"temperature\":\"65.77\",\"dewPoint\":\"54.23\",\"ozone\":\"240.7\",\"time\":\"1543365000\",\"windSpeed\":\"2.47\",\"humidity\":\"0.66\",\"windBearing\":\"90\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"3.75\",\"pressure\":\"1018.21\",\"visibility\":\"10\",\"cloudCover\":\"1\",\"apparentTemperature\":\"65.93\",\"precipIntensity\":\"0\",\"temperature\":\"65.93\",\"dewPoint\":\"54.82\",\"ozone\":\"241.05\",\"time\":\"1543368600\",\"windSpeed\":\"2.69\",\"humidity\":\"0.67\",\"windBearing\":\"89\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"4.79\",\"pressure\":\"1018.8\",\"visibility\":\"10\",\"cloudCover\":\"1\",\"apparentTemperature\":\"67.17\",\"precipIntensity\":\"0\",\"temperature\":\"67.17\",\"dewPoint\":\"55.38\",\"ozone\":\"241.47\",\"time\":\"1543372200\",\"windSpeed\":\"3.01\",\"humidity\":\"0.66\",\"windBearing\":\"92\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"5.29\",\"pressure\":\"1019.16\",\"visibility\":\"10\",\"cloudCover\":\"1\",\"apparentTemperature\":\"69.39\",\"precipIntensity\":\"0\",\"temperature\":\"69.39\",\"dewPoint\":\"55.76\",\"ozone\":\"241.89\",\"time\":\"1543375800\",\"windSpeed\":\"3.35\",\"humidity\":\"0.62\",\"windBearing\":\"100\",\"uvIndex\":\"1\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"5.24\",\"pressure\":\"1019.31\",\"visibility\":\"10\",\"cloudCover\":\"0.98\",\"apparentTemperature\":\"72.69\",\"precipIntensity\":\"0\",\"temperature\":\"72.69\",\"dewPoint\":\"55.95\",\"ozone\":\"242.35\",\"time\":\"1543379400\",\"windSpeed\":\"3.71\",\"humidity\":\"0.56\",\"windBearing\":\"112\",\"uvIndex\":\"2\",\"precipProbability\":\"0\"},{\"summary\":\"Overcast\",\"icon\":\"cloudy\",\"windGust\":\"4.88\",\"pressure\":\"1019.22\",\"visibility\":\"10\",\"cloudCover\":\"0.94\",\"apparentTemperature\":\"76.01\",\"precipIntensity\":\"0\",\"temperature\":\"76.01\",\"dewPoint\":\"55.91\",\"ozone\":\"242.84\",\"time\":\"1543383000\",\"windSpeed\":\"3.96\",\"humidity\":\"0.5\",\"windBearing\":\"125\",\"uvIndex\":\"3\",\"precipProbability\":\"0\"},{\"summary\":\"Mostly Cloudy\",\"icon\":\"partly-cloudy-day\",\"windGust\":\"4.23\",\"pressure\":\"1018.76\",\"visibility\":\"10\",\"cloudCover\":\"0.78\",\"apparentTemperature\":\"78.77\",\"precipIntensity\":\"0\",\"temperature\":\"78.77\",\"dewPoint\":\"55.49\",\"ozone\":\"243.23\",\"time\":\"1543386600\",\"windSpeed\":\"3.59\",\"humidity\":\"0.45\",\"windBearing\":\"144\",\"uvIndex\":\"4\",\"precipProbability\":\"0\"},{\"summary\":\"Partly Cloudy\",\"icon\":\"partly-cloudy-day\",\"windGust\":\"3.43\",\"pressure\":\"1017.92\",\"visibility\":\"10\",\"cloudCover\":\"0.5\",\"apparentTemperature\":\"80.99\",\"precipIntensity\":\"0\",\"temperature\":\"80.99\",\"dewPoint\":\"54.69\",\"ozone\":\"243.63\",\"time\":\"1543390200\",\"windSpeed\":\"2.27\",\"humidity\":\"0.4\",\"windBearing\":\"189\",\"uvIndex\":\"4\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"2.76\",\"pressure\":\"1017.05\",\"visibility\":\"10\",\"cloudCover\":\"0.22\",\"apparentTemperature\":\"82.51\",\"precipIntensity\":\"0\",\"temperature\":\"82.51\",\"dewPoint\":\"53.83\",\"ozone\":\"244.23\",\"time\":\"1543393800\",\"windSpeed\":\"2.31\",\"humidity\":\"0.37\",\"windBearing\":\"248\",\"uvIndex\":\"3\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"2.38\",\"pressure\":\"1016.47\",\"visibility\":\"10\",\"cloudCover\":\"0.11\",\"apparentTemperature\":\"83.19\",\"precipIntensity\":\"0\",\"temperature\":\"83.19\",\"dewPoint\":\"53.18\",\"ozone\":\"245.3\",\"time\":\"1543397400\",\"windSpeed\":\"1.79\",\"humidity\":\"0.36\",\"windBearing\":\"235\",\"uvIndex\":\"2\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"2.22\",\"pressure\":\"1016.18\",\"visibility\":\"10\",\"cloudCover\":\"0.16\",\"apparentTemperature\":\"82.52\",\"precipIntensity\":\"0\",\"temperature\":\"82.52\",\"dewPoint\":\"52.74\",\"ozone\":\"246.86\",\"time\":\"1543401000\",\"windSpeed\":\"1.3\",\"humidity\":\"0.36\",\"windBearing\":\"149\",\"uvIndex\":\"1\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"2.22\",\"pressure\":\"1016.11\",\"visibility\":\"10\",\"cloudCover\":\"0.24\",\"apparentTemperature\":\"80.71\",\"precipIntensity\":\"3.0E-4\",\"temperature\":\"80.71\",\"dewPoint\":\"52.48\",\"ozone\":\"248.51\",\"time\":\"1543404600\",\"windSpeed\":\"1.93\",\"humidity\":\"0.38\",\"windBearing\":\"85\",\"uvIndex\":\"0\",\"precipProbability\":\"0.01\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.33\",\"pressure\":\"1016.31\",\"visibility\":\"10\",\"cloudCover\":\"0.23\",\"apparentTemperature\":\"78.76\",\"precipIntensity\":\"3.0E-4\",\"temperature\":\"78.76\",\"dewPoint\":\"52.49\",\"ozone\":\"249.82\",\"time\":\"1543408200\",\"windSpeed\":\"2.12\",\"humidity\":\"0.4\",\"windBearing\":\"59\",\"uvIndex\":\"0\",\"precipProbability\":\"0.01\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.49\",\"pressure\":\"1016.79\",\"visibility\":\"10\",\"cloudCover\":\"0.14\",\"apparentTemperature\":\"76.86\",\"precipIntensity\":\"0\",\"temperature\":\"76.86\",\"dewPoint\":\"52.77\",\"ozone\":\"250.85\",\"time\":\"1543411800\",\"windSpeed\":\"2.18\",\"humidity\":\"0.43\",\"windBearing\":\"52\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.66\",\"pressure\":\"1017.34\",\"visibility\":\"10\",\"cloudCover\":\"0.04\",\"apparentTemperature\":\"74.91\",\"precipIntensity\":\"0\",\"temperature\":\"74.91\",\"dewPoint\":\"53.11\",\"ozone\":\"251.67\",\"time\":\"1543415400\",\"windSpeed\":\"2.27\",\"humidity\":\"0.47\",\"windBearing\":\"52\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.78\",\"pressure\":\"1017.69\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"73.02\",\"precipIntensity\":\"0\",\"temperature\":\"73.02\",\"dewPoint\":\"53.32\",\"ozone\":\"252.12\",\"time\":\"1543419000\",\"windSpeed\":\"2.31\",\"humidity\":\"0.5\",\"windBearing\":\"55\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.83\",\"pressure\":\"1017.86\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"71.13\",\"precipIntensity\":\"0\",\"temperature\":\"71.13\",\"dewPoint\":\"53.33\",\"ozone\":\"252.17\",\"time\":\"1543422600\",\"windSpeed\":\"2.28\",\"humidity\":\"0.53\",\"windBearing\":\"62\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.8\",\"pressure\":\"1017.95\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"69.33\",\"precipIntensity\":\"0\",\"temperature\":\"69.33\",\"dewPoint\":\"53.2\",\"ozone\":\"251.99\",\"time\":\"1543426200\",\"windSpeed\":\"2.23\",\"humidity\":\"0.57\",\"windBearing\":\"68\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.69\",\"pressure\":\"1017.96\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"67.82\",\"precipIntensity\":\"0\",\"temperature\":\"67.82\",\"dewPoint\":\"53.06\",\"ozone\":\"251.56\",\"time\":\"1543429800\",\"windSpeed\":\"2.08\",\"humidity\":\"0.59\",\"windBearing\":\"67\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.52\",\"pressure\":\"1017.87\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"66.74\",\"precipIntensity\":\"0\",\"temperature\":\"66.74\",\"dewPoint\":\"52.93\",\"ozone\":\"250.83\",\"time\":\"1543433400\",\"windSpeed\":\"1.87\",\"humidity\":\"0.61\",\"windBearing\":\"48\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.34\",\"pressure\":\"1017.77\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"65.86\",\"precipIntensity\":\"0\",\"temperature\":\"65.86\",\"dewPoint\":\"52.78\",\"ozone\":\"250.16\",\"time\":\"1543437000\",\"windSpeed\":\"1.76\",\"humidity\":\"0.63\",\"windBearing\":\"19\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.19\",\"pressure\":\"1017.64\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"64.72\",\"precipIntensity\":\"0\",\"temperature\":\"64.72\",\"dewPoint\":\"52.59\",\"ozone\":\"249.75\",\"time\":\"1543440600\",\"windSpeed\":\"1.65\",\"humidity\":\"0.65\",\"windBearing\":\"356\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.1\",\"pressure\":\"1017.49\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"63.48\",\"precipIntensity\":\"0\",\"temperature\":\"63.48\",\"dewPoint\":\"52.35\",\"ozone\":\"249.63\",\"time\":\"1543444200\",\"windSpeed\":\"1.81\",\"humidity\":\"0.67\",\"windBearing\":\"344\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.1\",\"pressure\":\"1017.45\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"62.74\",\"precipIntensity\":\"0\",\"temperature\":\"62.74\",\"dewPoint\":\"52.23\",\"ozone\":\"249.67\",\"time\":\"1543447800\",\"windSpeed\":\"1.95\",\"humidity\":\"0.69\",\"windBearing\":\"332\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-night\",\"windGust\":\"2.32\",\"pressure\":\"1017.72\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"62.89\",\"precipIntensity\":\"0\",\"temperature\":\"62.89\",\"dewPoint\":\"52.48\",\"ozone\":\"249.77\",\"time\":\"1543451400\",\"windSpeed\":\"1.89\",\"humidity\":\"0.69\",\"windBearing\":\"325\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"2.87\",\"pressure\":\"1018.29\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"63.7\",\"precipIntensity\":\"0\",\"temperature\":\"63.7\",\"dewPoint\":\"53.1\",\"ozone\":\"249.9\",\"time\":\"1543455000\",\"windSpeed\":\"1.94\",\"humidity\":\"0.68\",\"windBearing\":\"303\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"3.62\",\"pressure\":\"1018.87\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"65.23\",\"precipIntensity\":\"0\",\"temperature\":\"65.23\",\"dewPoint\":\"53.65\",\"ozone\":\"249.88\",\"time\":\"1543458600\",\"windSpeed\":\"2.57\",\"humidity\":\"0.66\",\"windBearing\":\"288\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"4.45\",\"pressure\":\"1019.19\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"68\",\"precipIntensity\":\"0\",\"temperature\":\"68\",\"dewPoint\":\"53.76\",\"ozone\":\"249.51\",\"time\":\"1543462200\",\"windSpeed\":\"3.02\",\"humidity\":\"0.6\",\"windBearing\":\"283\",\"uvIndex\":\"1\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"5.34\",\"pressure\":\"1019.25\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"71.9\",\"precipIntensity\":\"0\",\"temperature\":\"71.9\",\"dewPoint\":\"53.41\",\"ozone\":\"248.83\",\"time\":\"1543465800\",\"windSpeed\":\"3.51\",\"humidity\":\"0.52\",\"windBearing\":\"296\",\"uvIndex\":\"3\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"6.18\",\"pressure\":\"1019.08\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"75.73\",\"precipIntensity\":\"0\",\"temperature\":\"75.73\",\"dewPoint\":\"52.62\",\"ozone\":\"248.06\",\"time\":\"1543469400\",\"windSpeed\":\"4.46\",\"humidity\":\"0.45\",\"windBearing\":\"304\",\"uvIndex\":\"5\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"6.76\",\"pressure\":\"1018.56\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"78.74\",\"precipIntensity\":\"0\",\"temperature\":\"78.74\",\"dewPoint\":\"51.27\",\"ozone\":\"247.43\",\"time\":\"1543473000\",\"windSpeed\":\"5.26\",\"humidity\":\"0.38\",\"windBearing\":\"299\",\"uvIndex\":\"5\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"7.1\",\"pressure\":\"1017.72\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"81\",\"precipIntensity\":\"0\",\"temperature\":\"81\",\"dewPoint\":\"49.39\",\"ozone\":\"246.95\",\"time\":\"1543476600\",\"windSpeed\":\"5.8\",\"humidity\":\"0.33\",\"windBearing\":\"305\",\"uvIndex\":\"5\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"7.37\",\"pressure\":\"1016.85\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"82.33\",\"precipIntensity\":\"0\",\"temperature\":\"82.33\",\"dewPoint\":\"47.51\",\"ozone\":\"246.64\",\"time\":\"1543480200\",\"windSpeed\":\"6.17\",\"humidity\":\"0.3\",\"windBearing\":\"313\",\"uvIndex\":\"4\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"7.77\",\"pressure\":\"1016.23\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"82.76\",\"precipIntensity\":\"0\",\"temperature\":\"82.76\",\"dewPoint\":\"46.14\",\"ozone\":\"246.44\",\"time\":\"1543483800\",\"windSpeed\":\"6.15\",\"humidity\":\"0.28\",\"windBearing\":\"318\",\"uvIndex\":\"2\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"8.31\",\"pressure\":\"1015.87\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"81.95\",\"precipIntensity\":\"0\",\"temperature\":\"81.95\",\"dewPoint\":\"45.3\",\"ozone\":\"246.37\",\"time\":\"1543487400\",\"windSpeed\":\"5.74\",\"humidity\":\"0.28\",\"windBearing\":\"322\",\"uvIndex\":\"1\",\"precipProbability\":\"0\"},{\"summary\":\"Clear\",\"icon\":\"clear-day\",\"windGust\":\"8.59\",\"pressure\":\"1015.74\",\"visibility\":\"10\",\"cloudCover\":\"0\",\"apparentTemperature\":\"80.02\",\"precipIntensity\":\"0\",\"temperature\":\"80.02\",\"dewPoint\":\"44.86\",\"ozone\":\"246.54\",\"time\":\"1543491000\",\"windSpeed\":\"5.2\",\"humidity\":\"0.29\",\"windBearing\":\"324\",\"uvIndex\":\"0\",\"precipProbability\":\"0\"}]}}";
    }
}