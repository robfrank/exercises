FROM eclipse-temurin:22-jdk-alpine@sha256:7121a74ca2f038af7a000c8cd41cb0c32a16e2296df2f43b804956d72a4318d1

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
