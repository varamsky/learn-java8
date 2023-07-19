package org.example.FunctionalInterfaceAndLambdaExpressions;

public interface InterfaceForLambdaExpressions {
    void print();

    /*
    This will give an error as the 2 abstract methods print() and anotherAbstractMethod() will confuse the compiler
    when we try to use the lambdaExpression in LambdaExpressions.java

    An interface which is intended to be used for lambdaExpressions can have
    multiple default and static methods but, only 1 abstract method

    To enforce this, the best practice is to use the @FunctionalInterface annotation
    See FunctionalInterfaces for more info
     */
//    void anotherAbstractMethod();
}
