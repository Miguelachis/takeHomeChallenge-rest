FROM openjdk:19-jdk-slim

WORKDIR /app

COPY target/takeHomeChallenge-rest-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]