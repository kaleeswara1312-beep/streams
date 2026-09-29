package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class StreamNumberDemo {
    public static void main(String[] args) {
        List<Integer> nums = List.of(23,1,20, 3, 4, 5,6,21,23,23,67,34,76);

        List<Integer> greaterNums = nums.stream()
                .filter(x -> x > 20)
                .toList();

        System.out.println("Greater than 20: " + greaterNums);

        int sums = nums.stream().reduce(0, Integer::sum);
        System.out.println("Sums: " + sums);

        Optional<Integer> maxVal = nums.stream().max(Integer::compareTo);
        System.out.println("Max: " + maxVal);

        Optional<Integer> minVal = nums.stream().min(Integer::compareTo);
        System.out.println("Min: " + minVal);

        long count = nums.stream().filter(x -> x > 15).count();
        System.out.println("Count: "+ count);

        List<String> names = List.of("Kali", "John", "Alex");
        List<String> uppercaseStr = names.stream().map(String::toUpperCase).toList();
        System.out.println("String Uppercase: " + uppercaseStr);

        List<Integer> sortedArr = nums.stream().sorted().toList();
        System.out.println("Sorted arr: " + sortedArr);

        List<Integer> revSortedArr = nums.stream()
                .sorted((a,b) -> b.compareTo(a)).toList();
        System.out.println("Reverse Sorted arr: " + revSortedArr);


        List<Integer> nums2 = List.of(10,20, 10, -1, 30, 20, 40, 50, 103);
        List<Integer> removeDuplicates = nums2.stream().distinct().toList();
        System.out.println("removeduplicates: "+ removeDuplicates);

        int secondLargest = nums2.stream().sorted(Comparator.reverseOrder()).distinct()
                .skip(1).findFirst().orElseThrow();
        System.out.println("secondLargest: "+ secondLargest);

        int secondSmallest = nums2.stream().sorted().distinct()
                .skip(1).findFirst().orElseThrow();
        System.out.println("secondSmallest: "+ secondSmallest);

        int findFirstVal = nums2.stream().filter(x -> x > 25).findFirst().orElse(0);
        System.out.println("findFirstVal: " + findFirstVal);

        boolean isAllPositiveVals = nums2.stream().allMatch(x -> x > 0);
        System.out.println("isAllPositiveVals: " + isAllPositiveVals);

        boolean isAnyGreaterVals = nums2.stream().anyMatch(x -> x > 100);
        System.out.println("isAnyGreaterVals: " + isAnyGreaterVals);

        boolean isNoneNegativeVals = nums2.stream().noneMatch(x -> x < 0);
        System.out.println("isNoneNegativeVals: " + isNoneNegativeVals);
    }
}
