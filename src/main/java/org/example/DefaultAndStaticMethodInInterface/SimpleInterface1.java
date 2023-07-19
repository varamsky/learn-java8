package org.example.DefaultAndStaticMethodInInterface;

public interface SimpleInterface1 {
    int number = 10;
    final String name = "Shubham"; // variables in interfaces are final by default

    void commonMethodInBothSimpleInterfaces();
}

