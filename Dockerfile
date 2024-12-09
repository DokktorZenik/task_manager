FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/taskservice-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]