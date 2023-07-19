package org.example.BeforeJava8.Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * The Generics Framework was introduced in Java 5
 */
public class Generics {

    public static void main(String[] args) {
        IntegerPrinter intPrinter = new IntegerPrinter(51);
        intPrinter.print();
        DoublePrinter doublePrinter = new DoublePrinter(51.32);
        doublePrinter.print();
        StringPrinter stringPrinter = new StringPrinter("word");
        stringPrinter.print();
        /*
        As you can see, here we needed 3 different classes with almost the same code and functionality
        This leads to a lot of code duplication

        If we try to extend it to other data types like float, character it will be a lot of duplicate code doing similar thing.

        Not to mention that the code in these classes are pretty simple. In real world applications, code will be much more complex.

        That is why we create the Generic Printer class
         */

        Printer<Integer> genericIntegerPrinter = new Printer<>(221); // generics don't work with primitives, so we used the Wrapper class Integer
        genericIntegerPrinter.print();
        Printer<Double> genericDoublePrinter = new Printer<>(221.23);
        genericDoublePrinter.print();
        Printer<String> genericStringPrinter = new Printer<>("generic word");
        genericStringPrinter.print();


        /*
        Now, the question might arise as to why do we need Generics in the first place
        We could have used the Object class to denote everything instead of a Generic

        Something like the code below,
         */
        ArrayList<Object> listOfCats = new ArrayList<>();
        listOfCats.add(new Cat()); // this prints out "Cat"

        Cat cat = (Cat) listOfCats.get(0);

        /*
        Well, that would work but would not be type safe
        Have a look at the below commented code

        It won't show any syntax error but will show a ClassCastException at the line

        Cat myCat = (Cat)cats.get(0);

        because we added a Dog() to the cats list earlier and then are trying to cast it as a Cat
         */

        /*
        ArrayList<Object> cats= new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Dog());

        Cat myCat = (Cat)cats.get(0);
         */

        AnimalPrinter<Cat> catAnimalPrinter = new AnimalPrinter<>(new Cat()); // this prints "Cat"
        catAnimalPrinter.print(); // this runs eat() method of class Animal and prints the Cat object

        AnimalPrinter<Dog> dogAnimalPrinter = new AnimalPrinter<>(new Dog()); // this prints "Dog"
        dogAnimalPrinter.print(); // this runs eat() method of class Animal and prints the Dog object


        /*
        calling a generic method
         */
        shout("Hello");
        shout(23.2);
        shout(5);


        /*
        calling a generic method with 2 generic parameters
         */
        shout2("Hello", 23, "word1");
        shout2(23.21, "Robert", "word2");
        System.out.println("return from shout2: " + shout2("Hello", "Anna", "word3"));

        List<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        printList(integerList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat()); // this prints "Cat"
        printList(catList);
    }

    /**
     * This is a Generic method
     */
    private static <T> void shout(T thingToShout) {
        System.out.println(thingToShout + "!!!");
    }

    /**
     * This is a Generic method with 2 generic parameters
     */
    private static <T, V> V shout2(T thingToShout, V otherThingToShout, String normalParameter) { // we can also return as a Generic
        System.out.println(thingToShout + "!!!" + otherThingToShout + " : " + normalParameter);

        return otherThingToShout;
    }

    private static void printList(List<?> myList) {// we can also use Bounded Generics for example, to allow only a List of Animals (<? extends Animal>)
        System.out.println(myList);
    }
}
