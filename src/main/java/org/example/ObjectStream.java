package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ObjectStream {

    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee(1, "Kali", "IT", 120000),
                new Employee(1, "Kali", "ITs", 120000),
                new Employee(2, "Kumar", "IT", 23000),
                new Employee(3, "Suresh", "Maths", 40000),
                new Employee(4, "Rajesh", "Eng", 300000),
        new Employee(5, "King", "Eng", 400000)
        );

        List<Employee> filteredEmps = employeeList.stream()
                .filter(x -> x.salary > 50000).toList();

        System.out.println("filteredEmps: "+ filteredEmps.toString());

        List<String> empNames = employeeList.stream()
                .map(x -> x.name).toList();
        System.out.println("empNames: " + empNames);

        Optional<Employee> highestSalary = employeeList.stream()
                .sorted((x,y) -> Double.compare(y.getSalary(), x.getSalary())).findFirst();
        System.out.println("highestSalary: " + highestSalary);

        Optional<Employee> lowestSalary = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)).findFirst();
        System.out.println("lowestSalary: " + lowestSalary);

        List<Employee> sortAscEmp = employeeList.stream()
                .sorted((x,y) -> Double.compare(x.getSalary(), y.getSalary())).toList();
        System.out.println("sortAscEmp: " + sortAscEmp);

        List<Employee> sortDescEmp = employeeList.stream()
                .sorted((x,y) -> Double.compare(y.getSalary(), x.getSalary())).toList();
        System.out.println("sortDescEmp: " + sortDescEmp);

        List<String> filteredNames = employeeList.stream()
                .filter(x -> Objects.equals(x.getName(), "Kali"))
                .map(Employee::getName).toList();
        System.out.println("filteredNames: " + filteredNames);

        long empCount = employeeList.stream()
                .filter(x -> Objects.equals(x.getDepartment(), "IT"))
                .count();
        System.out.println("empCount: " + empCount);

        double averageSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("Average salary: " + averageSalary);

        List<Employee> uniqueVal = employeeList.stream().distinct().toList();
        System.out.println("uniqueVal: " + uniqueVal);

        List<String> uniqueDeps = employeeList.stream()
                .map(Employee::getDepartment).distinct().toList();

        System.out.println("uniqueDeps: "+uniqueDeps);

        Map<String, List<Employee>> groupByDep = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));

        System.out.println("groupByDep: "+ groupByDep);

        Map<String, Long> countByDep = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println("countByDep: "+ countByDep);

        Map<String, Optional<Employee>> highestPaidByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy((a,b) -> Double.compare(a.getSalary(), b.getSalary()))));

        System.out.println("highestPaidByDepartment: "+ highestPaidByDepartment);

        Map<String, Optional<Employee>> lowestPaidByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy((a,b) -> Double.compare(a.getSalary(), b.getSalary()))));

        System.out.println("lowestPaidByDepartment: "+ lowestPaidByDepartment);

        Map<String, Double> avgPerDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("avgPerDepartment: "+ avgPerDepartment);

        Map<Boolean, List<Employee>> partioningBySalary = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 100000));

        System.out.println("partioningBySalary: "+ partioningBySalary);
    }
}
