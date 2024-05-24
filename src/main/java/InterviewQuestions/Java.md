1. Rate yourself in java out of 10.
    - 7
2. Find length of string without using length()?
   1. ```java
        public static int findLength(String s){
          int length=0;
          for (char c1 : s.toCharArray())
              length++;
          return length;
        }
      ```
   2. ```java
      public static int findLengthWithException(String str) {
          int i=0;
          try{
              for(i=0;;i++){
                   str.charAt(i);
              }
          }
          catch(Exception e){}
          return i;
      }
      ```
3. Which is preferred ArrayList or LinkedList? Why?
   - Comparing ArrayList vs LinkedList is very similar to comparing an array with a Linked List.
   - Position-based access has constant time O(1) for ArrayList but Linear time O(N) for LinkedList.
   - When frequent insertions and deletions occur inside a list, Linked List takes constant time O(1) due to pointer implementation, but it can take linear time O(N) for ArrayList as we might need to shift items for this task.
   - Use ArrayList when you require faster access to the elements.
   - Use LinkedList when you require faster addition and removal of items.
   - In general, ArrayList is preferred for general use-cases.

4. What is Marshalling and Unmarshalling in java?
   - Marshalling is the process of converting Java objects into a format that is transferable over the wire(for example, XML or JSON).
   - Unmarshalling is the reversal of this process where data read from a wire format is converted into Java objects.

5. What is a Marker Interface?
   - An interface that does not have any methods, fields, or constants, i.e, an empty interface in java is known as Marker or Tag Interface.
   - It is used to deliver type information at runtime to the JVM so that it can take some action based on the information received.
   - One of the main purposes behind the ideology of marker interfaces is that they are used to convey a message to the JVM that the class implementing this type of interface has some extra functionalities.
   - Popular examples of marker interface in java include `Cloneable`, `Serializable`, `Remote` Interface.

6. Why to use char[] array over a string for storing passwords in Java?
   - Strings are immutable in Java and therefore if a password is stored as plain text it will be available in memory until Garbage collector clears it and as Strings are used in the String pool for re-usability there are high chances that it will remain in memory for long duration, which is a security threat. 
   - Strings are immutable and there is no way that the content of Strings can be changed because any change will produce new String.
   - Within an array, the data can be wiped explicitly after its work is completed. The array can be overwritten and the password won’t be present anywhere in the system, even before garbage collection.

7. What are the conditions when the finally-block is not executed?
   - A JVM crash or system error
   - An infinite loop
   - A Thread that is killed
   - A call to `System.exit()`

8. What is a Deadlock when working with Threads?
   - A deadlock is a situation where a set of processes are blocked because each process is holding a resource and waiting for another resource acquired by some other process.
   - It occurs in operating systems when there are two or more processes that hold some resources and wait for resources held by other(s).
   - For example, Process 1 is holding Resource 1 and waiting for Resource 2 which is acquired by Process 2, and Process 2 is waiting for Resource 1. 

9. What is Garbage Collector in Java? Can we run Garbage Collector anytime we want?
   - Garbage collection in Java is the automated process of deleting objects that are no longer needed or used.
     - You can’t force garbage collection on a specific object, but you can update objects so they are no longer accessible to the rest of the application. This lets the garbage collector know that those objects should be removed.
     - You can make objects inaccessible in the following ways:
       1. Create an object inside a method. After methods are executed, all objects called within those methods become unreachable, which makes them eligible for garbage collection.
       2. Nullify the reference variable. You can change a reference variable to NULL. As long as all references to an object are removed, that object will become unreachable, which lets the garbage collector know the object can be removed.
       3. Reassign the reference variable. Instead of nullifying the reference variable, you can also reassign the reference to another object. Once again, as long as all references to an object are removed, either through making reference variables NULL or reassigning them, the object will become inaccessible, leading to it being removed during the garbage collection process.
       4. Create an anonymous object. An anonymous object does not have a reference, so the garbage collector will mark and remove it during the next garbage collection cycle.

10. What is the `finalize()` method in Garbage Collection?
    - `finalize()` method in Java is a method of the Object class that is used to perform cleanup activity before destroying any object.
    - It is called by Garbage collector before destroying the objects from memory.
    - `finalize()` method is called by default for every object before its deletion.

11. What do you mean by the immutability of `String` in java?
    - An immutable object is an object whose internal state remains constant after it has been entirely created. This means that once the object has been assigned to a variable, we can neither update the reference nor mutate the internal state by any means.

12. What is the difference when a String is created as a literal vs creating String with `new` keyword?
    - When 2 Strings are created as: `String s1 = "Java"; String s2 = "Java";` This is stored in a String pool and as the content is same i.e., "Java" so the both of them will point to the same string in the string pool.
    - But, when 2 Strings are created as: `String s1 = new String("Java"); String s2 = new String("Java");` These are created as separate objects in the Heap memory in Java.

13. What will be the output of `System.out.println(1+2+3+"Hello, World!"+5+6);`?
    - Output will be `6Hello, World!56`
      - Because, after a String is introduced the following will be treated as String.

