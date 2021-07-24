# Product availability service

In this project I used features of multiple Spring Cloud libraries to build a project implementing microservice
architecture design.

## Technology stack

- Java 11
- Spring Boot
- Spring Cloud Netflix Zuul
- Spring Cloud Oauth2
- Spring Cloud Netflix Hystrix
- Spring Cloud Netflix Eureka
- Spring Cloud OpenFeign
- Spring Cloud Sleuth
- Spring Cloud Sleuth Zipkin
- MySql database for Auth Service
- Docker for virtualization and container orchestration

### How to run

- mvn clean install
- docker-compose up --build

## Architecture description

### Discovery Service

A module that uses Spring Cloud Netflix Eureka to work as discovery server.

### Auth Service
Simple Rest Service created with Spring Cloud Oauth2 to provide authentication functionality.
### Catalog Service

This service contains information about products. They are read from CSV file and exposed as REST API.

### Inventory Service

This service manages availability data. Each product has availability in range: <0,n). Availability could be checked by
list of ids or category.

### Product Service

This is an aggregation service. The input of the flow contains identifier or category. Then product data from Catalog
Service is being downloaded and returned only when this product is available. To check this property service invokes
Inventory Service.

### Gateway Service

API Gateway of the application. Every request comes here, then it is routed to proper services using Zuul and Ribbon load
balancer. Gateway Service uses Eureka to obtain address of the service.

### Zipkin

A Zipkin instance is running in the container, which facilitates to perform distributed tracing.
