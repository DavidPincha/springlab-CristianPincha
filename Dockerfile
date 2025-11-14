# Etapa 1
FROM gradle:8.4-jdk21 AS builder
WORKDIR /app
COPY . .
RUN gradle chmod +x gradlew

# Etapa 2
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
