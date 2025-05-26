FROM openjdk:21
WORKDIR /app
COPY target/notification-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9195
CMD ["java", "-jar", "app.jar"]