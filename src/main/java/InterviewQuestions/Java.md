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
   - Marshalling is the process of converting Java objects into a format that is transferable over the wire(for example, XML).
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
