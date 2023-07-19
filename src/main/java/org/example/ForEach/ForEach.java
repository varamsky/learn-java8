package org.example.ForEach;

import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;

public class ForEach {

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("Anna", "Lewis", "Zack");

        // for loop is an external iterator
        System.out.println("Using for loop");
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }

        // for-in loop is an external iterator
        System.out.println("Using for-in loop");
        for (String word : wordList) {
            System.out.println(word);
        }

        /*
        forEach is an internal iterator

        Also, for-loop and for-in loop executes everything in a sequential manner because all the elements run in the same CPU core
        In the case of forEach the sequence is not fixed as some elements might run in one CPU core and other elements in other CPU cores
         */
        System.out.println("Using lambda for-each loop by passing in a Consumer");
        Consumer<String> printConsumer = new Consumer<String>() {
            public void accept(String name) {
                System.out.println(name);
            }
        };
        /*
        The Consumer interface is a functional interface (an interface with a single abstract method). It accepts an input and returns no result.
         */
        wordList.forEach(printConsumer); // forEach accepts a Consumer

        /*
        forEach belongs to the java.lang.Iterable interface
         */
        System.out.println("Using lambda for-each loop");
        wordList.forEach((word) -> System.out.println(word));

        System.out.println("Using method reference with lambda for-each loop");
        wordList.forEach(System.out::println);
    }
}
