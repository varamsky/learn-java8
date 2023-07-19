package org.example.BeforeJava8.Generics;

/**
 * This is used to demonstrate what problems developers used to get into before Generics
 */
public class DoublePrinter {
    double thingToPrint;

    public DoublePrinter(double thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
