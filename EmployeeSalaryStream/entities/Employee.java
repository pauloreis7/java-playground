package EmployeeSalaryStream.entities;

public class Employee {
  private final String name;
  private final String email;
  private final double salary;

  public Employee(final String name, final String email, final double salary) {
    this.name = name;
    this.email = email;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public double getSalary() {
    return salary;
  }
}
