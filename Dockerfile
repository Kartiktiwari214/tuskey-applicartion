FROM openjdk:21-jdk-slim

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew build -x test

EXPOSE 8080

CMD ["java","-jar","build/libs/Billing-0.0.1-SNAPSHOT.jar"]
