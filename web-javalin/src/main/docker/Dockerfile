FROM eclipse-temurin:24-jdk-alpine-3.21@sha256:d729416b123cd50d4a70122328ae17d38adced6fa767062d0c0f134e5843deab


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
