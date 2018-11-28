FROM openjdk:8-jre-alpine
ENV FC_LANG en-US
ENV LC_CTYPE en_US.UTF-8

# dependencies
RUN apk add --update bash ttf-dejavu fontconfig

# fix broken cacerts
RUN apk add --update java-cacerts && \
    rm -f /usr/lib/jvm/default-jvm/jre/lib/security/cacerts && \
    ln -s /etc/ssl/certs/java/cacerts /usr/lib/jvm/default-jvm/jre/lib/security/cacerts

ENV APP_DIR /app
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} $APP_DIR/app.jar
WORKDIR $APP_DIR
EXPOSE 8001
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","app.jar"]
