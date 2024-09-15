FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/book-service-0.0.1-SNAPSHOT-spring-boot.jar
COPY ${JAR_FILE} bookservice.jar
ENTRYPOINT ["java", "-jar", "/bookservice.jar"]
