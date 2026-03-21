# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Maven build without tests to save time
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# FIX: Explicitly copying the correct jar file
COPY --from=build /app/target/taskey-0.0.1-SNAPSHOT.jar app.jar

# Render automatically sets PORT environment variable
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
