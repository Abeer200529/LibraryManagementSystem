# Step 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN ./mvnw clean package -DskipTests

# Step 2: Run the application using a lightweight Java runtime
FROM eclipse-temurin:21-jre-alpine
COPY --from=build /target/LibraryManagementSystem-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]