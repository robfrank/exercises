FROM eclipse-temurin:23-jdk-alpine@sha256:4041a6673528fe79214d091abe83324cabb07d31d5be790ac228b90f94cf83a6

RUN apk --no-cache -U upgrade

COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
