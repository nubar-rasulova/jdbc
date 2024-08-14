package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Sample list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 60000),
                new Employee("Bob", "HR", 45000),
                new Employee("Charlie", "IT", 55000),
                new Employee("David", "IT", 50000),
                new Employee("Eva", "Finance", 70000)
        );

        // 1. Find all employees who work in the "IT" department and have a salary greater than 50,000
        List<String> filteredNames = employees.stream()
                .filter(e -> "IT".equals(e.getDepartment()) && e.getSalary() > 50000)
                .map(e -> e.getName().toUpperCase())
                .toList();

        // Print the list of names
        System.out.println("Employees in IT with salary greater than 50,000 (uppercase): " + filteredNames);

        // 2. Calculate the average salary of employees in the "IT" department
        double averageSalary = employees.stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        // Print the average salary
        System.out.println("Average salary of employees in IT department: " + averageSalary);
    }
}
