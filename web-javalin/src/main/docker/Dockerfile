FROM eclipse-temurin:22.0.1_8-jre-alpine@sha256:51eb4ff83a261313a040f9661395ea9385f76ff62c802ef994ac72c9f469340e
COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
