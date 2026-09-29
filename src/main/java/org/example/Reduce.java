package org.example;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        int result = nums.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("result: "+ result);

        int result2 = nums.stream()
                .reduce(0, Integer::sum);

        System.out.println("result2: "+ result2);

        int max = nums.stream()
                .reduce(0, (a,b) -> {
                    if(a>b){
                        return  a;
                    } else {
                        return b;
                    }
                });

        System.out.println("max: "+ max);

        int max2 = nums.stream()
                .reduce(0, Integer::max);

        System.out.println("max2: "+ max2);

        List<Employee> employees = List.of(
                new Employee(1, "Kali", "IT", 70000),
                new Employee(2, "John", "HR", 45000),
                new Employee(3, "Alex", "IT", 80000),
                new Employee(4, "David", "HR", 60000),
                new Employee(5, "Sam", "IT", 50000)
        );

        Optional<Employee> filteredEmploe = employees.stream().
                filter(e -> Objects.equals(e.getDepartment(), "IT")).
                max((a, b) -> Double.compare(a.getSalary(), b.getSalary()));

        System.out.println("filteredEmploe: " + filteredEmploe);

    }
}
