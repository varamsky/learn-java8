package org.example.BeforeJava8.Generics;

/**
 * This is used to demonstrate what problems developers used to get into before Generics
 */
public class IntegerPrinter {
    int thingToPrint;

    public IntegerPrinter(int thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
