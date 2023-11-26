FROM openjdk:17-oracle

COPY ./target .

ENTRYPOINT ["java", "-jar", "websocket-app.jar"]