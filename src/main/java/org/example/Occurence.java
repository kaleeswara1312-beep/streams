package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Occurence {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 2, 3, 3, 3, 4);
        Map<Integer, Long> numOccurs = nums.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("numOccurs: " + numOccurs);

        List<String> names = List.of("Java", "Spring", "Java", "SQL", "Spring", "Java");

        Map<String, Long> strOccurs = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("strOccurs: " + strOccurs);

        List<Integer> nums2 = List.of(1, 2, 3, 2, 4, 3, 5);

        List<Integer> duplicates = nums2.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).toList();
        System.out.println("duplicates: " + duplicates);


        List<Integer> nums3 = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> nonDuplicates = nums3.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).toList();
        System.out.println("nonDuplicates: " + nonDuplicates);

        String str = "swissww";

        Optional<String> nonRepeatedFirstStr = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey()).findFirst();

        System.out.println("nonRepeatedFirstStr: " +  nonRepeatedFirstStr);

        Optional<String> repeatedFirstStr = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey()).findFirst();

        System.out.println("repeatedFirstStr: " +  repeatedFirstStr);

        List<Integer> nums4 = List.of(1, 2, 2, 3, 3, 3, 4);

        Optional<Integer> leastRepeatedInt = nums4.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

        System.out.println("leastRepeatedInt: " +  leastRepeatedInt);

        String str2 = "programmming";
        Optional<String> highestOccurence = Arrays.stream(str2.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

        System.out.println("highestOccurence: " + highestOccurence);

        String str3 = "programming";
        List<String> moreThanOnce = Arrays.stream(str3.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).toList();

        System.out.println("moreThanOnce: " + moreThanOnce);

        String str4 = "banana";

        Map<String, Long> frequency = Arrays.stream(str4.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));

        System.out.println("frequency: " + frequency);

        List<Integer> nums5 = List.of(1, 2, 2, 3, 3, 3, 4, 4);

        Optional<Integer> secondFrequent = nums5.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("secondFrequent: " + secondFrequent);

        List<Integer> nums6 = List.of(1, 2, 2, 3, 3, 3, 4, 4);
        List<Integer> exactlyTwoOccurs = nums6.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("exactlyTwoOccurs: " + exactlyTwoOccurs);

        String str6 = "programming";
        List<String> duplicateCharater = Arrays.stream(str6.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey).toList();
        System.out.println("duplicateCharater: " + duplicateCharater);

        List<Integer> nums7 = List.of(4, 2, 4, 1, 2, 3, 1);

        List<Integer> removeDuplicatePreserverOrder = nums7.stream()
                .distinct()
                .toList();

        System.out.println("removeDuplicatePreserverOrder: " + removeDuplicatePreserverOrder);

        String str7 = "programming";
        Optional<String> firstOccurExactlyTwo = Arrays.stream(str7.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 2)
                .map(Map.Entry::getKey).toList().stream().findFirst();

        System.out.println("firstOccurExactlyTwo: " + firstOccurExactlyTwo);


    }


}
