FROM eclipse-temurin:22-jdk-alpine@sha256:f412633b75c929e68fd83d36a3abd9104c778161b987e5088eab645b0e5af3f6

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
