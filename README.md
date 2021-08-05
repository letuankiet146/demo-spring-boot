# Demo-spring-boot
Project use to practice Spring Boot that include of: Spring WebMVC+ Spring JPA + Spring Security

# What I learned from here:

1. Start up spring boot<br/>
 1.1 Creating schema and data automatically<br/>
 1.2 Validate table in database between entity object

2. What different between annotation, such as:<br/>
 2.1 @Autowired vs @Resource<br/>
 2.2 @Component vs @Controller vs @Service vs @Repository

3. Using Spring JPA<br/>
 3.1 When do we use the existing CRUDRepository and when do we create new repository
 
4. Spring Web MVC

5. Spring Security<br/>
 *NOTE: DO NOT create @GetMapping for /error and /login. DO NOT passing th:object<br/>
 5.1 What is default configuration of the Spring Security<br/>
 5.2 Using _csrf ? What is it? When do we use it?<br/>
 5.3 Using account in database instead of adding a user into memory.<br/>
 5.4 Using Oauth2 login<br/>
 5.5 Setting level of role <br/>
 5.6 `@PreAuthorize("hasRole('ADMIN')")` should be placed in Service component<br/>

6. Configuration property<br>
 6.1 Defining the configurationProperty bean which use to get property value from .property and .yml file<br>
 6.2 Please add `maven-resources-plugin` while intending to use .propety and .yml at the same time.<br>

# Run demo
1. Open terminal
2. Run `mvnw spring-boot:run`
3. [Optional] Debugging: comment out `configuration` field in pom.xml

