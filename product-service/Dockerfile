FROM openjdk:21
WORKDIR /app
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9192
CMD ["java", "-jar", "app.jar"]