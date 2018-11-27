# weather-service
Weather Service is based on Springboot Webflux and is Modeled with TDD approach. 

## Run With Gradle

Inside Project directory run following commands:

Build Project
```asciidoc
./gradelw clean build
```

To Run Project, WEATHER_SERVICE_URL is configurable.

```asciidoc
./gradlew bootRun -PjvmArgs="-DWEATHER_SERVICE_URL=https://api.rksky.net/forecast"
```

After Project is started then run
```asciidoc
http://localhost:8080/api/weather/india?operator=Zip&zip=110001
```

only supported for two zip code 110001 and 126102. To Add more zipcode changes needed in ZipLocationService.java. For now implementation is done with 
open source api "https://api.darksky.net". 

## Testing

Unit & Integraton Tests are avaialble in test package. Integration Test is implemented with wiremock where third party weather service 
is integrated.