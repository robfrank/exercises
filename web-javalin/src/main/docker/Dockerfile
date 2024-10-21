FROM eclipse-temurin:23-jdk-alpine@sha256:e28f3fadcb8e498ae6c2ad0ba617bb193dea50c044cd8972016cfdcfbfc98f25

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
