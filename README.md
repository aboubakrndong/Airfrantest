# Airfrantest

Offer technical test
# Spring Boot "Technical test" Project


Airfrantest is a Spring boot API that exposes two services, 
one that allows to register a user , one that displays the details of a registered user

# How to run

The Spring Initializr creates a main class that you can use to launch the application. The following listing (from src/main/java/com/example/AirFrantest/AirFrantestApplication.java) shows the application class that the Spring Initializr created:

Build the project using mvn clean install
Run using mvn spring-boot:run
The web application is accessible via localhost:8080
Use username and password for the register user in database to login to the app

# What you need 
About 15 minutes
A favorite text editor or IDE
JDK 1.8 or later
Gradle 4+ or Maven 3.2+
You can also import the code straight into your IDE:
Spring Tool Suite (STS)
IntelliJ IDEA

# Technologies and dependencies 
✓ Java version: 8
✓ Packaging: Jar
✓ Dependencies
• Spring Boot DevTools
• Postgres
• Spring Data JPA
• Spring Web
• H2 database 
• Lombok

# How to uses the API Airfrantest

  To show user with lastName
  GET: /userapi/v1/lastName
  
To register a user
  POST:  /userapi/v1/
  
take into account the constraints linked to each field and
especially to age and country of residence    

To modify user with LastName
   PUT /userapi/v1/lastName
   
   # Swagger 
   
http://localhost:8082/swagger-ui.html

