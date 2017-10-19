FROM openjdk:8-jdk-alpine

ARG JAR_FILE

ADD target/${JAR_FILE} app.jar

EXPOSE 8761

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /app.jar