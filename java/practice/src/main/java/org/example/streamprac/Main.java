package org.example.streamprac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> even = numbers.stream().filter(a -> a %2==0).collect(Collectors.toList());
        System.out.println(even);

        List<Integer> mult = numbers.stream().map(a -> a*2).collect(Collectors.toList());
        System.out.println(mult);

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        long condition = numbers.stream().filter(a->a>5).count();
        System.out.println(condition);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "fineapple", "apple");

        List<String> longWords = words.stream().filter(w -> w.length() >= 5).collect(Collectors.toList());
        System.out.println(longWords);

        List<String> upperWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperWords);






    }
}
