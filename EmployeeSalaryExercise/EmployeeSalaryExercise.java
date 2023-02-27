package EmployeeSalaryExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeSalaryExercise {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Type the amount of employee to be entered:");
    int amount = scanner.nextInt();

    List<Employee> employees = new ArrayList<>();

    for (int i = 0; i < amount; i++) {
      System.out.println();
      System.out.println("Employee #" + (i + 1) + ':');

      System.out.print("Id: ");
      int id = scanner.nextInt();

      scanner.nextLine();

      System.out.print("Name: ");
      String name = scanner.nextLine();

      System.out.print("Salary: ");
      double salary = scanner.nextDouble();

      Employee employee = new Employee(id, name, salary);

      employees.add(employee);
    }

    System.out.println();
    System.out.print("Enter the employee id that will have salary increase: ");
    int idToIncrease = scanner.nextInt();

    Employee employeeToIncrese = findById(employees, idToIncrease);

    if (employeeToIncrese == null) {
      System.out.println("This id does not exist!");
    } else {
      System.out.print("Enter the percentage:");
      double percentToIncrease = scanner.nextDouble();

      employeeToIncrese.increaseSalary(percentToIncrease);
    }

    System.out.println();
    System.out.println("List of employees:");
    for (Employee item : employees) {
      System.out.println(item);
    }

    scanner.close();
  }

  private static Employee findById(List<Employee> employees, int id) {

    return employees.stream().filter(employee -> employee.getId() == id).findFirst()
        .orElse(null);
  }

}
