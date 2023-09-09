package org.example.BeforeJava8.MutableAndImmutableTypes;

public class MutableAndImmutableTypes {
    private static Integer num = 5;
    private static String string = "String";

    public static void main(String[] args) {
        System.out.println(num.hashCode());
        num = 10;
        System.out.println(num.hashCode());

        System.out.println(string.hashCode());
        System.out.println("String".equals(string));
        string = "Mutable String";
        System.out.println(string.hashCode());

    }
}
