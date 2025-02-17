FROM eclipse-temurin:23-jdk-alpine@sha256:e595e82dfab54cf44d8a7e7803d9d3f37842ce370d3156d6a5b30317d2774910

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
