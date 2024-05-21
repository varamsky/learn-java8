### Spring

1. What is Spring?
2. What is a Bean?
3. What is Inversion of Control(IOC)?
    - IOC is an idea.
    - The idea is to inverse the control. Instead of the programmer creating and managing objects, this is handled by Spring.
4. What is Dependency Injection?
    - Dependency Injection is the implementation of IOC
5. `@Component` vs `@Bean`?
    - The `@Bean` annotation is a method-level annotation, whereas `@Component` is a class-level annotation.
    - The `@Component` annotation doesn't need to be used with the `@Configuration` annotation, whereas the `@Bean`
      generic annotation has to be used within a class annotated with `@Configuration`.
    - `@Component` is compatible with Spring’s auto-detection, but `@Bean` requires manual class instantiation.
6. What is a microservice? What is the advantage over monolithic architecture?
    - Microservice architecture is a way to build your applications where you break them down into smaller pieces and
      deploying them separately and them make them talk to each other so that they together form your complete
      application.
    - Now, this doesn't mean that if you have separate codebases then you have created a microservice because you can
      have separate codebases and still have a monolith. It's more about deploying them separately.
    - Advantages over monoliths:
        - They have a smaller surface area for change. In case of monolith if errors occurs then you have a very big
          codebase to look for and solve the error, whereas with microservices it is limited to the particular
          microservice.
        - Also, this means that when you make a code change, instead of testing the whole monolith application you only
          need to test the particular microservice(given that its communication contract with other microservices has
          not changed).

7. What is RESTful?
    - REpresentational State Transfer
    - RESTful is a way to build your APIs that follows the REST specification.
    - The REST specification involves:
        - Treating an individual "Resource"
        - Having individual "ENDPOINTS" mapped to the Resource
        - Having certain "VERBS" in terms of what you want to do with the Resource

8. What are Client Certificates?
    - Client Certificate is a digital certificate used to make requests(authenticated as well as unauthenticated) to a
      remote server.

9. Explain the use of PACT in microservices architecture?
   - Pact is a code-first contract testing tool, which requires access to the code on both sides of an integration
     point.

10. What is OAuth?
    - OAuth means Open Authorization protocol. This protocol allows you to access the client applications on HTTP for
      third-party providers like Google, Github, etc.
    - It helps you to share resources stored on one site with another site without the need for their credentials.

11. What is difference between @Controller and @RestController?
    - `@RestController` is basically `@Controller` + `@ResponseBody`
    - So it is used to reduce boilerplate else you would need to annotate with `@ResponseBody` on class level one-time
      or else add to all methods which use Response Body.

12. How can we configure multiple data-sources in our Spring Boot Application?
    - In your `application.properties` file define configuration properties for each data source
    - ```
      # Primary DataSource configuration
      spring.datasource.primary.url=jdbc:mysql://localhost:3306/primary_db
      spring.datasource.primary.username=root
      spring.datasource.primary.password=secret
      spring.datasource.primary.driver-class-name=com.mysql.cj.jdbc.Driver
      
      # Secondary DataSource configuration
      spring.datasource.secondary.url=jdbc:mysql://localhost:3306/secondary_db
      spring.datasource.secondary.username=root
      spring.datasource.secondary.password=secret2
      spring.datasource.secondary.driver-class-name=com.mysql.cj.jdbc.Driver
      ```
    - Create a configuration to configure your data source. Here we create separate configuration classes for each data
      source but this can also be done in a single Configuration class.
    - ```java
      // imports
      @Configuration
      @EnableJpaRepositories(
      basePackages = "com.example.repository.primary",
      entityManagerFactoryRef = "primaryEntityManagerFactory",
      transactionManagerRef = "primaryTransactionManager"
      )
      public class PrimaryDataSourceConfig {
      
      @Primary
      @Bean(name = "primaryDataSource")
      @ConfigurationProperties(prefix = "spring.datasource.primary")
      public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
      }
      
      @Primary
      @Bean(name = "primaryEntityManagerFactory")
      public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("primaryDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.domain.primary")
                .persistenceUnit("primary")
                .build();
      }
      
      @Primary
      @Bean(name = "primaryTransactionManager")
      public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory primaryEntityManagerFactory) {
        return new JpaTransactionManager(primaryEntityManagerFactory);
      }
      }```
    - Do the same for the other data-sources as well.

