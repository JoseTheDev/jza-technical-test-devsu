FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY target/account-service.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]