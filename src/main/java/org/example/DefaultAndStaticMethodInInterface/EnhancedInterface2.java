package org.example.DefaultAndStaticMethodInInterface;

public interface EnhancedInterface2 {

    void simpleMethod2();

    default void commonDefaultMethod(String str) {
        System.out.println("Calling commonDefaultMethod in EnhancedInterface2 with parameter: " + str);
    }

}
