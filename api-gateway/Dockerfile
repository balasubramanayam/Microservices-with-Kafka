FROM openjdk:21
WORKDIR /app
COPY target/api-gateway-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8060
CMD ["java", "-jar", "app.jar"]