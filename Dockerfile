FROM openjdk:8-jdk-alpine
RUN apk add --no-cache curl tar bash
VOLUME /tmp
ADD build/libs/rest-api-tutorial-0.1.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/app.jar"]