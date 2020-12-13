FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/*.jar app.jar
EXPOSE 8084
ENTRYPOINT exec java -jar /app.jar order-service
