FROM openjdk:21
WORKDIR /app
COPY target/cart-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9193
CMD ["java", "-jar", "app.jar"]