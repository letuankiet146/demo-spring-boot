# Demo-spring-boot
Project use to practice Spring Boot that include of: Spring WebMVC+ Spring JPA + Spring Security

# What I learned from here:

1. Start up spring boot: 
 1.1 Creating schema and data automatically
 1.2 Validate table in database between entity object

2. What different between annotation, such as:
 2.1 @Autowired vs @Resource
 2.2 @Component vs @Controller vs @Service vs @Repository

3. Using Spring JPA
 3.1 When do we use the existing CRUDRepository and when do we create new repository
 
4. Spring Web MVC

5. Spring Security
 *NOTE: DO NOT create @GetMapping for /error and /login. DO NOT passing th:object
 5.1 What is default configuration of the Spring Security
 5.2 Using _csrf ? What is it? When do we use it?
 5.3 Using account in database instead of adding a user into memory.
  
# Run demo
1. Open terminal
2. Run `mvnw spring-boot:run`
3. [Optional] Debugging: comment out `configuration` field in pom.xml

