FROM openjdk:11-jdk-oracle
VOLUME /tmp
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]