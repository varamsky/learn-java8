package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Integer result = list.stream().max((i, j) -> i.compareTo(j)).get();

        System.out.println(result);
    }
}
