FROM eclipse-temurin:23-jdk-alpine@sha256:2cb34eaa1bb3d1bdcd6c82c020216385ca278db70311682d8c173f320ee4f4c4

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