14. `StringBuffer` vs `StringBuilder` which is more efficient?
    - `StringBuffer` is _synchronized_ i.e. thread safe. It means two threads can't call the methods of `StringBuffer` simultaneously. Whereas, `StringBuilder` is _non-synchronized_ i.e. not thread safe. It means two threads can call the methods of `StringBuilder` simultaneously.
    - Therefore, `StringBuffer` is __less efficient__ than `StringBuilder`.

15. What are Exceptions in Java? Types? Checked and Unchecked Exceptions.
    - An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions.
    - Java exceptions fall into two main categories: checked exceptions and unchecked exceptions.
      - Checked Exceptions:
        - Java verifies checked exceptions at compile-time.
        - In general, checked exceptions represent errors outside the control of the program. For example, `FileNotFoundException`.
        - Therefore, we should use the throws keyword to declare a checked exception:
        - ```java
          private static void checkedExceptionWithThrows() throws FileNotFoundException {
            File file = new File("not_existing_file.txt");
            FileInputStream stream = new FileInputStream(file);
          }
          ```
        - We can also use a try-catch block to handle a checked exception:
          - ```java
            private static void checkedExceptionWithTryCatch() {
                File file = new File("not_existing_file.txt");
                try {
                    FileInputStream stream = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            ```
        - Some common checked exceptions in Java are `IOException`, `SQLException` and `ParseException`.
      - Unchecked Exceptions
        - If a program throws an unchecked exception, it reflects some error inside the program logic.
        - Java does not verify unchecked exceptions at compile-time.
        - The `RuntimeException` class is the superclass of all unchecked exceptions, so we can create a custom unchecked exception by extending RuntimeException:
          - ```java
            public class NullOrEmptyException extends RuntimeException {
                public NullOrEmptyException(String errorMessage) {
                    super(errorMessage);
                }
            }
            ```
        - Some common unchecked exceptions in Java are `NullPointerException`, `ArrayIndexOutOfBoundsException` and `IllegalArgumentException`.
        - For understanding in simple terms:-
          - Checked exception - "Checked" -> already checked by java, no need to run the program -> therefore, this is checked at compile time.
            - BUT, Checked Exceptions Can Occur During Runtime: Compile-time checks ensure your code handles potential exceptions, but they don't guarantee the exception won't occur during program execution. External factors like network issues, file system errors, or unexpected database responses can throw checked exceptions even if your code compiles cleanly.
          - Unchecked exception - "Unchecked" -> not checked by java, need to run the program -> therefore, this is checked at runtime.

16. `Comparator` vs `Comparable` in java?
    - `Comparator` and `Comparable` is mostly used for sorting.
    - `Comparable` is used for single-sorting using the `compareTo()` method. Single-sorting means we can sort using only 1 parameter e.g., only (roll) or (name).
    - `Comparator` is used for multiple-sorting using the `compare()` method. Multiple-sorting means we can sort using multiple parameters e.g., (roll and name).
    - Also, we use `Comparator` when we want to pass our own comparing logic. This can't be done in `Comparable`.

17. What is a singleton pattern and explain its real time usage?
    - Singleton pattern is used when we need to have only 1 instance of a particular class. For example, Database Connection class.
    - We can make a class singleton by:
      1. Make a constructor private.
      2. Write a static method that has the return type object of this singleton class.
    - For example,
      - ```java
        class Singleton {
            private static Singleton single_instance = null;
            
            public String s;
            
            private Singleton(){
                s = "Hello I am a string part of Singleton class";
            }
        
            public static synchronized Singleton getInstance(){
                if (single_instance == null)
                    single_instance = new Singleton();
                return single_instance;
            }
        }
        ```

18. Why is java not 100% Object-oriented language?
    - Java is not 100% Object-oriented because of primitive data types like int, float and so on.

19. `==` vs `equals()` method in java?
    - `==` checks for the equality of reference whereas `equals()` checks for equality of value.
    - `a == b` checks if `a` and `b` refer to the same reference whereas `a.equals()` checks if the value of `a` and `b` is same or not.

20. Can we override a static method? 
    - No, we cannot override static methods because method overriding is based on dynamic binding at runtime and the static methods are bonded using static binding at compile time.

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
    - Correct Answer: C
      - By default, any field of the interface is public, static, and final. So we can’t change it, hence compile-time error at the statement Foo.x = 20;.

22. What are the valid statements for static keyword in Java?<br>
    A. We can have static block in a class.<br>
    B. The static block in a class is executed every time an object of class is created.<br>
    C. We can have static method implementations in interface.<br>
    D. We can define static block inside a method.
    - Correct Answers: A, C 
    - We can have static block in a class, it gets executed only once when class loads.
    - From java 8 onwards, we can have static method implementations in interfaces.

