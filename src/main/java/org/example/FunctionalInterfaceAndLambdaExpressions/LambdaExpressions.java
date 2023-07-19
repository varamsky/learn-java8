package org.example.FunctionalInterfaceAndLambdaExpressions;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExpressions {
    /*
    Java lambda functions can be only used with functional interfaces.

    Here, we learn not only about lambda expressions and FunctionalInterface
    but also about the predefined interfaces in the java.util.function package

    NOTE:
    I still have not understood these concepts
    - Use "Effectively Final" variables" : https://www.baeldung.com/java-8-lambda-expressions-tips#variables
    - Protect Object Variables from Mutation : https://www.baeldung.com/java-8-lambda-expressions-tips#mutation
     */


    public static void main(String[] args) {
        ImplementInterfaceForLambdaExpressions implementInterfaceForLambdaExpressions = new ImplementInterfaceForLambdaExpressions();

        implementInterfaceForLambdaExpressions.print();
        printThing(implementInterfaceForLambdaExpressions);
        /*
        Now, to do this simple thing of calling the method definition in the interface
        - a class has to implement that interface
        - the class has to provide an implementation of the defined method
        - and only then we can call that method and use that abstract method defined in the above created interface

        Here, is where lambdas come in
        - with lambdas we don't need another class
        - we can directly provide an implementation of the method defined in the interface
         */

        // here we directly pass the implementation of the method to the printThing() method
        printThing(() -> {
            System.out.println("Lambda Expression passed to the printThing() in Lambda expression class");
        });

        // we can also assign the lambda expression to a variable i.e., functions can be assigned as an object
        InterfaceForLambdaExpressions lambdaExpressionObject = () ->
                System.out.println("Lambda Expression object passed to the printThing() in Lambda expression class");
        printThing(lambdaExpressionObject);

        // here we use a lambda expression where the interface is a Functional Interface
        // NOTICE that the data type of p,s is specified as String but, it can also be automatically inferred by the compiler
        // therefore, it is not compulsory to add the data type and general convention is to avoid specifying them explicitly
        // that is why in the remaining lambda expressions with parameters I have skipped the data type
        FunctionalInterfaceForLambdaExpressions functionalLambdaExpressionObject = (String p, String s) ->
                System.out.println(p + " Functional Lambda Expression object passed to the printThing() in Lambda expression class " + s);
        printThingWithSuffixAndPrefix(functionalLambdaExpressionObject);



        /*
        This and the one below are 2 other ways of using the abstract method in the interface

        It is not encouraged to use these techniques though
         */
        new FunctionalInterfaceForLambdaExpressions() {
            // this is an anonymous inner class
            @Override
            public void printWithSuffixAndPrefix(String suffix, String prefix) {
                System.out.println(prefix + " : testing : " + suffix);
            }
        }.printWithSuffixAndPrefix("aa", "bb");

        ((FunctionalInterfaceForLambdaExpressions) (suffix, prefix) -> System.out.println(prefix + " : testing : " + suffix)).printWithSuffixAndPrefix("aa", "bb");

        // Here, we supply a lambda expression implementation of the apply method of the java.util.Function interface
        System.out.println("Function.apply : " + functionReturn((a) -> a));

        // Here, we supply a lambda expression implementation of the test method of the java.util.Predicate interface to check if supplied number is 1 or not
        System.out.println("Predicate.test : " + predicateTest((num) -> num == 1));


        /*
        Lambda Expressions and scope

        https://www.baeldung.com/java-8-lambda-expressions-tips#inner
        Don't treat Lambda Expressions as inner classes

        When we use an inner class, it creates a new scope.
        We can hide local variables from the enclosing scope by instantiating new local variables with the same names.
        We can also use the keyword this inside our inner class as a reference to its instance.

        Lambda expressions, however, work with enclosing scope.
        We can’t hide variables from the enclosing scope inside the lambda’s body.
        In this case, the keyword this is a reference to an enclosing instance, i.e., the scope outside the lambda expression.
         */
    }

    static void printThing(InterfaceForLambdaExpressions thing) {
        thing.print();
    }

    static void printThingWithSuffixAndPrefix(FunctionalInterfaceForLambdaExpressions thing) {
        thing.printWithSuffixAndPrefix("prefix", "suffix");
    }

    static String functionReturn(Function<String, String> stringFunction) {
        return stringFunction.apply("testing string");
    }

    static boolean predicateTest(Predicate<Integer> predicate) {
        return predicate.test(1);
    }
}