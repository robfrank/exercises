FROM eclipse-temurin:24-jdk-alpine-3.21@sha256:da2196e2ec0d51d8c4c88c19f671952d251dd512c19381d5f6eab6d97dbd5908


# Update packages
RUN apk --no-cache -U upgrade

# Create a non-root user to run the application
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Create directory for the application
RUN mkdir -p /app && chown -R appuser:appgroup /app

# Copy the application jar
COPY maven/exercises-web-javalin-*.jar /app/app.jar

# Set proper permissions
RUN chown appuser:appgroup /app/app.jar

# Switch to non-root user
USER appuser

# Expose the application port
EXPOSE 7070

# Run the application
WORKDIR /app
ENTRYPOINT ["java", "-jar", "app.jar"]