23. Can we use object to call a static method?
    - Yes, you can use an object to call static methods in Java, but it is generally NOT recommended.
    - ```java
      public class UseObjectToCallStaticMethod {
          static void staticMethod(){
              System.out.println("static method");
          }
          public static void main(String agrs[]) {
              UseObjectToCallStaticMethod obj = new UseObjectToCallStaticMethod();
              UseObjectToCallStaticMethod.staticMethod(); // prints "static method"
              obj.staticMethod(); // prints "static method"
              obj.test();
          }
        
          void test(){
              this.staticMethod(); // prints "static method"
          }
      }
      ```

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
    - Correct Answer: B 
      - Compile time error at line 8 because Super class foo() method is private. The error message is The method foo() from the type Super is not visible.

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
    A. Compile-time error<br>
    B. Prints “Hello”<br>
    C. Runtime Error
    - Correct Answer: A 
      - Compile-time error as The exception IOException is already caught by the alternative Exception.

26. Which of the below are unchecked exceptions in java?<br>
A. RuntimeException<br>
B. ClassCastException<br>
C. NullPointerException<br>
D. IOException
    - Correct Answer: A, B, C
      - RuntimeException and its subclasses are unchecked exceptions.
      - Unchecked exceptions do not need to be declared in a method or constructor’s throws clause. 

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
    - Correct Answer: A
      - Compile-time error Unreachable catch block for IOException. It is already handled by the catch block for Exception.

28. Which of the following statement(s) are true for java?<br>
    A. JVM is responsible for converting Byte code to the machine code.<br>
    B. We only need JRE to run java programs.<br>
    C. JDK is required to compile java programs.<br>
    D. JRE does not contain JVM
    - Correct Answer: A, B, C
      - JDK is for development purpose whereas JRE is for running the java programs.
      - JDK and JRE both contains JVM so that we can run our java program.
      - JVM is the heart of java programming language and provides platform independence.
        - JRE is the implementation of JVM.
        - It provides a platform to execute java programs.
        - JRE consists of JVM, Java binaries, and other classes to execute any program successfully.
        - JRE does not contain any development tools such as Java compiler, debugger, JShell, etc.
        - If you just want to execute a java program, you can install only JRE(for example, when deploying the JAR on cloud servers).

29. Can we have two main methods in a java class?
  A. Yes
  B. No
      - Correct Answer: A
        - This was a tricky question.
        - We can have multiple methods having name as “main” in java through method overloading.
          - ```java
            public class OverloadStaticMethods {
                public static void main(String[] args) {
                    OverloadStaticMethods obj = new OverloadStaticMethods();
                    obj.main();
                    OverloadStaticMethods.foo();
                    OverloadStaticMethods.foo(10);
                }
            
                public static void main(){
                    System.out.println("main");
                }
            
                public static void foo() {
                    System.out.println("Test.foo() called ");
                }
            
                public static void foo(int a) {
                    System.out.println("Test.foo(int) called ");
                }
            }
            ```

30. Difference between `Map` and `HashMap` in Java.
    - `Map` is the interface whereas `HashMap` is the implementation.

31. What is Shallow copy and Deep copy in Java?
    - Shallow copy means that the copy is dependent on the original. If original change then copy also changes.
    - If only primitive type fields or Immutable objects are there then there is no difference between shallow and deep copy in Java.
      - Shallow copy - Creates a new object with the same field values as the original object, but for reference type fields (objects within objects), it only copies the references, not the actual objects themselves. Both the original and the copy point to the same underlying objects in memory.
    - Check the examples given here - [GFG - Deep, Shallow and Lazy Copy with Java Examples](https://www.geeksforgeeks.org/deep-shallow-lazy-copy-java-examples/)

32. What do you mean by - "Java is a robust language"?
    - Robust means strong and healthy. Robustness is the ability of a computer system to handle the errors during execution and handle the erroneous input.
    - Java is robust because it uses strong memory management. There is lack of pointers that avoids security problems. There is automatic garbage collection in Java which runs on the Java Virtual Machine to get rid of objects which are not being used by a Java application anymore. There is exception handling and type checking mechanism in Java. All these points make Java robust.

33. Difference between JVM, JRE and JDK?
    - JVM - Provides environment where Java bytecode is run
    - JRE - It is the implementation of JVM, so it provides certain libraries with which you can develop java application
    - JDK - It provides the environment where java application are created for example, debugger, interpreter and so on..

34. What is the use of Lambda Expression?
    - Java by default is an object-oriented language so if you want to do functional programming you need to use Lambda Expression
    - So we can write the implementation of the functional interfaces using lambda expressions
    - (NEED TO READ MORE ON THIS...)

35. How do you handle exceptions in Core Java?
    - Here, explain try-catch-finally
    - Usually we use finally block to release resources


35. Explain what is try-with-resources?
36. What are SOLID principles?
37. What is Stream in Java?
38. Difference between Sequential and Parallel Stream in Java 8?
    - Sequential Stream are executed on a single core/thread whereas in parallel it gets executed on multiple cores/threads
    - Because, of the above Sequential Stream is more predictable than Parallel Stream
39. Intermediate and terminal operations available in Stream?
    - Intermediate operations are lazy so if you call an intermediate operation like `filter()` on a stream, it won't be executed until you call a terminal operation like `collect()` on it.
    - Intermediate operations - `filter()`
    - Terminal operations - `collect()`