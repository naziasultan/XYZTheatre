# XYZTheatre

1- Application will run on 8080 port run cmd - mvn spring-boot:run

2- Swagger url for API Contract http://localhost:8080/swagger-ui/index.html

3- JPA Console http://localhost:8080/h2-console

4- Database details
    JDBCURL = jdbc:h2:mem:testdb
    username=sa
    password=password

5- All Appi should work except the http://localhost:8080/api/movies?title=A as there no elastic-search implemented 