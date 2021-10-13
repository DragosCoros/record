FROM openjdk:11-jre-slim
VOLUME /tmp
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dfile.encoding=utf8","-jar","-noverify","-XX:+AlwaysPreTouch","/app.jar"]