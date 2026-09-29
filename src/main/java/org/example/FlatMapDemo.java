package org.example;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<List<Integer>> nums = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 3, 2,2),
                List.of(6, 7, 8)
        );

        List<Integer> flatList = nums.stream().flatMap(Collection::stream).toList();
        System.out.println("flatList: " + flatList);

        Set<Integer> unique = nums.stream().flatMap(Collection::stream).collect(Collectors.toSet());
        System.out.println("unique: " + unique);

        int sum = nums.stream().flatMap(Collection::stream).mapToInt(e -> e).sum();
        System.out.println("sum: " + sum);
    }
}
