1. Interview started with a Dynamic Programming Question
    - Rahul wants to buy ice creams from each shop in the neighbourhood.
      There are N different ice creams sellers in a line.
      Three flavours of ice cream: vanilla, chocolate and strawberry are available with every seller but at different
      prices.
      Rahul wants to buy exactly one ice-cream from one shop and avoid buying the same ice-cream from adjacent shops.
      If the cost of each ice-cream in each shop is provided in a Nx3 matrix,
      Calculate the minimum amount of money that Rahul must spend after he visits every shop.

      Example: Input: N = 3
      cost =
      {
      {1, 50, 50},
      {50, 50, 50},
      {1, 50, 50}
      }
      Output: 52
      Explanation: Shop 1: Buy vanilla for Rs 1. Shop 2: Buy chocolate or strawberry for Rs 50. Shop 3: Buy vanilla for
      Rs 1. Total = 1+50+1 = 52

      {
      {4, 50, 50},
      {1, 50, 50},
      {1, 1, 50}
      }
      Output: 52
      - My Solution - Not working - prints 55
          - ```java
            class HelloWorld {
               public static void main(String[] args) {
                  int [][] N = {{4, 50, 50}, {1, 50, 50}, {1, 1, 50}};
                  
                  int cost = 0;
                  int prevIndex = -1;
                  for(int i=0;i<N.length;i++){
                     int sum0 = 0, sum1 = 0, sum2 = 0;
                     int minIndex = 0;
                     for(int j=i;j<N.length;j++){
                        sum0 = sum0 + N[j][0];
                        sum1 = sum1 + N[j][1];
                        sum2 = sum2 + N[j][2];
                     }
               
                     if(prevIndex != -1){
                        if(prevIndex == 0){
                           if(sum1<sum2)
                              minIndex = 1;
                           else minIndex = 2;
                        }
                        else if(prevIndex == 1){
                           if(sum0<sum2)
                              minIndex = 0;
                           else minIndex = 2;
                        }
                        else if(prevIndex == 2){
                           if(sum0<sum1)
                              minIndex = 0;
                           else minIndex = 1;
                        }
                     }
                     else{
                        if(sum0 < sum1){
                           if(sum0 < sum2)
                              minIndex = 0;
                           else minIndex = 2;
                        }
                        else if(sum1 < sum2)
                           minIndex = 1;
                        else
                        minIndex = 2;
                     }
                     cost = cost + N[i][minIndex];
                     prevIndex = minIndex;
                  }
                  System.out.println(cost);
               }
            }
            ```

2. What is meant by `@SpringBootApplication` annotation? Which all annotations do this comprise?
    - It is the entry level annotation of a Spring Application.
    - It comprises `@Configuration`, `@ComponentScan` and `@EnableAutoConfiguration`

3. `@Transactional`? Where is it used - Service or Repository? Transaction Propagation and Isolation in Spring?
   - We can annotate a `Bean` with `@Transactional` at the interface, class or method level.
   - As Service and Repository both are Beans, we can use `@Transactional` with both of them.
   - Note:- Usually it’s not recommended to set `@Transactional` on the interface; however, it is acceptable for cases like `@Repository` with Spring Data. 
   - Propagation
     - Propagation defines our business logic’s transaction boundary. Spring manages to start and pause a transaction according to our propagation setting.
     - Propagation and its types are explained well in this YouTube video - https://www.youtube.com/watch?v=O9vrhKlGZbE&t=20m45s

4. You have a Controller class. There is a Service layer interface and you have 2 implementations of that interface? How
   will you specify which one to use in your controller?
   - You'll need a dependency injection container or framework to configure the bindings between the Service interface and its implementations. This container will be responsible for creating and injecting the appropriate implementation into the Controller.
   - ```java
     public interface MyService {
       void someServiceMethod();
     }
     public class MyServiceImpl1 implements MyService {
       @Override
       public void someServiceMethod() {
          // Implementation 1
       }
     }
     public class MyServiceImpl2 implements MyService {
       @Override
       public void someServiceMethod() {
          // Implementation 2
       }
     }
     public class MyController {
       private final MyService myService;
       public MyController(MyService myService) {
          this.myService = myService;
       }
       // Use myService in your controller methods
       public void controllerMethod() {
          myService.someServiceMethod();
       }
     }

     @Configuration
     public class AppConfig {
       @Bean
       public MyService myService() {
          // Return the specific implementation you want to use, e.g., MyServiceImpl1 or MyServiceImpl2
          return new MyServiceImpl1();
       }
     }
     ```
5. Tell me about OOPS?
6. Give output of following inheritance code?
    - ```java
      class Parent {
        public Parent(){
            System.out.println("Parent");
        }
      }
      
      class Child extends Parent {
        public Child() { System.out.println("Child"); }
      }
      
      public class Test {
        public static void main(String[] args){
            Parent obj1 = new Child(); // Output: Parent Child
            Child obj2 = new Child(); // Output: Parent Child
        }
      }
      ```
7. What do you understand by Generics in Java?
8. Difference between HashMap and TreeMap?