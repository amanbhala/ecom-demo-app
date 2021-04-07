# demoapplication-master-main
 Inventory management system with authorisation and authentication
 
 demo-spring-app
A demo Spring Boot application for an inventory management system. This is built from both the consumer and supplier sides, so that both of them may use the same application. This application has been created to be RESTful and follows the Spring MVC model. I started off using a persisted H2 database in the localhost but now I have migrated to a PostgreSQL database instead. I have used Hibernate as the ORM in this application.

Dependencies
This application is containerized using Docker. You will need Docker running on your system in order to build the docker image using the included docker-compose file. For more details, please have a look at the Docker documentation

Steps to start the application:
Clone the repository

Open a terminal in the root folder and run: docker-compose up --build

Launch https://localhost:8080 on your browser. The functional pages are linked there

API calls may be observed via Postman as well, altthough the application is very much designed with the Spring MVC framework in mind

TO DO:
Adding testing frameworks

Adding validations

General code cleanup
