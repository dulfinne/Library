FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/library-service-0.0.1-SNAPSHOT-spring-boot.jar
COPY ${JAR_FILE} libraryservice.jar
ENTRYPOINT ["java", "-jar", "/libraryservice.jar"]