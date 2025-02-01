#Start with base image supporting JDK
FROM openjdk:17-jdk-slim

#Information around who maintains the image
MAINTAINER tech2java.com

#Add the application to container
COPY /build/libs/accounts-01-2025.jar accounts-01-2025.jar

#Execute the application
ENTRYPOINT ["java", "-jar", "accounts-01-2025.jar"]
