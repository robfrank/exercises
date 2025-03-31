FROM eclipse-temurin:24-jdk-alpine-3.21@sha256:7b2b481c0d8d9575d0b5739256c54b54ed6dd86b8ae09820e6aa33ba3a06cc9b


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