13. How to load a dataset into your database when you run the application for the first time?
    - Place the SQL statements into a sql file like `data.sql` and keep it in your `src/resources` folder
    - So, these will get executed when your application starts

14. How to set up and use multiple profile in Spring Boot?
    - You can set up multiple profiles with Spring Boot like `application-dev.properties`, `application-prod.properties`, and so on.
    - Now you need to set the appropriate profile. There are several ways to set active profiles in a Spring Boot application:
      1. Via `application.properties` or `application.yml`
         - In application.properties: ```spring.profiles.active=dev```
      2. Programmatically 
         - You can also set active profiles programmatically by calling `setAdditionalProfiles(...)` on the SpringApplication object in your main application class:
         - ```java
           public static void main(String[] args) {
           SpringApplication app = new SpringApplication(MyApplication.class);
           app.setAdditionalProfiles("dev");
           app.run(args);
           }
           ```
      3. Environment Variable
         - You can set an bash environment variable SPRING_PROFILES_ACTIVE:```export SPRING_PROFILES_ACTIVE=dev```
    
15. What are annotations in Spring Boot?
    - Core Spring Framework Annotations
      `@SpringBootApplication`: A convenience annotation that adds all of the following:
      - `@Configuration`: Tags the class as a source of bean definitions for the application context.
      - `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
      - `@ComponentScan`: Tells Spring to scan for other components, configurations, and services in the specified package, allowing it to find controllers and other components.
    - `@Bean`: Used at the method level; indicates that a method produces a bean to be managed by the Spring container.
    - `@Component`: Indicates that an annotated class is a "component" and will be auto-detected when using annotation-based configuration and classpath scanning.
    - `@Autowired`: Marks a constructor, field, or setter method to be autowired by Spring's dependency injection facilities.
    - `@Value`: Used to inject property values into components.
    - `@Profile`: Indicates that a component is only eligible for registration when one or more specified profiles are active.

16. How to disable auto-configuration for a specific class?
    - In Spring Boot, auto-configuration is designed to simplify the setup and configuration of applications by automatically configuring Spring beans based on the classpath contents and defined beans. However, there might be situations where you want to exclude certain auto-configuration classes because they don't fit your specific needs or you prefer to configure them manually.
    - You can disable specific auto-configuration classes using the exclude attribute of the `@EnableAutoConfiguration` or `@SpringBootApplication` annotations. Since `@SpringBootApplication` is a more commonly used entry point for Spring Boot applications and it indirectly includes `@EnableAutoConfiguration`, you'll typically use it to exclude auto-configuration classes.
    - Here's how to do it:
      - Using the exclude attribute of `@SpringBootApplication`
      - You can specify the auto-configuration classes you want to exclude by their class names. This is done in the `@SpringBootApplication` annotation on your main application class.
        - ```java
          import org.springframework.boot.autoconfigure.SpringBootApplication;
          import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
          @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
          public class MySpringBootApplication {
        
            public static void main(String[] args) {
                SpringApplication.run(MySpringBootApplication.class, args);
            }
          }
          ```
      - In this example, DataSourceAutoConfiguration is excluded, meaning Spring Boot won't automatically configure a datasource even if it detects database-related libraries on the classpath.

17. On which port does Spring Boot start by default?
    - 8080
    - We can change it by adding `server.port` with a different value in `application.properties`:
      - ```server.port=8081```

18. How to load property values from the `application.properties` file?
    - To load property values from the `application.properties` file in a Spring Boot application, you can use the `@Value` annotation, or environment abstraction. Below are examples demonstrating these methods.
      1. Using the @Value Annotation
        The @Value annotation allows you to inject property values into fields, methods, and constructors.
        Example:
        Assuming your `application.properties` file contains the following property: ```app.welcomeMessage=Welcome to our application!```
        You can inject this property into a field in one of your `@Component` or `@Service` classes like this:
         - ```java
           import org.springframework.beans.factory.annotation.Value;
           import org.springframework.stereotype.Component;
          
           @Component
           public class WelcomeService {
                @Value("${app.welcomeMessage}")
                private String welcomeMessage;
                
                public String getWelcomeMessage() {
                    return welcomeMessage;
                }
           }
           ```
      2. Using the Environment Abstraction
         Spring provides an Environment abstraction that can be used to access properties. You can inject the Environment into your beans and use it to retrieve property values. Example:
         - ```java
           import org.springframework.beans.factory.annotation.Autowired;
           import org.springframework.core.env.Environment;
           import org.springframework.stereotype.Component;
           
           @Component
           public class EnvironmentService {
           
                private final Environment environment;
           
                @Autowired
                public EnvironmentService(Environment environment) {
                    this.environment = environment;
                }
           
                public String getWelcomeMessage() {
                    return environment.getProperty("app.welcomeMessage");
                }
           }
           ```
         Each of these methods has its use cases. The @Value annotation is simple and straightforward for individual properties. The @ConfigurationProperties approach is more suited for loading hierarchical configuration data into a domain object. The Environment abstraction provides a programmatic way to access properties and is useful when you need dynamic property access or when working with profiles.

19. What are the various logging levels?
    - In Spring Boot, logging levels are used to specify the amount of detail you want your application logs to contain. These levels are part of the underlying logging frameworks that Spring Boot supports (like Logback, Log4J2, and JUL (Java Util Logging)). Setting the appropriate log level for your application and its various components can help you control the verbosity of your logs, which is crucial for debugging and monitoring your application effectively. 
    - Here are the primary logging levels in Spring Boot, ordered from the least to the most verbose:
      1. OFF: Turn off logging.
      2. ERROR: Log only error events that might still allow the application to continue running.
      3. WARN: Log potentially harmful situations that indicate potential issues that are not necessarily errors.
      4. INFO: Log informational messages that highlight the progress of the application at a coarse-grained level. This is typically the default level configured for applications in production.
      5. DEBUG: Log fine-grained informational events that are most useful for debugging the application. This level is usually enabled during development.
      6. TRACE: Log very detailed information about the behavior of the application. This level is more verbose than DEBUG and is used for diagnosing issues during development.

20. Can you briefly explain main components of the microservices architecture?
    - We have these main components
      1. API Gateway - used to routes the requests to the specific microservice
      2. Eureka Server - to Discover various microservices in your application
      3. Hystrix or Resilience4J - used for Fault Tolerance

21. How to handle circular dependency problem?
    - Have a look at this video by [Concept && Coding - by Shrayansh](https://youtu.be/W-TgmKAnGG0?si=OuovlIrYvEFnHmHh&t=1649)
    - Suppose there are 2 classes Order and Invoice. Order has Invoice as a parameter to be injected and vice-versa.
    - There are 3 ways to solve this:-
      1. Refactor code to remove the circular dependency(MOST RECOMMENDED)
      2. Use `@Lazy` on `@Autowired` annotation on the parameter(on the parameter and not on the class itself). So, both Invoice and Order will be created but the injection will be postponed due to `@Lazy` and by that time both instance will already have been created.
      3. Using `@PostConstruct`. NOT RECOMMENDED.

22. Difference between EnumType.ORDINAL and EnumType.STRING?
    -  We can mark a table column to use enums as shown below:-
    - ```java
       enum Roles {
        USER, ADMIN, SUPERUSER
       }
       
       @Column(nullable = false)
       @Enumerated(EnumType.ORDINAL) // or EnumType.STRING
       private Roles role;
      ```
    - But as you see above, we have 2 options to mark EnumType as ORDINAL or STRING.
    - `ORDINAL` is efficient memory-wise but is not human-readable because when you describe the table in the database the column type is `TINYINT`(in MySQL, may vary in other databases)
    - `STRING` takes more space but is also human-readable because when you describe the table the column type is `enum('USER','ADMIN','SUPERUSER')`
    - With `STRING` you can do two things, without touching the database, that `ORDINAL` can't handle:
       - you can change the order of your enums
       - you can insert new enums in the middle of the enum list
    - Both of these changes will alter the ordinal values of the enums already in use in the database, thus breaking existing data if you are using ORDINAL.

23. How to lazy load a `@ManyToOne` or `@OneToMany` attribute?
    - ```java
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name="USER_ID")
      private User user;
      ```
    - Use `FetchType.LAZY` with `@ManyToOne` annotation. Also, we might need to specify `@JoinColumn` and point it to the primary of the other table(DOUBT)!
    - NOT VERY SURE ABOUT THIS!!

24. How to implement and use global exception handlers?

25. What is Cascade in Spring?



