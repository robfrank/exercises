FROM eclipse-temurin:23-jdk-alpine@sha256:72c7270962071bc68627d510787f7ead6edb7588a0fc466d46e8065a46f08c0f

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
