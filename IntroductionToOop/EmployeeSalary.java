package IntroductionToOop;

import java.util.Locale;
import java.util.Scanner;

class Employee {
  private String name;

  private double grossSalary;

  private double tax;

  public Employee(final String name, final double grossSalary, final double tax) {
    this.name = name;
    this.grossSalary = grossSalary;
    this.tax = tax;
  }

  public double netSalary() {
    return grossSalary - tax;
  }

  public void increaseSalary(double percentage) {
    grossSalary += grossSalary * percentage / 100.0;
  }

  @Override
  public String toString() {
    return String.format("%s, $ %.2f", name, netSalary());
  }
}

public class EmployeeSalary {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the employee name:");
    final String name = scanner.nextLine();

    System.out.println("Enter the employee gross salary:");
    final double grossSalary = scanner.nextDouble();

    System.out.println("Enter the tax:");
    final double tax = scanner.nextDouble();

    Employee employee = new Employee(name, grossSalary, tax);

    System.out.println("NAME: " + name);
    System.out.printf("GROSS SALARY: %.2f \n", grossSalary);
    System.out.printf("TAX: %.2f \n", tax);

    System.out.println("Employee: " + employee);

    System.out.println("Which percentage to increase in salary?");
    final double percentageToIncrease = scanner.nextDouble();

    employee.increaseSalary(percentageToIncrease);

    System.out.println("Updated data: " + employee);

    scanner.close();
  }
}
