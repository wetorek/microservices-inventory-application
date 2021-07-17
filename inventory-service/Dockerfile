FROM openjdk:11-jdk
MAINTAINER B Mzyk <mzyku12@gmail.com>
ADD target/inventory-service.jar inventory-service.jar
EXPOSE 7171
ENTRYPOINT ["java", "-jar", "/inventory-service.jar"]