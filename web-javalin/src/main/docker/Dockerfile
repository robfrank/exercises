FROM eclipse-temurin:22-jdk-alpine@sha256:0e6c28c65cf74adcd6c7bdb639c9196cbc9d37eabe7995a04daf0ae65b15b63f

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
