FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install gradle -y
RUN ./gradlew clean build

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build build/libs/santander-dev-week-2023-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]