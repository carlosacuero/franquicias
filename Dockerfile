FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/franquicias-api.jar franquicias-api.jar
ENTRYPOINT ["java","-jar","/franquicias-api.jar"]
