FROM openjdk:11-jdk
MAINTAINER B Mzyk <mzyku12@gmail.com>
ADD target/auth-service.jar auth-service.jar
EXPOSE 5151
ENTRYPOINT ["java", "-jar", "/auth-service.jar"]