package org.example.DefaultAndStaticMethodInInterface;

public interface EnhancedInterface1 {

    void simpleMethod1(String str);

    /**
     * As the name suggests, this is the default version of this default method, it can be overridden by an implementing class.
     */
    default void commonDefaultMethod(String str) {
        System.out.println("Calling commonDefaultMethod in EnhancedInterface1 with parameter: " + str);
    }

    /**
     * The static method is available only through and inside of this interface. It can't be overridden by an implementing class.
     */
    static void staticMethod1() {
        System.out.println("Calling static method in EnhancedInterface1");
    }
}