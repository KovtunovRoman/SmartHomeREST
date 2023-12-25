FROM openjdk:17
WORKDIR /smart_server
COPY /smart-container/target/*.jar /smart_server/smart.jar
ENTRYPOINT ["java", "-jar", "/smart_server/smart.jar"]