FROM openjdk:11-jdk
MAINTAINER B Mzyk <mzyku12@gmail.com>
ADD target/product-service.jar product-service.jar
EXPOSE 6161
ENTRYPOINT ["java", "-jar", "/product-service.jar"]