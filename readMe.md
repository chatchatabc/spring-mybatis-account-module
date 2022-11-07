# UserModule
Basic login-register template that helps speed development of the systems that needs an accounting module.
The module is made to be modularized, making it easy to integrate with other existing modules as well as maintain.

## Requirements
- [Docker](https://docs.docker.com/get-docker/)
- [Postgresql (v15.0)](https://www.postgresql.org/download/)
- [Intellij (EAP) *preferred*](https://www.jetbrains.com/toolbox-app/)
- [Spring Boot (v2.7.5)](https://spring.io/quickstart)
- [Maven](https://maven.apache.org/index.html)
- [Java SDK (v17.0.5)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Github](https://git-scm.com/downloads)

## Modules
* Login page
* Registration page
* Will add more in the future

## Getting Started

 1. Download and install Docker, Postgresql, Java with their appropriate versions.
 2. Open CMD terminal and enter the command
    > docker run --name [container_name] -e POSTGRES_PASSWORD=[your_password] -d postgres
 3.  Open the application
 4. check application.properties in the `/src/main/resources` if the port on `spring.datasource.url` is the same as the port assigned on the docker container

## Running the Application

 1. run in the terminal:
    > npm install
 2. - If you are using Intellij: Build then run the application
    - If you are not using Intellij: Enter the command at the terminal
    > npm start 
    
### Issues
- Login page opens but logging in does not work
- Registration page does not open, and cant determine if it works