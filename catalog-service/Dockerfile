FROM openjdk:11-jdk
MAINTAINER B Mzyk <mzyku12@gmail.com>
ADD target/catalog-service.jar catalog-service.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "/catalog-service.jar"]