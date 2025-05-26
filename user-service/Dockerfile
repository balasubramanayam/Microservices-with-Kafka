FROM openjdk:21
WORKDIR /app
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9191
CMD ["java", "-jar", "app.jar"]