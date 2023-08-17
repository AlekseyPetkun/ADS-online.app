FROM maven:3.6.3-openjdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/target/ADS-onlineApp-0.0.1-SNAPSHOT.jar ADS-onlineApp.jar
EXPOSE 8080
CMD ["java", "-jar", "ADS-onlineApp.jar"]