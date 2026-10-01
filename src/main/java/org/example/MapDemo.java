package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> users = new HashMap<>();

        users.put(1, "Kali");
        users.put(2, "Kumar");
        users.put(3, "King");
        users.put(4, "Suresh");
        users.put(5, "Ram");

        System.out.println("users: " + users);

        for (Map.Entry<Integer, String> entry : users.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        for (int key : users.keySet()){
            System.out.println("key: " + key);
        }

        for (String value : users.values()){
            System.out.println("value: " + value);
        }

        System.out.println("Find the value of key: " + users.get(5));

        System.out.println("Is Key Exist: " + users.containsKey(106));

        System.out.println("Is Value Exist: " + users.containsValue("Kali"));

        System.out.println("Total Entries: " + users.size());

        Optional<Map.Entry<Integer, String>> maxVal = users.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        System.out.println("maxVal: " + maxVal);

        Optional<Map.Entry<Integer, String>> minVal = users.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue));
        System.out.println("minVal: " + minVal);

        Map.Entry<Integer, String> maxKey = users.entrySet().stream()
                .max(Map.Entry.comparingByValue()).orElseThrow();;
        System.out.println("maxKey: " + maxKey.getKey());

        Map.Entry<Integer, String> minKey = users.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue)).orElseThrow();
        System.out.println("minKey: " + minKey.getKey());

        users.forEach((key, value) ->{
            System.out.println(key + ": " + value);
        });

        List<Integer> nums = List.of(1, 2, 2, 3, 1, 4, 2);
        Map<Integer, Integer> numsMapList = new HashMap<>();

        for (Integer num : nums){
            numsMapList.put(num, numsMapList.getOrDefault(num, 0) + 1);
        }


        System.out.println("numsMapList: " + numsMapList);
        System.out.println("Map hashcode: "+ numsMapList.hashCode() );

        users.remove(5);
        System.out.println("users: " + users);
    }
}
