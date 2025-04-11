FROM openjdk:17-jdk-slim

WORKDIR /app

COPY user-activity-producer/target/*.jar app.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]