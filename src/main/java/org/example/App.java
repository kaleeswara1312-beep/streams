package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App 
{
    public static void main( String[] args )
    {

        List<Integer> numbers = List.of(34,23,523,65,23,753);

        List<String> updatedData = numbers.stream().map(x -> {
            if(x%2 == 0){
                return "Even";
            }

            return "Odd";
        }).toList();

        System.out.println(updatedData);

        List<String> str = List.of("Kali", "Kumar", "Suresh");

        List<String> filterStr = str.stream().filter(x -> x.endsWith("y"))
                .toList();

        System.out.println("String filter"  + filterStr);

        List<Integer> sortedStr = List.of(34,1,53,534,0,42,3,1,6,3).stream().sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(sortedStr);


        List<Integer> data = List.of(34,23,56,34,6,23,65,3);

        List<Integer> filteredData = data.stream().sorted(Comparator.reverseOrder())
                .skip(2).limit(1).toList();

        long sortedData = data.stream().filter(x -> x <30)
                        .count();

        System.out.println("Distinct: " + Arrays.toString(data.stream().distinct().toArray()));
        System.out.println("Distinct: " + data.stream().distinct().toList());

        System.out.println("Sorting data " + sortedData);
        System.out.println("Skipping data " + filteredData);

        Integer[] result = Stream.of(10, 20, 30, 40)
                .filter(x -> x > 20)
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(result));

        int[] intVal = {23,23,1,23,5,3,2,1};

        int[] filtereddata = Arrays.stream(intVal).filter(x -> x < 5).toArray();

        System.out.println(Arrays.toString(filtereddata));


        // Collectors methods
        List<Integer> numberss = List.of(10, 20, 30, 20, 40);

        List<String> names = List.of("Kali", "Raj", "John", "Kali");


        List<Integer> nums = numberss.stream().collect(Collectors.toList());
        System.out.println(nums);

        Set<Integer> nums2 = numberss.stream().collect(Collectors.toSet());
        System.out.println("Duplicate removed " + nums2);

        String res = names.stream().collect(Collectors.joining(", " , "[" , "]"));
        System.out.println("Join : "+ res);

        Long res1 = numberss.stream().collect(Collectors.counting());
        System.out.println("Counting : "+ res1);

        int[] dataArr = {1, 2, 2, 3, 3, 3, 4, 4};

        Map<Integer, Long> maps = Arrays.stream(dataArr).boxed()
                .collect(Collectors.groupingBy(
                    x -> x,
                        Collectors.counting()
                ));

        System.out.println(maps);

//        Stream can be used only once
//        Stream<Integer> stream = nums.stream();
//
//        stream.filter(x -> x > 2).toList();
//
//        stream.filter(x -> x < 5).toList(); // Error

        List<Integer> listData = List.of(2,3,2,5,232,534);

    }
}
