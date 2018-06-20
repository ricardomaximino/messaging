 Spring Boot Quickstart Maven Archetype (v2.x)
==============================================

Summary
-------
The project is a Maven archetype for Spring Boot web application 
which has all common standards on place ready for development

- Java 1.8+
- Maven 3.3+
- Spring boot 1.5.9.RELEASE
- Spring cloud Sleuth for distributed tracing
- Lombok abstraction
- Swagger 2 API documentation
- Spring Boot test for unit and integration tests
- Logback configuration  


Installation
------------

To install the archetype in your local repository execute following commands:

```sh
$ git clone https://urlpath/vcp-spring-boot-microservice-archetype.git
$ cd vcp-spring-boot-microservice-archetype
$ mvn clean install
```

Create a project
----------------

```sh
$ mvn archetype:generate \
     -DarchetypeGroupId=com.verisure.vcp \
     -DarchetypeArtifactId=spring-boot-microservice-archetype \
     -DarchetypeVersion=2.0.0 \
     -DgroupId=com.verisure.vcp \
     -DartifactId=vcp-new-microservice \
     -DprojectName=newmicroservice \
     -Dversion=1.0.0-SNAPSHOT \
     -DinteractiveMode=false
```

Test on the browser via SWAGGER
-------------------

```sh
http://localhost:8080/swagger-ui.html
```