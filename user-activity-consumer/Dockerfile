FROM openjdk:17-jdk-slim

WORKDIR /app

COPY user-activity-consumer/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]