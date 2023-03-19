package EmployeeSalaryStream.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import EmployeeSalaryStream.entities.Employee;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner scanner = new Scanner(System.in);

    final String csvPath = "EmployeeSalaryStream/data/employees.csv";

    final List<Employee> employees = new ArrayList<>();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvPath))) {
      String line = bufferedReader.readLine();

      while (line != null) {
        final String[] fields = line.split(",");
        final String name = fields[0];
        final String email = fields[1];
        final double salary = Double.parseDouble(fields[2]);

        employees.add(new Employee(name, email, salary));

        line = bufferedReader.readLine();
      }

      System.out.println("Enter the min salary to compare: ");
      final double salaryToCompare = scanner.nextDouble();

      final List<String> emails = employees.stream()
          .filter(employee -> employee.getSalary() > salaryToCompare)
          .map(employee -> employee.getEmail())
          .sorted()
          .collect(Collectors.toList());

      final double salaryAverageByFilter = employees.stream()
          .filter(employee -> employee.getName().charAt(0) == 'M')
          .map(employee -> employee.getSalary())
          .reduce(0.0, (x, y) -> x + y);

      System.out.println();
      System.out.println(
          "Email of people whose salary is more than " + String.format("%.2f", salaryToCompare) + ":");
      emails.forEach(System.out::println);
      System.out.println();

      System.out.println(
          "Sum of salary of people whose name starts with 'M': " + String.format("%.2f", salaryAverageByFilter));

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    } finally {
      scanner.close();
    }
  }
}
