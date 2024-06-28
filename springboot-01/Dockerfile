#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
MAINTAINER tech2java.com

# Add the application's jar to the container
COPY target/springboot-01-0.0.1-SNAPSHOT.jar springboot-01-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/springboot-01-0.0.1-SNAPSHOT.jar"]