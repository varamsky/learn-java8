package org.example.BeforeJava8.Generics;

/**
 * This is a Bounded Generic Printer class
 */
public class AnimalPrinter<T extends Animal> {
    // This is an example of Bounded Generic as this is constrained to have the type of Animal
    // Also, we can make T implement an interface(but we need to use the extends keyword for interfaces as well, little weird and confusing)
    // And, we need ot place the class first, separated by an '&' from all the interfaces
    T thingToPrint;

    public AnimalPrinter(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        thingToPrint.eat(); // because of Bounded Generic we also get access to the public properties of Animal class
        System.out.println(thingToPrint);
    }
}
