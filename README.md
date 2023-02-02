# Application Programming Interface - Test Banco Pichincha

## Felipe Esteban R P
### felipe.riano@globant.com

## Documentation

##

The documentation and the script of db are on the _**docs folder.**_

For the API documentation for this project, 
in this case the project is deployed in an EC2 instance, to access its documentation 
it can be done through the following link:


## Gradle Build
``` ./gradlew build && java -jar build/libs/gs-spring-boot-docker-0.1.0.jar ```
## Build the image
``` docker build -t feliperp973922/applicationprogramminginterface .  ```
## Run image
``` sudo docker run --restart always -p 8080:8080 feliperp973922/applicationprogramminginterface ```
