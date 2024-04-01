FROM eclipse-temurin:22_36-jre-alpine@sha256:cff33794a241b7381015bcb2fd3c21de05bb573754b1a95165d476edb148cb00
COPY maven/exercises-web-javalin-*.jar /app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app.jar"]
