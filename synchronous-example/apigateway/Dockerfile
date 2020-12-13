FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT exec java -jar /app.jar api-gateway
