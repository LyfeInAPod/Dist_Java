# Getting Started

##PREREQUISITES

###To deploy the application you would need Java 8 installed in your system. To check that use the following command:
 - java -version
###Maven is required to build the Application

##Build the application with the given command from the project directory:
 - mvn clean package

## deploy using (Replace the placeholder <>)
 - java -jar <path/to/build/app.jar>   

##You may also deploy directly from project folder using:
 - mvn spring-boot:run
 
 
## To view the embeded database goto: 
http://localhost:8080/h2-console 
   - connect using:
       Driver Class : org.h2.Driver
       JDBC Url : jdbc:h2:mem:testdb
       User Name: sa
       Leave the password blank
       
## Application deploys by default at port 8080.       
   http://localhost:8080
 
