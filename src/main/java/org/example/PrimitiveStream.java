package org.example;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class PrimitiveStream {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        int sumInt = Arrays.stream(arr).sum();
        System.out.println("sumInt: " + sumInt);

        OptionalDouble avgInt = Arrays.stream(arr).average();
        System.out.println("avgInt: " + avgInt);

        OptionalInt maxInt = Arrays.stream(arr).max();
        System.out.println("maxInt: " + maxInt);

        Stream<Integer> streamedInt = Arrays.stream(arr).boxed();
        System.out.println("streamedInt: " + streamedInt.toList());

    }
}
