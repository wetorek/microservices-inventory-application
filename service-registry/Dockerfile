FROM openjdk:11-jdk
MAINTAINER B Mzyk <mzyku12@gmail.com>
ADD target/service-registry.jar service-registry.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/service-registry.jar"]