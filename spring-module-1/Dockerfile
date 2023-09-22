# Use a base image with Java 17 pre-installed
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY build/libs/spring-module-1-1.0-SNAPSHOT.jar app.jar

# Expose a port if your application listens on a specific port (replace 8080 with your actual port)
EXPOSE 8080

# Specify the command to run your Java application
ENTRYPOINT ["java", "-jar", "app.jar"]