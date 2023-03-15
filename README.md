# Spring-MyBatis-Account-Module

Basic login-register template that helps speed development of the systems that needs an accounting module.
The module is made to be modularized, making it easy to integrate with other existing modules as well as maintain.

# Requirements

- [Docker](https://docs.docker.com/get-docker/)
- [Postgresql (v15.0)](https://www.postgresql.org/download/)
- [Intellij (EAP) *preferred*](https://www.jetbrains.com/toolbox-app/)
- [Spring Boot (v2.7.5)](https://spring.io/quickstart)
- [Maven](https://maven.apache.org/index.html)
- [Java SDK (v17.0.5)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Github](https://git-scm.com/downloads)

# Features

* Login page
* Registration page
* Will add more in the future

# Tools

* [Spring Framework/Boot](https://spring.io/)
* [Mapstruct](https://mapstruct.org/)
* [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
* [Database Rider](https://github.com/database-rider/database-rider)
* [Spring starter test](https://www.javatpoint.com/spring-boot-starter-test)
* [Thymeleaf](https://www.thymeleaf.org/)
* [Wavefront](https://docs.wavefront.com/wavefront_monitoring.html)
* [Slf4j](https://www.slf4j.org/)
* [Flywaydb](https://flywaydb.org/)
* [MyBatis](https://mybatis.org/mybatis-3/)

# Getting Started

 1. Download and install Docker, Postgresql, Java with their appropriate versions.
 2. Open the application then enter the command at terminal/shell
    ```sh
        docker-compose up
    ```
 3. check application.properties in the `/src/main/resources` if the port on `spring.datasource.url` is the same as the port assigned on the docker container 
 4. Build then run the application (Automatically creates table needed to store data if it does not exist)
    
# Issues

- none as of the moment

# References
 - [How to set up Thymeleaf](https://www.baeldung.com/thymeleaf-in-spring-mvc)
 - [Spring Security Filters Guide](https://www.baeldung.com/security-none-filters-none-access-permitAll)
 - [How to make registration with Spring Security](https://www.baeldung.com/registration-with-spring-mvc-and-spring-security)
 - [Login with Spring Security](https://www.baeldung.com/spring-security-login)
 - [Setup spring and mybatis](https://mybatis.org/spring/)
 - [Using spring-mybatis dependency to speed up configuration](https://www.baeldung.com/spring-mybatis)
 - [Creating a spring-mybatis app tutorial video](https://www.youtube.com/watch?v=ZP8Um12Z_mk)