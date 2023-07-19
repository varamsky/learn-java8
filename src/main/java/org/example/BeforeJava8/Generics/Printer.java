package org.example.BeforeJava8.Generics;

/**
 * This is a Generic Printer class
 */
public class Printer<T> { // we can use whatever type in between the <> but T is used conventionally
    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
