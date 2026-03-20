# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Maven ko kam RAM use karne ke liye limit lagana zaroori hai
ENV MAVEN_OPTS="-Xmx256m"
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Render automatically PORT environment variable set karta hai
EXPOSE 8080

# Java app ko 300MB se zyada RAM use karne se rokna
ENTRYPOINT ["java", "-Xmx300m", "-jar", "app.jar"]
