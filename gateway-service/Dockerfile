FROM openjdk:11-jdk
MAINTAINER B Mzyk <mzyku12@gmail.com>
ADD target/gateway-service.jar gateway-service.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "/gateway-service.jar"]
