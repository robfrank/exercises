FROM eclipse-temurin:22.0.1_8-jre-alpine@sha256:92f3cd14681c9e56ad44f25628d3b289e0b463ed25be52f7c5dd29acec43db97
COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
