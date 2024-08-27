FROM eclipse-temurin:22-jdk-alpine@sha256:e9f5baeaae1e07d85b84f83760615e0c23513c2a2eec46cda8e4984ead9de602

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
