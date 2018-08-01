FROM openjdk:8-jdk-alpine
VOLUME /tmp1
ARG JAR_FILE
COPY ${JAR_FILE} product-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/product-service.jar"]
