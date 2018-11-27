# weather-service
Weather Service is based on Springboot Webflux and is Modeled with TDD approach.

## Run With Gradle

Inside Project directory run following commands:

Build Project
```asciidoc
./gradelw clean build
```

Run Test case
```asciidoc
./gradlew test
```

To Run Project

```asciidoc
./gradlew bootRun
```

After Project is started then run
```asciidoc
http://localhost:8080/api/weather/india?operator=Zip&zip=110001
```

For Now only supported for two zip code 110001 and 126102. For now implementation is done with 
open source api "https://api.darksky.net". 
