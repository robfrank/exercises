FROM eclipse-temurin:23-jdk-alpine@sha256:62f73af9ec69cc3056ef92e2887b6398e23365d71bb06ff57d475f718e3f8723

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
