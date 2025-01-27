FROM eclipse-temurin:23-jdk-alpine@sha256:f09a14108e525af6ab15a775cf3449a24d87a25e0f32575225b4a2bc81611378

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
