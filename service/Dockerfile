FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /workspace/app

# Copy gradle files for dependency resolution
COPY gradle gradle
COPY gradlew .
COPY settings.gradle.kts .
COPY build.gradle.kts .
COPY buildSrc buildSrc
COPY api/build.gradle.kts api/
COPY service/build.gradle.kts service/

# Run gradle to download dependencies (will be cached in Docker layers)
RUN ./gradlew --no-daemon dependencies

# Copy source code
COPY api/src api/src
COPY service/src service/src
COPY api/src/main/resources/openapi.yaml api/src/main/resources/

# Build the application
RUN ./gradlew --no-daemon :service:bootJar

# Extract layers for better caching
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Create a non-root user to run the application
RUN addgroup -S hackathon && adduser -S hackathon -G hackathon

# Set necessary environment variables
ENV SPRING_PROFILES_ACTIVE=prod
ENV JAVA_OPTS=""

# Copy the built JAR from the build stage
COPY --from=build /workspace/app/service/build/libs/service.jar /app/service.jar

# Set ownership to the non-root user
RUN chown -R hackathon:hackathon /app

# Switch to non-root user
USER hackathon

# Expose the application port
EXPOSE 8081

# Run the application with health check
HEALTHCHECK --interval=30s --timeout=3s --retries=3 CMD wget -q --spider http://localhost:8081/api/actuator/health || exit 1

# Start the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/service.jar"]