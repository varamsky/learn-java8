# Learn Java 8

This project explains the features added in Java 8.

Java 8 was released on 18th March 2014.

Some of the important Java 8 features are:

1. default and static methods in Interfaces 
2. Functional Interfaces and Lambda Expressions
   - [Coding with John - Lambda Expressions](https://www.youtube.com/watch?v=tj5sLSFjVj4)
3. Method References
4. forEach() method in Iterable interface
5. Java Stream API for Bulk Data Operations on Collections 
6. Optional class
7. Java Time API 
8. Collection API improvements 
9. Concurrency API improvements 
10. Java IO improvements


This also mentions a few features which were introduced before java 8 in the BeforeJava8 package
1. Generics - Java5
   - [Coding with John - Generics](https://youtu.be/K1iu1kXkVoA)
2. Mutable and Immutable types
3. varargs - Introduced in Java 5
   - Safe usage of varargs
   - varargs vs array
4. super() - Right now this is confusing for me
	- and not using this.instance variable everytime you use an instance variable? how?


## Interview questions

### Java

1. Rate yourself in java out of 10.
2. Find Length of string without using length()
3. Which is preferred ArrayList or LinkedList? Why?
4. What is Marshalling and Unmarshalling in java?
5. What is a Marker Interface?
6. Why to use char[] array over a string for storing passwords in Java?
7. What are the conditions when the finally-block is not executed?
8. What is a Deadlock condition when working with Threads?
9. What is Garbage Collector in Java? Can we run Garbage Collector anytime we want?
10. What is the `finalize()` method in Garbage Collection?
11. What do you mean by the immutability of `String` in java?
12. What is the difference when a String is created as a literal vs creating String with `new` keyword?
13. What will be the output of `System.out.println(1+2+3+"Hello, World!"+5+6);`?
14. `StringBuffer` vs `StringBuilder` which is more efficient?
15. What are Exceptions in Java? Types? Checked and Unchecked Exceptions.
16. `Comparator` vs `Comparable` in java?
17. What is a singleton pattern and explain its real time usage.
18. Why is java not 100% Object-oriented language?
19. `==` vs `equals()` method in java?
20. Can we override a static method?
21. What will happen if we try to compile and run below program?
    ```java
    interface Foo{ int x = 10;}
        
    public class Test {
     public static void main(String[] args) {
        Foo.x = 20;
        System.out.println(Foo.x);
     }
    }
    ```
    A. Prints 10<br>
    B. Prints 20<br>
    C. Compile Time Error<br>
    D. Runtime error because Foo.x is final.
22. What are the valid statements for static keyword in Java?<br>
    A. We can have static block in a class.<br>
    B. The static block in a class is executed every time an object of class is created.<br>
    C. We can have static method implementations in interface.<br>
    D. We can define static block inside a method.
23. Can we Use object to call a static method?
24. What will be output of the below program?
    ```java
        public class Test {
            public static void main(String[] args) {
                Subclass s1 = new Subclass();
                s1.foo(); // line 6
                Super s = new Subclass();
                s.foo(); // line 8
            }
        }
        
        class Super {
            private void foo() {
                System.out.println("Super");
            }
        }
        
        class Subclass extends Super {
            public void foo() {
                System.out.println("Subclass");
            }
        }
    ```
    A. Compile time error at line 6<br>
    B. Compile time error at line 8<br>
    C. Compile time error at both line 6 and 8<br>
    D. Works fine and prints “Subclass” two times.
25. What will be the output of below program? 
    ```java
        import java.io.IOException;
        public class Test {
            public static void main(String[] args) {
                try {
                    throw new IOException("Hello");
                } catch (IOException | Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    ```
    A. Compile-time error 
    B. Prints “Hello” 
    C. Runtime Error
26. Which of the below are unchecked exceptions in java?
    A. RuntimeException
    B. ClassCastException
    C. NullPointerException
    D. IOException
27. What will be the output of below program?
    ```java
    import java.io.IOException;
    
    public class Test {
        public static void main(String[] args) {
            try {
                throw new Exception("Hello ");
            } catch (Exception e) {
                System.out.print(e.getMessage());
            } catch (IOException e) {
                System.out.print(e.getMessage());
            } finally {
                System.out.println("World");
            }
        }
    }
    ```
    A. Compile-time error<br>
    B. Hello<br>
    C. Hello World<br>
    D. Hello Hello World<br>
28. Which of the following statement(s) are true for java?<br>
    A. JVM is responsible for converting Byte code to the machine code.<br>
    B. We only need JRE to run java programs.<br>
    C. JDK is required to compile java programs.<br>
    D. JRE does not contain JVM
29. Can we have two main methods in a java class?
    A. Yes
    B. No


21. What is a Serializable interface?
22. What is a Transient variable?
23. Why do we go for jpa and ejb? Can we use any other framework?
24. How to find number of active user sessions?
25. How to lock a class? What are the ways to achieve synchronization?
26. What are inner classes and what are the types?
27. Where the configuration files are stored in your application?
28. How do you map entity and table?
29. Explain sample architecture for retrieving employee details from table.
30. What is WSDL? What is the advantage of webservices?

### Spring

1. What is Spring?
2. What is a Bean?
3. What is Dependency Injection?
4. What is Inversion of Control?
5. `@Component` vs `@Bean`?
6. How to maintain multiple profiles in a Spring Application?
7. What is a microservice? What is the advantage over monolithic architecture?
8. What is RESTful?
9. What are Client Certificates?
10. Explain the use of PACT in microservices architecture?
11. What is OAuth?
12. What is difference between @Controller and @RestController?
13. What is Eager vs Lazy loading in Hibernate?
 

### SQL
1. Why indexing in SQL is useful?
   A SQL index is a quick lookup table that helps to find records that are frequently searched by a user. An index is fast, small, and optimized for quick look-ups. It is useful for establishing a connection between the relational tables, searching large tables, and fast retrieval of data from a database.


### Interview Experiences

- Infosys Power Programmer - 9 September, 2023