### Spring

1. What is Spring?
2. What is a Bean?
3. What is Dependency Injection?
4. What is Inversion of Control?
5. `@Component` vs `@Bean`?
    - The `@Bean` annotation is a method-level annotation, whereas `@Component` is a class-level annotation.
    - The `@Component` annotation doesn't need to be used with the `@Configuration` annotation, whereas the `@Bean`
      generic annotation has to be used within a class annotated with `@Configuration`.
    - `@Component` is compatible with Spring’s auto-detection, but `@Bean` requires manual class instantiation.
6. How to maintain multiple profiles in a Spring Application?
   - We can maintain multiple Spring profiles using 2 methods:
     - If we use `application.properties` file then we need to have different files for different profiles.
     - If we use `yaml` then we can have multiple profiles in a single file and separate them with 3 dashes(---) like,
       - ```yaml
         spring:
            profiles: dev
         logging:
            level:
            .: error
            org.springframework: ERROR
         server:
            port: 8085
         ---
         spring:
            profiles: prod
         server:
            port: 8080
         ```
         
7. What is a microservice? What is the advantage over monolithic architecture?
   - Microservice architecture is a way to build your applications where you break them down into smaller pieces and deploying them separately and them make them talk to each other so that they together form your complete application.
   - Now, this doesn't mean that if you have separate codebases then you have created a microservice because you can have separate codebases and still have a monolith. It's more about deploying them separately.
   - Advantages over monoliths:
     - They have a smaller surface area for change. In case of monolith if errors occurs then you have a very big codebase to look for and solve the error, whereas with microservices it is limited to the particular microservice.
     - Also, this means that when you make a code change, instead of testing the whole monolith application you only need to test the particular microservice(given that its communication contract with other microservices has not changed).

8. What is RESTful?
    - REpresentational State Transfer
    - RESTful is a way to build your APIs that follows the REST specification.
    - The REST specification involves:
      - Treating an individual "Resource"
      - Having individual "ENDPOINTS" mapped to the Resource
      - Having certain "VERBS" in terms of what you want to do with the Resource

9. What are Client Certificates?
    - Client Certificate is a digital certificate used to make requests(authenticated as well as unauthenticated) to a remote server.

10. Explain the use of PACT in microservices architecture?
    - Pact is a code-first contract testing tool, which requires access to the code on both sides of an integration point.

11. What is OAuth?
    - OAuth means Open Authorization protocol. This protocol allows you to access the client applications on HTTP for third-party providers like Google, Github, etc.
    - It helps you to share resources stored on one site with another site without the need for their credentials.

