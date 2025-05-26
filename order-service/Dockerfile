FROM openjdk:21
WORKDIR /app
COPY target/order-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9194
CMD ["java", "-jar", "app.jar"]