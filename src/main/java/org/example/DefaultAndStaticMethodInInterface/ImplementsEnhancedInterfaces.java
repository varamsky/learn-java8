package org.example.DefaultAndStaticMethodInInterface;

public class ImplementsEnhancedInterfaces implements EnhancedInterface1, EnhancedInterface2 {

    @Override
    public void simpleMethod2() {
        System.out.println("Calling simpleMethod2()");
    }

    @Override
    public void simpleMethod1(String str) {
    }

    /**
     * This class won't compile without having its own implementation of the commonDefaultMethod()
     * because this class implements 2 interfaces and both have their common default method implementations
     */
    @Override
    public void commonDefaultMethod(String str) {
        System.out.println("Calling commonDefaultMethod with the new implementation with parameter: " + str);
        EnhancedInterface1.staticMethod1();
    }

    public static void main(String[] args) {
        ImplementsEnhancedInterfaces implementsEnhancedInterfaces = new ImplementsEnhancedInterfaces();
        implementsEnhancedInterfaces.simpleMethod2();
        implementsEnhancedInterfaces.commonDefaultMethod("string");
    }

}
