FROM eclipse-temurin:23-jdk-alpine@sha256:0201d625fb7777efbba99cdfc99805a58f844413f31b39af0b5cd14057d2b666

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
